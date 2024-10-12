package UI.tests;

import org.vadim.home.driver.DriverSingleton;

public class BaseTest {
  public static void closeBrowser() {
    DriverSingleton.getInstance().close();
  }
}
