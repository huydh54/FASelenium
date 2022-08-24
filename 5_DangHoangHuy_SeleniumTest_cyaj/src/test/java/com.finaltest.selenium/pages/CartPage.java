package com.finaltest.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    String btnProceedToCheckout = "#checkout";
    String txtTitle = "//span[text()='Your Cart']";

    /**
     * Function to find and return the Proceed to Checkout button.
     * @return Proceed to Checkout button.
     */
    public WebElement getProceedToCheckoutButton() {
        return this.driver.findElement(By.cssSelector(btnProceedToCheckout));
    }

    /**
     * Press the button to move to the Login page.
     * @return Login page.
     */
    public GuestCheckoutStep1Page clickContinueButton() {
        actionKeyword.click(this.getProceedToCheckoutButton());
        return new GuestCheckoutStep1Page(this.driver);
    }

    /**
     * Function to find and return title of page.
     * @return Proceed to Checkout button.
     */
    public WebElement getTitle() {
        return this.driver.findElement(By.xpath(txtTitle));
    }
}
