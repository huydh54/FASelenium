package com.finaltest.selenium.pages;

import com.finaltest.selenium.keyword.ActionKeyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private String btnAddToCart = ".btn_inventory";
    private String btnGoToCart = ".shopping_cart_link";

    /**
     * The function returns the Add to Cart button.
     * @return Add to Cart button.
     */
    public WebElement getAddToCartButton() {
        return actionKeyword.findElementCustom(By.cssSelector(btnAddToCart));
    }

    /**
     * The function returns the Add to Cart button.
     * @return Add to Cart button.
     */
    public WebElement getGoToCartButton() {
        return actionKeyword.findElementCustom(By.cssSelector(btnGoToCart));
    }

    /**
     * Function to press the Add to Cart button.
     */
    public CartPage addProductToCart() {
        actionKeyword.click(this.getAddToCartButton());
        actionKeyword.click(this.getGoToCartButton());
        return new CartPage(this.driver);
    }
}
