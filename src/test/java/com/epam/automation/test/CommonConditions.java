package com.epam.automation.test;

import com.epam.automation.driver.DriverSingleton;
import com.epam.automation.utility.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        System.setProperty("environment", "qa");
        System.setProperty("browser", "chrome");
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        //DriverSingleton.closeDriver();
    }
}
