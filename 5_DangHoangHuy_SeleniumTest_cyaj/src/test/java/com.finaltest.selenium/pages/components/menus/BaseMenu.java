package com.finaltest.selenium.pages.components.menus;

import com.finaltest.selenium.keyword.ActionKeyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseMenu {
    public WebDriver driver;
    ActionKeyword actionKeyword;

    public BaseMenu(WebDriver driver){
        this.driver = driver;
        actionKeyword = new ActionKeyword(driver);
    }
}