package org.vadim.home.pages;

import lombok.Data;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class SignUpPage extends BasePage {
  @FindBy(xpath = "//input[@id='sign-username']")
  private WebElement usernameField;
  @FindBy(xpath = "//input[@id='sign-password']")
  private WebElement passwordField;
  @FindBy(xpath = "//button[@type='button'][contains(text(), 'Sign up')]")
  private WebElement signUpButton;

  public SignUpPage fillingUsernameField(String username) {
    usernameField.sendKeys(username);
    return this;
  }

  public SignUpPage fillingPasswordField(String password) {
    passwordField.sendKeys(password);
    return this;
  }

  public SignUpPage clickOnSignUpButton() {
    signUpButton.click();
    return this;
  }

  public Alert switchToAlert() {
    wait.until(ExpectedConditions.alertIsPresent());
    return driver.switchTo().alert();
  }
}
