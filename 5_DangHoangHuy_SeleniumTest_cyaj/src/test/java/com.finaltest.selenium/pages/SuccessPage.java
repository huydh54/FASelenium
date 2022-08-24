package com.finaltest.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage{
    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    private String lblHeader = "//h2[text()='THANK YOU FOR YOUR ORDER']";

    /**
     * The function to search and return the Header label.
     * @return Header label.
     */
    public WebElement getHeaderLabel() {
        return this.driver.findElement(By.xpath(lblHeader));
    }
}
