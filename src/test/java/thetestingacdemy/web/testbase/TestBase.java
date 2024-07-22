package thetestingacdemy.web.testbase;

import com.thetestingacdemy.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.io.File;

public class TestBase {
    // call to driver, take screenshot
    @BeforeSuite
    protected void setUp(){
        DriverManagerTL.init();
    }

    @AfterSuite
    protected void tearDown(){
        DriverManagerTL.down();
    }

    protected void takeScreenShot(String name, WebDriver driver){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)DriverManagerTL
                .getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    // this code is for extent report

    /*public static String captureScreenshot(WebDriver driver) throws Exception{
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination_filepath = new File(System.getProperty("user.dir" + "/images/screenshot" + System.currentTimeMillis() + ".png"));
        FileUtils.copyFile(srcfile, destination_filepath);
        return destination_filepath.toString();

    }*/
}
