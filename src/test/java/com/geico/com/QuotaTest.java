package com.geico.com;

import com.geico.com.objectRepo.CustomerInformation;
import com.geico.com.objectRepo.HomePage;
import com.geico.com.objectRepo.VehicleSelection;
import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;
import utility.DataReader;


import java.io.IOException;
import java.util.Arrays;

public class QuotaTest extends Base {

    WebDriver driver;

    @BeforeClass
    public void setUP() throws IOException {
        driver = getLocalDriver("Windows", "chrome");
        setUp("http://www.geico.com");
    }

    @Test(priority = 0)
    public void test() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.getSubmit().click();

        Thread.sleep(2000);
        CustomerInformation ci = new CustomerInformation(driver);
        ci.customerInfo("Adul","Hoq", "22 point st", "3B", "12590", "12/19/1988");
        ci.getNext().click();
    }

    // This it to test that next button on Vehicles page display Year and How is this vehicle primarily used? in red

    @Test(priority = 1)
    public void vehicleNegativeTest() throws InterruptedException {

        Thread.sleep(4000);
        VehicleSelection vs = new VehicleSelection(driver);
        vs.getAddNoNewCar().click();

        // Assert that clicking next button on this page will change the year in red
        Assert.assertEquals(redColor,getColor(vs.getYearLabel()));

        // Assert that clicking next button on this page will change How is this vehicle primarily used? color
        Assert.assertEquals(redColor,getColor(vs.getVehicleUsed()));
    }

    @Test(priority = 2)
    public void vehiclePositiveTest() throws InterruptedException {

        //To do confirm the title of the page matches as expected.
        Thread.sleep(4000);
        VehicleSelection vs = new VehicleSelection(driver);
        selectByVisibleText("2017",vs.getVehicleYearSelect());
        selectByVisibleText("Honda",vs.getVehicleMakeSelect());
        selectByVisibleText("Accord",vs.getVehicleModelSelect());
        selectByIndex(1,vs.getBodyStyleSelect());
        selectByIndex(1,vs.getAntiTheftDeviceSelect());
        ListOfString(vs.getVehicleOwner(),"Owned").click();
        ListOfString(vs.getPrimaryUse(),"Pleasure").click();
        selectByValue("6000",vs.getAnnualMileageSelect());
        vs.getAddNoNewCar().click();
    }


}
