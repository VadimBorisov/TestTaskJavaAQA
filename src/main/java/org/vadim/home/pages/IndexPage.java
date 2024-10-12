package org.vadim.home.pages;

import lombok.Data;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Data
public class IndexPage extends BasePage {
  private final SignUpPage signUpPage = new SignUpPage();
  private final LogInPage logInPage = new LogInPage();

  @FindBy(xpath = "//a[@id='signin2']")
  private WebElement signUp;
  @FindBy(xpath = "//a[@id='login2']")
  private WebElement logIn;

  @FindBy(xpath = "//div[@class='list-group']/a")
  private List<WebElement> categories;

  @FindBy(xpath = "//div[@id='tbodyid']//h4/a")
  private List<WebElement> items;

  @FindBy(xpath = "//div[@id='tbodyid']//h4/a/../following-sibling::h5")
  private List<WebElement> priceElements;

  @FindBy(xpath = "//a[@id='cartur']")
  private WebElement cartButton;

  public IndexPage clickOnCartButton() {
    cartButton.click();
    return this;
  }

  public IndexPage openPage(String url) {
    driver.get(url);
    return this;
  }

  public SignUpPage clickOnSignUp() {
    signUp.click();
    return signUpPage;
  }

  public LogInPage clickOnLogIn() {
    logIn.click();
    return logInPage;
  }

  public IndexPage clickOnCategory(int index) {
    try {
      Thread.sleep(1000);
      categories.get(index).click();
      return this;
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public ProductPage clickOnItemProduct(int index) {
    try {
      Thread.sleep(1000);
      items.get(index).click();
      return new ProductPage();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public int getCategoryListSize() {
    return categories.size();
  }

  public int getItemListSize() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return items.size();
  }

  public String getPriceElementFromProducts(int index) {
    return priceElements.get(index).getText();
  }
}
