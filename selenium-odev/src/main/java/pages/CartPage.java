package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage{

    By amountLocator = new By.ByCssSelector("select[class='amount']");
    By incrementLocator = new By.ByCssSelector("select[class='amount'] option[value='2']");
    By goToPaymentLocator = new By.ByXPath("//*[@id='cart-continue-button-container']/input");
    By addToCartFromFav2Locator = new By.ByXPath("//*[@id='save-for-later-slider']/div/div/div/div/div/div/ul/li[6]/div/a[2]");
    By deleteFromFavLocator = new By.ByCssSelector("a[class='btn-delete']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage(){
        return isDisplayed(amountLocator);
    }

    public void incrementAmount() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);

        try{
            click(amountLocator);
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", find(amountLocator));
        }

        try{
            click(incrementLocator);
        }catch(Exception e){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", find(incrementLocator));
        }

    }

    public void goToPayment(){
        click(goToPaymentLocator);
    }

    public void addToCartFromFav(){
        click(addToCartFromFav2Locator);
    }

    public void deleteFromFav(){
        WebElement deleteFromFav3 = findAll(deleteFromFavLocator).get(2);
        try {
            deleteFromFav3.click();
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", deleteFromFav3);
        }

    }
}
