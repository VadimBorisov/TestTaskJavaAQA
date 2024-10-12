package org.vadim.home.services;

import org.vadim.home.models.User;
import org.vadim.home.pages.IndexPage;

public class IndexPageService {
  private final String INDEX_PAGE_URL = "https://www.demoblaze.com/index.html";
  private final IndexPage indexPage = new IndexPage();

  public void openPage() {
    indexPage.openPage(INDEX_PAGE_URL);
  }

  public IndexPage signUp(User user) {
    indexPage.openPage(INDEX_PAGE_URL)
            .clickOnSignUp()
            .fillingUsernameField(user.getUsername())
            .fillingPasswordField(user.getPassword())
            .clickOnSignUpButton()
            .switchToAlert()
            .accept();

    return indexPage;
  }

  public IndexPage signIn(User user) {
    indexPage.openPage(INDEX_PAGE_URL)
            .clickOnLogIn()
            .fillingUsernameField(user.getUsername())
            .fillingPasswordField(user.getPassword())
            .clickOnLogInButton();

    return indexPage;
  }

  public IndexPage selectCategory(int category) {
    indexPage.clickOnCategory(category);
    return indexPage;
  }

  public ProductPageService selectProduct(int product) {
    indexPage.clickOnItemProduct(product);
    return new ProductPageService();
  }

  public int getCategorySize() {
    return indexPage.getCategoryListSize();
  }

  public int getProductsSize() {
    return indexPage.getItemListSize();
  }

  public String getOneProductPriceFromList(int index) {
    return indexPage.getPriceElementFromProducts(index);
  }

  public void enterToCart() {
    indexPage.clickOnCartButton();
  }
}
