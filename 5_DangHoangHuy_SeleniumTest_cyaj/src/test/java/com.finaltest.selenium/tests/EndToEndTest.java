package com.finaltest.selenium.tests;

import com.finaltest.selenium.configuration.Configuration;
import com.finaltest.selenium.data.TestData;
import com.finaltest.selenium.driver.DriverFactory;
import com.finaltest.selenium.keyword.ActionKeyword;
import com.finaltest.selenium.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class EndToEndTest extends BaseTest{
    public ActionKeyword actionKeyword;

    @BeforeTest
    public void beforeTest() {
//        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        System.out.println("BeforeTest ran successfully!");
    }

    @BeforeMethod
    public void before() throws Exception {
        Configuration config = new Configuration("src/test/resources/finaltest.properties");
        driver = DriverFactory.getDriver(config.getProperty("browser"));
        actionKeyword = new ActionKeyword(driver);
        actionKeyword.checkUrl(config.getProperty("url"));
        System.out.println("BeforeMethod ran successfully!");
    }

    /**
     * The function tests the purchase process with products on the Art page. The data is provided from the Json file.
     * @param username
     * @param password
     * @param firstName Orderer's first name.
     * @param lastName Orderer's last name.
     * @param postCode Post code.
     * @throws InterruptedException
     */
    @Test(dataProvider = "getOrderJsonData", dataProviderClass = TestData.class)
    public void verifyOrderProductSuccessfullyWithJsonData(
            String username, String password, String id,
            String firstName, String lastName, String postCode, String end) throws InterruptedException {
        LoginPage loginPage1 = new LoginPage(driver);
        if (username.equals("locked_out_user")) {
            loginPage1.login(username, password);
            Assert.assertTrue(loginPage1.getErrorLabel().isDisplayed());
        } else if (username.equals("problem_user")) {
            ProductList productList = loginPage1
                    .login(username, password);
            Assert.assertTrue(productList.getDogPicture().isDisplayed());
        } else {
            ProductList productList = loginPage1
                    .login(username, password);
            String description = productList.getDescription(id);
            CartPage cartPage = productList
                    .selectProductById(id)
                    .addProductToCart();

            Assert.assertTrue(cartPage.getTitle().isDisplayed());

            GuestCheckoutStep1Page guestCheckoutStep1Page = cartPage.clickContinueButton();

            Assert.assertTrue(guestCheckoutStep1Page.getTitle().isDisplayed());

            CheckoutConfirmationPage checkoutConfirmationPage = guestCheckoutStep1Page.enterContentsAndGoToGuestCheckoutStep2Page(
                    firstName,
                    lastName,
                    postCode);
            Assert.assertTrue(checkoutConfirmationPage.isNumber());
            Assert.assertTrue(checkoutConfirmationPage.compareDescription(description));
            if (end.equals("finish")) {
                SuccessPage successPage = checkoutConfirmationPage.goToSuccessPage();
                Thread.sleep(1000);
                Assert.assertTrue(successPage.getHeaderLabel().isDisplayed());
            } else {
                ProductList productList2 = checkoutConfirmationPage.cancel();
                Thread.sleep(1000);
                Assert.assertTrue(productList2.getTitle().isDisplayed());
            }
        }
    }

    /**
     * The function tests the purchase process with products on the art page. The data is provided from the Excel file.
     * @param username
     * @param password
     * @param firstName Orderer's first name.
     * @param lastName Orderer's last name.
     * @param postCode Post code.
     * @throws InterruptedException
     */
    @Test(dataProvider = "getOrderExcelData", dataProviderClass = TestData.class)
    public void verifyOrderProductSuccessfullyWithExcelData(
            String username, String password, String id,
            String firstName, String lastName, String postCode, String end) throws InterruptedException {
        LoginPage loginPage1 = new LoginPage(driver);
        if (username.equals("locked_out_user")) {
            loginPage1.login(username, password);
            Assert.assertTrue(loginPage1.getErrorLabel().isDisplayed());
        } else if (username.equals("problem_user")) {
            ProductList productList = loginPage1
                    .login(username, password);
            Assert.assertTrue(productList.getDogPicture().isDisplayed());
        } else {
            ProductList productList = loginPage1
                    .login(username, password);
            String description = productList.getDescription(id);
            CartPage cartPage = productList
                    .selectProductById(id)
                    .addProductToCart();

            Assert.assertTrue(cartPage.getTitle().isDisplayed());

            GuestCheckoutStep1Page guestCheckoutStep1Page = cartPage.clickContinueButton();

            Assert.assertTrue(guestCheckoutStep1Page.getTitle().isDisplayed());

            CheckoutConfirmationPage checkoutConfirmationPage = guestCheckoutStep1Page.enterContentsAndGoToGuestCheckoutStep2Page(
                    firstName,
                    lastName,
                    postCode);
            Assert.assertTrue(checkoutConfirmationPage.isNumber());
            Assert.assertTrue(checkoutConfirmationPage.compareDescription(description));
            if (end.equals("finish")) {
                SuccessPage successPage = checkoutConfirmationPage.goToSuccessPage();
                Thread.sleep(1000);
                Assert.assertTrue(successPage.getHeaderLabel().isDisplayed());
            } else {
                ProductList productList2 = checkoutConfirmationPage.cancel();
                Thread.sleep(1000);
                Assert.assertTrue(productList2.getTitle().isDisplayed());
            }
        }
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        driver.quit();
        System.out.println("AfterMethod ran successfully!");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test completed!");
    }
}
