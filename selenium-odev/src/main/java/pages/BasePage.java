package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    WebDriver driver;
    By homePageButtonLocator = new By.ByCssSelector("div.sc-1o6eogh-1.drryHP");
    By acceptCookiesLocator = new By.ByXPath("//*[@id='__next']/main/div[2]/section[1]/section[2]");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void hover(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(find(locator)).build().perform();
    }

    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    public void clear(By locator){
        find(locator).clear();
    }

    public void scrollDown(){
        find(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public void scrollDownTo(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 80)");
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void waitElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void directToHomePage(){
        click(homePageButtonLocator);
    }

    public void acceptCookies(){
        click(acceptCookiesLocator);
    }

    public void newHomeTab(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");
    }

}
