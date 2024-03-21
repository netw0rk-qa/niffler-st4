package guru.qa.niffler.test.pages;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement usernameField = $("input[name=username]");
    private final SelenideElement passwordField = $("input[name=password]");
    private final SelenideElement submitButton = $("button[type='submit']");

    public void fillAndSubmit(String login, String password){
        usernameField.setValue(login);
        passwordField.setValue(password);
        submitButton.click();
    }
}
