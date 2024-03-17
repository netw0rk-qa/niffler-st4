package guru.qa.niffler.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.niffler.jupiter.GenerateSpend;
import guru.qa.niffler.model.CurrencyValues;
import guru.qa.niffler.model.SpendJson;
import guru.qa.niffler.test.pages.LoginPage;
import guru.qa.niffler.test.pages.WelcomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SpendingTest {
  private final LoginPage loginPage = new LoginPage();
  private final WelcomePage welcomePage = new WelcomePage();

  static {
    Configuration.browserSize = "1980x1024";
  }

  @BeforeEach
  void doLogin() {
    Selenide.open("http://127.0.0.1:3000/main");
    welcomePage.gotoLoginForm();
    loginPage.fillAndSubmit("duck", "12345");
  }

  @GenerateSpend(
      username = "duck",
      description = "QA.GURU Advanced 4",
      amount = 72500.00,
      category = "Обучение",
      currency = CurrencyValues.RUB
  )
  @Test
  void spendingShouldBeDeletedByButtonDeleteSpending(SpendJson spend) {
    $(".spendings-table tbody")
        .$$("tr")
        .find(text(spend.description()))
        .$$("td")
        .first()
        .click();

    $(byText("Delete selected"))
        .click();

    $(".spendings-table tbody")
        .$$("tr")
        .shouldHave(size(0));
  }
}
