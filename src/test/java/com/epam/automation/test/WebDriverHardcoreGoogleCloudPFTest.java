package com.epam.automation.test;

import com.epam.automation.model.VirtualMachine;
import com.epam.automation.page.GoogleCloudPricingCalculatorPagePF;
import com.epam.automation.page.GoogleCloudStartPagePF;
import com.epam.automation.page.TenMineMailPagePF;
import com.epam.automation.service.TestDataReader;
import com.epam.automation.service.VirtualMachineCreator;
import com.epam.automation.window_handler.WindowHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverHardcoreGoogleCloudPFTest extends CommonConditions {

    private final String TOTAL_COST = "testdata.total.cost";

    @Test
    public void successfulGoogleCloudEngineEmailEstimation() {
        VirtualMachine testVirtualMachine = VirtualMachineCreator.withParametersFromProperty();
        GoogleCloudPricingCalculatorPagePF googleCloudPricingCalculatorPage = new GoogleCloudStartPagePF(driver)
                .openPage()
                .pasteSearchTerm("Google Cloud Platform Pricing Calculator")
                .startSearch()
                .openLink("Google Cloud Platform Pricing Calculator")
                .selectSection(testVirtualMachine)
                .pasteNumberOfInstances(testVirtualMachine)
                .chooseOperatingSystemSoftware(testVirtualMachine)
                .chooseVMClass(testVirtualMachine)
                .chooseSeries(testVirtualMachine)
                .chooseMachineType(testVirtualMachine)
                .selectAddGpusCheckbox()
                .chooseNumberOfGpus(testVirtualMachine)
                .chooseGpuType(testVirtualMachine)
                .chooseLocalSsd(testVirtualMachine)
                .chooseDatacenterLocation(testVirtualMachine)
                .chooseCommittedUsage(testVirtualMachine)
                .selectAddToEstimateButton();
        WindowHandler windowHandler = new WindowHandler(driver)
                .openNewTab(driver)
                .holdTabs()
                .switchTab(1);
        TenMineMailPagePF tenMineMailPagePF = new TenMineMailPagePF(driver)
                .openPage()
                .copyEmailAddress();
        windowHandler.switchTab(0);
        googleCloudPricingCalculatorPage
                .switchToFrame()
                .selectEmailEstimateButton()
                .pasteEmail(tenMineMailPagePF.getEmailAddress())
                .selectSendEmailButton();
        windowHandler.switchTab(1);
        tenMineMailPagePF
                .waitForEmail()
                .openEmail();
        Assert.assertTrue(tenMineMailPagePF.getTotalCost().contains(TestDataReader.getTestData(TOTAL_COST)), "Total Estimated Cost doesn't equals value got by manual testing!");
    }
}