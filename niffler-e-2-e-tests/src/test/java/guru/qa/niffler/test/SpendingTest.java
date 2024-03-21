package guru.qa.niffler.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.niffler.jupiter.GenerateCategory;
import guru.qa.niffler.jupiter.GenerateSpend;
import guru.qa.niffler.model.CurrencyValues;
import guru.qa.niffler.model.SpendJson;
import guru.qa.niffler.test.pages.LoginPage;
import guru.qa.niffler.test.pages.MainPage;
import guru.qa.niffler.test.pages.WelcomePage;
import guru.qa.niffler.test.pages.blocks.Columns;
import guru.qa.niffler.test.pages.blocks.HistoryBlock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpendingTest {
  private final LoginPage loginPage = new LoginPage();
  private final WelcomePage welcomePage = new WelcomePage();
  private final HistoryBlock history = new MainPage().history;

  static {
    Configuration.browserSize = "1980x1024";
    Configuration.browserVersion = "120.0";
  }

  @BeforeEach
  void doLogin() {
    Selenide.open("http://127.0.0.1:3000/main");
    welcomePage.gotoLoginForm();
    loginPage.fillAndSubmit("duck", "12345");
  }

  @GenerateCategory(
      username = "duck",
      description = "Обучение"
  )
  @GenerateSpend(
      username = "duck",
      description = "QA.GURU Advanced 4",
      amount = 72500.00,
      category = "Обучение",
      currency = CurrencyValues.RUB
  )
  @Test
  void spendingShouldBeDeletedByButtonDeleteSpending(SpendJson spend) {
    history.getCell(0, Columns.CHECKBOX).click();
    history.clickOnDeleteButton();
    history.checkRowsSize(0);
  }
}
