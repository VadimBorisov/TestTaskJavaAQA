package org.vadim.home.pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class PlaceOrderPage extends BasePage {
  @FindBy(xpath = "//input[@id='name']")
  private WebElement nameField;

  private WebElement countryField;
  private WebElement cityField;

  @FindBy(xpath = "//input[@id='card']")
  private WebElement creditCardField;


  private WebElement monthField;
  private WebElement yearField;

  @FindBy(xpath = "//button[contains(text(), 'Purchase')]")
  private WebElement purchaseButton;

  @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']/p")
  private WebElement thanksForPurchase;

  public void clickOnPurchaseButton() {
    purchaseButton.click();
  }

  public PlaceOrderPage fillingNameField(String name) {
    nameField.sendKeys(name);
    return this;
  }

  public PlaceOrderPage fillingCountryField(String name) {
    countryField.sendKeys(name);
    return this;
  }

  public PlaceOrderPage fillingCityField(String name) {
    cityField.sendKeys(name);
    return this;
  }
  public PlaceOrderPage fillingCreditCardField(String name) {
    creditCardField.sendKeys(name);
    return this;
  }
  public PlaceOrderPage fillingMonthField(String name) {
    monthField.sendKeys(name);
    return this;
  }
  public PlaceOrderPage fillingYearField(String name) {
    yearField.sendKeys(name);
    return this;
  }

  public String getTextFromWebElement(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
    return element.getText();
  }
}
