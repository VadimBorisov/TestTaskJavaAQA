package org.vadim.home.pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class CartPage extends BasePage {
  @FindBy(xpath = "//tbody[@id='tbodyid']//td[3]")
  private List<WebElement> productPrices;

  @FindBy(xpath = "//h3[@id='totalp']")
  private WebElement totalPrice;

  @FindBy(xpath = "//button[contains(text(), 'Place Order')]")
  private WebElement placeOrderButton;

  public String getProductPriceText(int idx) {
    return productPrices.get(idx).getText();
  }

  public String getTotalPriceText() {
    return totalPrice.getText();
  }

  public void clickOnPlaceOrderButton() {
    placeOrderButton.click();
  }

  public int getSizeProductPricesList() {
    return productPrices.size();
  }
}
