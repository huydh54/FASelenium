package com.finaltest.selenium.pages.components.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterMenu extends BaseMenu{
    public FooterMenu(WebDriver driver) {
        super(driver);
    }

    private final String MNU_TAB_LOCATOR_BY_NAME = "//*[text()='%s']";

    public WebElement getMenuTabByName(String tabName){
        return actionKeyword.findElementCustom(By.xpath(String.format(MNU_TAB_LOCATOR_BY_NAME, tabName)));
    }
}
