package com.thetestingacdemy.pages;

import com.thetestingacdemy.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    DashboardPage(){
    }
    By userNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");

    public String loggedInUserName(){
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}
