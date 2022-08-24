package com.finaltest.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private String txtUsername = "#user-name";

    public WebElement getUsernameField() {
        return actionKeyword.findElementCustom(By.cssSelector(txtUsername));
    }

    public void enterContentInUsernameField(String content) {
        actionKeyword.setText(getUsernameField(), content);
    }

    private String txtPassword = "#password";

    public WebElement getPasswordField() {
        return actionKeyword.findElementCustom(By.cssSelector(txtPassword));
    }

    public void enterContentInPasswordField(String content) {
        actionKeyword.setText(getPasswordField(), content);
    }

    private String btnLogin = "#login-button";

    public ProductList login(String username, String password) {
        enterContentInUsernameField(username);
        enterContentInPasswordField(password);
        actionKeyword.click(actionKeyword.findElementCustom(By.cssSelector(btnLogin)));
        return new ProductList(this.driver);
    }

    private String lblError = "[data-test='error']";

    public WebElement getErrorLabel() {
        return actionKeyword.findElementCustom(By.cssSelector(lblError));
    }
}