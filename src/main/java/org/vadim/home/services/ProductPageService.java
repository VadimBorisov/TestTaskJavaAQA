package org.vadim.home.services;

import org.vadim.home.pages.ProductPage;

public class ProductPageService {
  private final ProductPage productPage = new ProductPage();

  public void addProductToCartAndReturnHome() {
    productPage.clickOnAddToCartButton();
    productPage.clickOnHomeButton();
  }

  public String getProductPrice() {
    return productPage.getProductPrice().getText();
  }
}
