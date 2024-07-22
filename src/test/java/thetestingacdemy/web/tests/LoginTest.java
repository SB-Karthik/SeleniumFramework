package thetestingacdemy.web.tests;

import com.thetestingacdemy.driver.DriverManagerTL;
import com.thetestingacdemy.pages.DashboardPage;
import com.thetestingacdemy.pages.LoginPage;
import com.thetestingacdemy.utils.PropetyReader;
import com.thetestingacdemy.utils.ScreenShotListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import thetestingacdemy.web.testbase.TestBase;

import java.lang.reflect.Method;


@Listeners(ScreenShotListener.class)
public class LoginTest extends TestBase {      // Inheritance

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Valid Credentials are working fine")
    @Test(groups = {"QA","P0","negative"},priority = 1)
    public void testVWOLogin_Negative(Method method) throws Exception {
        // we can use this also in TestBase if ur url same for all
        // Abstraction  concept used
        DriverManagerTL.getDriver().get(PropetyReader.readKey("url"));
        String expectedResult = new LoginPage().loginToVWO(false).errorMessage();

        if (expectedResult.equalsIgnoreCase(expectedResult)) {
            logger.info("Failed");
            takeScreenShot(method.getName(),DriverManagerTL.getDriver());
        }

        Assertions.assertThat(expectedResult)
                .isNotBlank().isNotNull().contains(PropetyReader.readKey("expected_error"));

    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Valid Credentials are working fine")
    @Test(groups = {"P0","positive"},priority = 2)
    public void testVWOLogin_Positive() throws Exception {
        // navigate, Login to VWO and Assert
        // we can use this also in TestBase if ur url same for all
        // Abstraction  concept used
        DriverManagerTL.getDriver().get(PropetyReader.readKey("url"));
        DashboardPage dashboardPage = new LoginPage().loginToVWO(true).afterLogin();
        String expectedResult = dashboardPage.loggedInUserName();
        Assertions.assertThat(expectedResult)
                .isNotBlank().isNotNull().contains(PropetyReader.readKey("expected_username"));
    }


}
