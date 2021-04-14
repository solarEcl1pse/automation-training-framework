package com.epam.automation.page;

import com.epam.automation.model.VirtualMachine;
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

public class GoogleCloudPricingCalculatorPagePF {

    private final Logger logger = LogManager.getRootLogger();
    private final WebDriver driver;
    @FindBy(xpath = ".//iframe[@src='/products/calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']")
    private WebElement outerFrame;
    @FindBy(xpath = ".//iframe[@src='https://cloudpricingcalculator.appspot.com']")
    private WebElement innerFrame;
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement section;
    @FindBy(xpath = "//*[@id=\"input_65\"]")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//*[@id=\"select_78\"]")
    private WebElement operatingSystemSoftwareDropdown;
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement vmClassDropdown;
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesDropdown;
    @FindBy(xpath = "//*[@id=\"select_value_label_62\"]")
    private WebElement machineTypeDropdown;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGpusDropdown;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeDropdown;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSsdDropdown;
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocationDropdown;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsageDropdown;
    @FindBy(xpath = "//button[@ng-click=\"listingCtrl.addComputeServer(ComputeEngineForm);\"]")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//*[@id=\"compute\"]/md-list")
    private WebElement resultList;
    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content")
    private WebElement totalCost;
    @FindBy(xpath = "//*[@id=\"email_quote\"]")
    private WebElement emailEstimateButton;
    @FindBy(xpath = "//form[@name='emailForm']//input[@type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    public GoogleCloudPricingCalculatorPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.pageLoadCompleted());
        logger.info("Google Cloud Pricing Calculator page opened.");
    }

    private static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public GoogleCloudPricingCalculatorPagePF switchToFrame() {
        driver.switchTo().frame(outerFrame).switchTo().frame(innerFrame);
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectSection(VirtualMachine virtualMachine) {
        driver.switchTo().frame(outerFrame).switchTo().frame(innerFrame);
        driver.findElement(By.xpath("//md-tab-item/div[@title='" + virtualMachine.getSection() + "']")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF pasteNumberOfInstances(VirtualMachine virtualMachine) {
        numberOfInstancesInput.click();
        numberOfInstancesInput.sendKeys(virtualMachine.getNumberOfInstances());
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseOperatingSystemSoftware(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, operatingSystemSoftwareDropdown);
        operatingSystemSoftwareDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_79\"]//div[contains(text(),'" + virtualMachine.getOperatingSystemSoftware() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_79\"]//div[contains(text(),'" + virtualMachine.getOperatingSystemSoftware() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseVMClass(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, vmClassDropdown);
        vmClassDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_83\"]//div[contains(text(),'" + virtualMachine.getVmClass() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_83\"]//div[contains(text(),'" + virtualMachine.getVmClass() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseSeries(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, seriesDropdown);
        seriesDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_91\"]//div[contains(text(),'" + virtualMachine.getSeries() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_91\"]//div[contains(text(),'" + virtualMachine.getSeries() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseMachineType(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, machineTypeDropdown);
        machineTypeDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_93\"]//div[contains(text(),'" + virtualMachine.getMachineType() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_93\"]//div[contains(text(),'" + virtualMachine.getMachineType() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectAddGpusCheckbox() {
        addGPUsCheckbox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseNumberOfGpus(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, numberOfGpusDropdown);
        numberOfGpusDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_400\"]//div[contains(text(),'" + virtualMachine.getNumberOfGpus() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_400\"]//div[contains(text(),'" + virtualMachine.getNumberOfGpus() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseGpuType(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, gpuTypeDropdown);
        gpuTypeDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_402\"]//div[contains(text(),'" + virtualMachine.getGpuType() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_402\"]//div[contains(text(),'" + virtualMachine.getGpuType() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseLocalSsd(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, localSsdDropdown);
        localSsdDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_361\"]//div[contains(text(),'" + virtualMachine.getLocalSsd() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_361\"]//div[contains(text(),'" + virtualMachine.getLocalSsd() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseDatacenterLocation(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, datacenterLocationDropdown);
        datacenterLocationDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_95\"]//div[contains(text(),'" + virtualMachine.getDatacenterLocation() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_95\"]//div[contains(text(),'" + virtualMachine.getDatacenterLocation() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF chooseCommittedUsage(VirtualMachine virtualMachine) {
        waitForElementToBeClickable(driver, committedUsageDropdown);
        committedUsageDropdown.click();
        waitForElementToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"select_container_102\"]//div[contains(text(),'" + virtualMachine.getCommittedUsage() + "')]")));
        driver.findElement(By.xpath("//*[@id=\"select_container_102\"]//div[contains(text(),'" + virtualMachine.getCommittedUsage() + "')]")).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectAddToEstimateButton() {
        waitForElementToBeClickable(driver, addToEstimateButton);
        addToEstimateButton.click();
        logger.info("Order added to estimation.");
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF selectEmailEstimateButton() {
        waitForElementToBeClickable(driver, emailEstimateButton);
        emailEstimateButton.click();
        logger.info("Email estimation selected.");
        return this;
    }

    public GoogleCloudPricingCalculatorPagePF pasteEmail(String value) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
        waitForElementToBeClickable(driver, emailInput);
        emailInput.click();
        emailInput.sendKeys(value);
        logger.info("Email address pasted.");
        return this;
    }

    public void selectSendEmailButton() {
        waitForElementToBeClickable(driver, sendEmailButton);
        sendEmailButton.click();
        logger.info("Email sent.");
    }
}
