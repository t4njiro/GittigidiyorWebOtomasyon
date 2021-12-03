package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsPage extends BasePage{

    By favButtonLocator = new By.ByCssSelector("div.sc-1n49x8z-14.fIkZfb");
    By productLocator;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void goToProductDetail(String idx){
        productLocator = new By.ByXPath("//*[@id='__next']/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li[" + idx + "]/article/div[2]");
        click(productLocator);
    }

    public List<WebElement> addProductToFav(int amount) throws InterruptedException {
        List<WebElement> favs = new ArrayList<>();
        List<Integer> randlist = new ArrayList<>();

        int count = 0;
        while (count != amount){
            int randIdx = (int)(Math.random() * 10);
            if(!(randlist.contains(randIdx))){
                randlist.add(randIdx);
                try{
                    getAllProducts(favButtonLocator).get(randIdx).click();
                }catch (Exception e){
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", getAllProducts(favButtonLocator).get(randIdx));
                }finally {
                    favs.add(getAllProducts(favButtonLocator).get(randIdx));
                }
                TimeUnit.MILLISECONDS.sleep(500);
                count++;
            }
        }

        return favs;
    }

    private List<WebElement> getAllProducts(By locator){
        return findAll(locator);
    }

}
