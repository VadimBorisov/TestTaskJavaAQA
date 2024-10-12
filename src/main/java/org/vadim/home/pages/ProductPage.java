package org.vadim.home.pages;

import lombok.Data;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class ProductPage extends BasePage {
  @FindBy(xpath = "//a[contains(text(), 'Add to cart')]")
  private WebElement addToCartButton;

  @FindBy(xpath = "//a[contains(text(), 'Home')]")
  private WebElement homeButton;

  @FindBy(xpath = "//h3[contains(text(), '$')]")
  private WebElement productPrice;

  public ProductPage clickOnAddToCartButton() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    addToCartButton.click();
    wait.until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
    return this;
  }

  public ProductPage clickOnHomeButton() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    homeButton.click();
    return this;
  }

  public String getTextFromProductPriceElem() {
    return productPrice.getText();
  }
}
