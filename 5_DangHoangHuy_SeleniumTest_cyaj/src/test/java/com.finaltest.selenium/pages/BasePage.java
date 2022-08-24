package com.finaltest.selenium.pages;

import com.finaltest.selenium.keyword.ActionKeyword;
import com.finaltest.selenium.pages.components.menus.FooterMenu;
import com.finaltest.selenium.pages.components.menus.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public HeaderMenu headerMenu;
    public FooterMenu footerMenu;
    public ActionKeyword actionKeyword;
    public Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
        footerMenu = new FooterMenu(driver);
        PageFactory.initElements(this.driver, this);
        this.actionKeyword = new ActionKeyword(driver);
        actions = new Actions(this.driver);
    }
}