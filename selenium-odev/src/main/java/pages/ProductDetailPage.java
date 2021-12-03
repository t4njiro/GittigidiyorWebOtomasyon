package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = new By.ByXPath("//*[@id='add-to-basket']");
    By goToCartButtonLocator = new By.ByCssSelector("a.gg-ui-btn-default.padding-none");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public void goToCart() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        try{
            click(goToCartButtonLocator);
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", find(goToCartButtonLocator));
        }

    }
}
