package UI.tests;

import org.instancio.Instancio;
import org.instancio.Select;
import org.instancio.generators.Generators;
import org.junit.jupiter.api.*;
import org.vadim.home.models.User;
import org.vadim.home.services.CartPageService;
import org.vadim.home.services.IndexPageService;
import org.vadim.home.services.PlaceOrderPageService;
import org.vadim.home.services.ProductPageService;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EndToEndTest extends BaseTest {
  static IndexPageService indexPageService;
  static ProductPageService productPageService;
  static CartPageService cartPageService;
  static PlaceOrderPageService placeOrderPageService;
  static User user;

  /**
   * В BeforeAll предварительно регистрируем и авторизуем пользователя
   */
  @BeforeAll
  static void setUp() {
    indexPageService = new IndexPageService();
    productPageService = new ProductPageService();
    cartPageService = new CartPageService();
    placeOrderPageService = new PlaceOrderPageService();

    user = Instancio.of(User.class)
            .generate(Select.field(User::getUsername), Generators::string)
            .generate(Select.field(User::getPassword), Generators::string)
            .generate(Select.field(User::getName), Generators::string)
            .generate(Select.field(User::getCreditCard), Generators::string)
            .create();

    indexPageService.signUp(user);
    indexPageService.signIn(user);
  }

  @AfterAll
  static void quitBrowser() {
    closeBrowser();
  }

  @Test
  @DisplayName("Добавление товара в корзину и сравнение цен по отдельности")
  @Order(1)
  public void addToCartAndCheckPriceTest() {
    int categoryListSize = indexPageService.getCategorySize();

    for(int i = 1; i < categoryListSize; i++) {
      indexPageService.selectCategory(i);
      Random rnd = new Random();
      int productIndex = rnd.nextInt(indexPageService.getProductsSize());
      String productPriceOnIndexPage = indexPageService.getOneProductPriceFromList(productIndex);
      indexPageService.selectProduct(productIndex);
      String priceOnProductPage = productPageService.getProductPrice().substring(0, productPriceOnIndexPage.length());

      Assertions.assertEquals(priceOnProductPage, productPriceOnIndexPage,
              "Цена в общем списке и на карточке продукта не совпадают!");

      productPageService.addProductToCartAndReturnHome();
    }
  }

  @Test
  @DisplayName("Вход в корзину и проверка общей цены")
  @Order(2)
  public void totalCartPriceTest() {
    indexPageService.enterToCart();
    Assertions.assertTrue(cartPageService.compareTotalPrice(),
            "Сумма цен отдельно и показатель Total не совпадают");
  }

  @Test
  @DisplayName("Завершение заказа и проверка даты")
  @Order(3)
  public void confirmOrderAndCheckDateTest() {
    cartPageService.placeOrder();
    Assertions.assertTrue(placeOrderPageService.confirmOrderAndCheckDate(user),
            "Даты не совпадают");
  }
}
