package org.vadim.home.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverFactory {
  private WebDriverFactory() {
  }

  public static WebDriver getWebDriver() {
    WebDriver webDriver = null;
    switch (System.getProperty("browser", "chrome")) {
      case "firefox": {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        break;
      }
      default: {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito", "--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
      }
    }
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    return webDriver;
  }
}
