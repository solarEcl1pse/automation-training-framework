package com.epam.automation.page;

import com.epam.automation.wait.CustomConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultPagePF {

    private final Logger logger = LogManager.getRootLogger();
    private final WebDriver driver;
    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']")
    private WebElement searchResultLink;

    public GoogleCloudSearchResultPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.pageLoadCompleted());
        logger.info("Google Cloud Search results are presented.");
    }

    public GoogleCloudPricingCalculatorPagePF openLink(String value) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchResultLink));
        driver.findElement(By.xpath("//div[@class='gsc-thumbnail-inside']//b[text()='" + value + "']")).click();
        return new GoogleCloudPricingCalculatorPagePF(driver);
    }
}
