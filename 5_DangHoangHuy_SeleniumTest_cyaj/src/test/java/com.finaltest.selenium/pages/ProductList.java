package com.finaltest.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductList extends BasePage{
    public ProductList(WebDriver driver) {
        super(driver);
    }

    private String imgDog = "img[src='/static/media/sl-404.168b1cce.jpg']";
    String txtTitle = "//span[text()='Products']";
    String txtDiscription = "#%s + div";

    /**
     * Function to search and return products based on product name.
     * @param id Product name id.
     * @return Product.
     */
    public WebElement getProductByName(String id) {
        return actionKeyword.findElementCustom(By.id(id));
    }

    /**
     * Function to move to product detail page
     * @param id Product name.
     * @return Product Detail page.
     */
    public ProductDetailPage selectProductById(String id) {
        actionKeyword.click(this.getProductByName(id));
        return new ProductDetailPage(this.driver);
    }

    public WebElement getDogPicture() {
        return actionKeyword.findElementCustom(By.cssSelector(imgDog));
    }

    /**
     * Function to find and return title of page.
     * @return Proceed to Checkout button.
     */
    public WebElement getTitle() {
        return this.driver.findElement(By.xpath(txtTitle));
    }

    public String getDescription(String id) {
        WebElement element = actionKeyword.findElementCustom(By.cssSelector(String.format(txtDiscription, id)));
        String description = element.getText();
        return description;
    }
}