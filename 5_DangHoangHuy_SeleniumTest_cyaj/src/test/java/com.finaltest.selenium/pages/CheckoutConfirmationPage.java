package com.finaltest.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutConfirmationPage extends BasePage{
    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private String btnConfirmOrder = "finish";
    private String btnCancel = "cancel";

    private String txtDescription = ".inventory_item_desc";
    private String txtItemTotal = "//*[@id='checkout_summary_container']//div[5]";
    private String txtTax = "//*[@id='checkout_summary_container']//div[6]";
    private String txtTotal = "//*[@id='checkout_summary_container']//div[7]";

    /**
     * The function to search and return the Confirm Order button.
     * @return Confirm Order button.
     */
    public WebElement getConfirmOrderButton() {
        return this.driver.findElement(By.id(btnConfirmOrder));
    }

    /**
     * The function to search and return descriptipn of product.
     * @return Description.
     */
    public WebElement getDescription() {
        return actionKeyword.findElementCustom(By.cssSelector(txtDescription));
    }

    /**
     * The function to search and return the Cancel button.
     * @return Cancel button.
     */
    public WebElement getCancelButton() {
        return this.driver.findElement(By.id(btnCancel));
    }

    /**
     * Function to move to the next page.
     * @return Success page.
     */
    public SuccessPage goToSuccessPage() {
        actionKeyword.click(getConfirmOrderButton());;
        return new SuccessPage(this.driver);
    }

    /**
     * Function to move to cancel.
     * @return Product list page.
     */
    public ProductList cancel() {
        actionKeyword.click(getCancelButton());;
        return new ProductList(this.driver);
    }

    public boolean compareDescription(String description) {
        if (getDescription().getText().equals(description)) {
            return true;
        } else {
            return false;
        }
    }

    public String getItemTotalText() {
        return actionKeyword.findElementCustom(By.xpath(txtItemTotal)).getText().substring(13);
    }

    public String getTaxText() {
        return actionKeyword.findElementCustom(By.xpath(txtTax)).getText().substring(6);
    }

    public String getTotalText() {
        return actionKeyword.findElementCustom(By.xpath(txtTotal)).getText().substring(8);
    }

    public boolean isNumber() {
        try {
            Double.parseDouble(getItemTotalText());
            Double.parseDouble(getTotalText());
            Double.parseDouble(getTaxText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}