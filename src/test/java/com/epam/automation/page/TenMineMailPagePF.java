package com.epam.automation.page;

import com.epam.automation.wait.CustomConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TenMineMailPagePF {

    private final static String HOMEPAGE_URL = "https://10minemail.com/en/";
    private final Logger logger = LogManager.getRootLogger();
    private final WebDriver driver;

    private String emailAddress;
    @FindBy(xpath = "//*[@id=\"mail\"]")
    private WebElement emailAddressField;
    @FindBy(xpath = "//div[@class='inbox-area maillist']")
    private WebElement emailList;
    @FindBy(xpath = "//span[contains(text(), 'Google Cloud Sales')]/..")
    private WebElement email;
    @FindBy(xpath = "//td[contains(text(),'USD')]")
    private WebElement totalCost;

    public TenMineMailPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TenMineMailPagePF openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.pageLoadCompleted());
        logger.info("10MineMail page opened.");
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public TenMineMailPagePF copyEmailAddress() {
        this.emailAddress = emailAddressField.getAttribute("value");
        logger.info("Email address copied.");
        return this;
    }

    public TenMineMailPagePF waitForEmail() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailList);
        logger.info("Waiting for incoming email...");
        new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='inbox-area maillist']/div[4]"), "class", "inbox-dataList"));
        new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.elementToBeClickable(email));
        return this;
    }

    public void openEmail() {
        email.click();
        logger.info("Opening email...");
    }

    public String getTotalCost() {
        return totalCost.getText();
    }
}
