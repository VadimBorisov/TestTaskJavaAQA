package UI.tests;

import org.apache.commons.logging.impl.SLF4JLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vadim.home.driver.DriverSingleton;

public class BaseTest {
  protected static final Logger LOGGER = LogManager.getLogger(SLF4JLog.class);
  public static void closeBrowser() {
    DriverSingleton.getInstance().close();
  }
}
