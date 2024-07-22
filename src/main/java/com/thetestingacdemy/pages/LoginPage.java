package com.thetestingacdemy.pages;

import com.thetestingacdemy.base.BasePage;
import com.thetestingacdemy.driver.DriverManagerTL;
import com.thetestingacdemy.utils.PropetyReader;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    public LoginPage(){
        super();
    }

    //Page locators --> here we use encapsulation
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    public LoginPage loginToVWO(boolean invalid) throws Exception{
        if (!invalid){
            enterInput(username, PropetyReader.readKey("invalid_username"));
        }else {
            enterInput(username, PropetyReader.readKey("username"));
        }

        enterInput(password, PropetyReader.readKey("password"));
        clickElement(signButton);
        return this;
    }

    public String errorMessage() throws InterruptedException {
        visibilityOfElementLocated(error_message);
        return DriverManagerTL.getDriver().findElement(error_message).getText();
    }

    public DashboardPage afterLogin(){
        return new DashboardPage();
    }
}
