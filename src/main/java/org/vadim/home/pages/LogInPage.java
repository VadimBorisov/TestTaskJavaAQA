package org.vadim.home.pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class LogInPage extends BasePage {
  @FindBy(xpath = "//input[@id='loginusername']")
  private WebElement usernameField;

  @FindBy(xpath = "//input[@id='loginpassword']")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@type='button'][contains(text(), 'Log in')]")
  private WebElement logInButton;

  public LogInPage fillingUsernameField(String username) {
    usernameField.sendKeys(username);
    return this;
  }

  public LogInPage fillingPasswordField(String password) {
    passwordField.sendKeys(password);
    return this;
  }

  public void clickOnLogInButton() {
    logInButton.click();
  }
}
