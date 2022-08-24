package com.finaltest.selenium.pages;

import com.finaltest.selenium.keyword.ActionKeyword;
import com.finaltest.selenium.pages.components.forms.GuestForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestCheckoutStep1Page extends BasePage{
    private GuestForm guestForm;
    public GuestCheckoutStep1Page(WebDriver driver) {
        super(driver);
        guestForm = new GuestForm(super.driver);
    }
    private String btnContinue = "#continue";
    String txtTitle = "//span[text()='Checkout: Your Information']";

    /**
     * The function to search and return the First Name field.
     * @return First Name field.
     */
    public WebElement getFirstNameField() {
        return guestForm.getFieldByName("firstName");
    }

    /**
     * The function to search and return the Last Name field.
     * @return Last Name field.
     */
    public WebElement getLastNameField() {
        return guestForm.getFieldByName("lastName");
    }

    /**
     * The function to search and return the Postcode field.
     * @return Address 1 field.
     */
    public WebElement getPostCodeField() {
        return guestForm.getFieldByName("postalCode");
    }

    /**
     * The function to search and return the Continue button.
     * @return Continue button.
     */
    public WebElement getContinueButton() {
        return this.driver.findElement(By.cssSelector(btnContinue));
    }

    /**
     * The function to press the Continue button.
     */
    public void goToGuestCheckoutStep2Page() {
        actionKeyword.click(getContinueButton());;
    }

    /**
     * Function to enter information and move to the next page.
     * @param firstName
     * @param lastName
     * @param postCode
     * @return Guest Checkout Page (step 2).
     * @throws InterruptedException
     */
    public CheckoutConfirmationPage enterContentsAndGoToGuestCheckoutStep2Page(
            String firstName, String lastName, String postCode) {
        guestForm.enterContentInField(getFirstNameField(), firstName);
        guestForm.enterContentInField(getLastNameField(), lastName);
        guestForm.enterContentInField(getPostCodeField(), postCode);
        goToGuestCheckoutStep2Page();
        return new CheckoutConfirmationPage(this.driver);
    }

    /**
     * Function to find and return title of page.
     * @return Proceed to Checkout button.
     */
    public WebElement getTitle() {
        return this.driver.findElement(By.xpath(txtTitle));
    }
}
