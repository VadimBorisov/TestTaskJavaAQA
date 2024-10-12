package org.vadim.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vadim.home.driver.DriverSingleton;

import java.time.Duration;

public class BasePage {
  protected WebDriver driver = DriverSingleton.getInstance().getWebDriver();
  protected WebDriverWait wait;

  protected BasePage() {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }
}
