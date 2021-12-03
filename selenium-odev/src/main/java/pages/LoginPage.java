package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By userNameLocator = By.id("L-UserNameField");
    By passwordLocator = By.id("L-PasswordField");
    By loginButtonLocator = By.id("gg-login-enter");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void performLogin() {
        type(userNameLocator, "irisakbeniz443406");
        type(passwordLocator, "deneme1234");
        click(loginButtonLocator);
    }
}
