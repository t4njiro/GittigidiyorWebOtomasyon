import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.*;

public class Tests extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    PaymentPage paymentPage;

    @Test
    @Order(0)
    public void login() {
        homePage = new HomePage(driver);
        homePage.selectLogin();
        loginPage = new LoginPage(driver);
        loginPage.performLogin();

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        paymentPage = new PaymentPage(driver);
        productDetailPage = new ProductDetailPage(driver);

        Assertions.assertTrue(homePage.isLoggedIn(), "Could not login");
    }

    @Test
    @Order(1)
    public void addProductToFav() throws InterruptedException {
        homePage.acceptCookies();
        homePage.searchProduct("kolye");

        productsPage.scrollDown();

        int addedCount = productsPage.addProductToFav(4).size();

        Assertions.assertEquals(addedCount, 4, "Could not add 4 products to fav list");
    }

    @Test
    @Order(2)
    public void searchAndAdd() throws InterruptedException {
        productsPage.directToHomePage();
        homePage.searchProduct("çanta");
        productsPage.goToProductDetail("7");

        productDetailPage.addToCart();
        productDetailPage.goToCart();

        cartPage.incrementAmount();
        cartPage.goToPayment();

        Assertions.assertTrue(paymentPage.isOnPaymentPage(), "Adding product failed");

    }

    @Test
    @Order(3)
    public void paymentNegative() throws InterruptedException {
        paymentPage.saveInfo();

        Assertions.assertTrue(paymentPage.isNegative(), "Could not see the error messages");
    }

    @Test
    @Order(4)
    public void editCart(){
        paymentPage.scrollDownTo();
        paymentPage.editCart();

        Assertions.assertTrue(cartPage.isOnCartPage(), "Could not go to edit cart page");
    }

    @Test
    @Order(5)
    public void addToCartFromFav(){
        cartPage.addToCartFromFav();
        cartPage.deleteFromFav();
        cartPage.newHomeTab();

        Assertions.assertTrue(homePage.isOnHomePage(), "Could not direct to home page");
    }

    @Test
    @Order(6)
    public void logout() {
        homePage.selectLogout();

        Assertions.assertFalse(homePage.isLoggedIn(),"Could not logout");
    }

}
