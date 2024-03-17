package guru.qa.niffler.test.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;

public class WelcomePage {
    private final SelenideElement loginButton = $("a.main__link[href*=redirect]");
    private final SelenideElement registerButton = $("a.main__link[href*=register]");

    public void gotoLoginForm(){
        loginButton.click();
    }
}
