package org.vadim.home.services;

import org.openqa.selenium.WebElement;
import org.vadim.home.models.User;
import org.vadim.home.pages.PlaceOrderPage;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class PlaceOrderPageService {
  private final PlaceOrderPage placeOrderPage = new PlaceOrderPage();

  public boolean confirmOrderAndCheckDate(User user) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    placeOrderPage.fillingNameField(user.getName())
            .fillingCreditCardField(user.getCreditCard());

    placeOrderPage.clickOnPurchaseButton();

    String[] result = placeOrderPage.getTextFromWebElement(placeOrderPage.getThanksForPurchase()).split(" ");

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    try {
      calendar.setTime(format.parse(result[result.length - 1]));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

    int orderDay = calendar.get(Calendar.DAY_OF_MONTH);

    /* здесь я добавляю 2 т.к. на сайте отсчёт месяцев ведётся от 0 и Calendar уменьшает это значение ещё на 1*/
    int orderMonth = calendar.get(Calendar.MONTH) + 2;

    int orderYear = calendar.get(Calendar.YEAR);

    calendar.setTime(Date.valueOf(LocalDate.now()));

    int systemDay = calendar.get(Calendar.DAY_OF_MONTH);

    /* здесь я добавляю 1 т.к. Calendar уменьшает фактическое значение на 1*/
    int systemMonth = calendar.get(Calendar.MONTH) + 1;

    int systemYear = calendar.get(Calendar.YEAR);

    return (orderDay + orderMonth + orderYear) == (systemDay + systemYear + systemMonth);
  }
}
