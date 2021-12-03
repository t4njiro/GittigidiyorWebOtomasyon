package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    By loginHoverLocator = new By.ByCssSelector("div.gekhq4-5.grTfZj");
    By loginButtonLocator = new By.ByCssSelector("a.qjixn8-0.sc-1bydi5r-0.lghPw");

    By myAccountLocator = new By.ByCssSelector("div.gekhq4-4.egoSnI");

    By searchBoxLocator = new By.ByCssSelector("input.sc-4995aq-0.sc-14oyvky-0.gHqOYK");
    By getSearchBoxButtonLocator = new By.ByCssSelector("button.qjixn8-0.sc-1bydi5r-0.gaMakD");

    By profileHoverLocator = By.name("profile");
    By logoutButtonLocator = new By.ByCssSelector("a[title='Çıkış']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public boolean isOnHomePage(){
        return isDisplayed(myAccountLocator);
    }

    public boolean isLoggedIn(){
        try{
            By check = new By.ByCssSelector("div[title='Hesabım']");
            return isDisplayed(check);
        }catch (Exception e){
            return false;
        }
    }

    public void selectLogin() {
        hover(loginHoverLocator);
        waitElement(loginButtonLocator);
        click(loginButtonLocator);
    }

    public void searchProduct(String product){
        clear(searchBoxLocator);
        type(searchBoxLocator, product);
        click(getSearchBoxButtonLocator);
    }

    public void selectLogout(){
        hover(profileHoverLocator);
        waitElement(logoutButtonLocator);
        click(logoutButtonLocator);
    }

}
