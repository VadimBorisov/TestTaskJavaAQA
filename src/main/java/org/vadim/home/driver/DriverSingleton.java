package org.vadim.home.driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
  private static ThreadLocal<DriverSingleton> instance = new ThreadLocal<>();
  private WebDriver webDriver;

  private DriverSingleton() {
    webDriver = WebDriverFactory.getWebDriver();
  }

  public static synchronized DriverSingleton getInstance() {
    if(null == instance.get()) {
      instance.set(new DriverSingleton());
    }

    return instance.get();
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  public void close() {
    try {
      webDriver.quit();
      webDriver = null;
    } finally {
      instance.remove();
    }
  }
}
