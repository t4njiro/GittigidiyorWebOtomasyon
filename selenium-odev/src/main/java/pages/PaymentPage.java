package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{

    By saveButtonLocator = new By.ByXPath("//*[@id='AdrEditPopup']/div/div[5]/div[2]/button");
    By errorMessageLocator = new By.ByCssSelector("div.gg-input-error-text.gg-d-24");
    By editCartButtonLocator = new By.ByXPath("//*[@id='CCPost']/div[1]/div[5]/div[1]/div/table/tbody/tr/td[3]/p/a");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPaymentPage(){
        return isDisplayed(saveButtonLocator);
    }

    public void saveInfo() throws InterruptedException {
        click(saveButtonLocator);
    }

    public Boolean isNegative(){
        return isDisplayed(errorMessageLocator);
    }

    public void editCart(){
        click(editCartButtonLocator);
    }



}
