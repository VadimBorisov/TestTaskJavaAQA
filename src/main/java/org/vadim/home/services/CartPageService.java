package org.vadim.home.services;

import org.vadim.home.pages.CartPage;

public class CartPageService {
  private final CartPage cartPage = new CartPage();

  public boolean compareTotalPrice() {
    int sum = 0;
    int quantityItemsInCart = cartPage.getSizeProductPricesList();
    for(int i = 0; i < quantityItemsInCart; i++) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      sum += Integer.parseInt(cartPage.getProductPriceText(i));
    }

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return sum == Integer.parseInt(cartPage.getTotalPriceText());
  }

  public void placeOrder() {
    cartPage.clickOnPlaceOrderButton();
  }
}
