package com.geico.com;

import com.geico.com.objectRepo.*;
import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
        ci.customerInfo("Joseph","Adma", "23 Broadway", "3B", "11720", "10/19/1977");
        ci.getNext().click();
    }

    // This it to test that next button on Vehicles page display Year and How is this vehicle primarily used? in red

    @Test(dependsOnMethods = "test")
    public void vehicleNegativeTest() throws InterruptedException {

        Thread.sleep(4000);
        VehicleSelection vs = new VehicleSelection(driver);
        vs.getAddNoNewCar().click();

        // Assert that clicking next button on this page will change the year in red
        Assert.assertEquals(redColor,getColor(vs.getYearLabel()));

        // Assert that clicking next button on this page will change How is this vehicle primarily used? color
        Assert.assertEquals(redColor,getColor(vs.getVehicleUsed()));
    }

    @Test(dependsOnMethods = "test")

    public void vehiclePositiveTest() throws InterruptedException {

        String source = driver.getPageSource();
        if (source.contains(errorMSG))
            testPage = false;

        // Assert.assertEquals(testPage,test);
        //To do confirm the title of the page matches as expected.

        if (testPage) {
            Thread.sleep(4000);
            VehicleSelection vs = new VehicleSelection(driver);
            selectByVisibleText("2014", vs.getVehicleYearSelect());
            selectByVisibleText("Honda", vs.getVehicleMakeSelect());
            selectByVisibleText("Accord", vs.getVehicleModelSelect());

            try {
                selectByIndex(1, vs.getBodyStyleSelect());
            } catch (Exception e) {
            }
            selectByIndex(1, vs.getAntiTheftDeviceSelect());
            ListOfString(vs.getVehicleOwner(), "Owned").click();
            ListOfString(vs.getPrimaryUse(), "Pleasure").click();
            selectByValue("6000", vs.getAnnualMileageSelect());
            vs.getAddNoNewCar().click();
          }
        else
            System.out.println(incorrectMsg);
        }
    @Test(dependsOnMethods ="vehiclePositiveTest")

    public void driverInfoTest() throws InterruptedException {

        //To do confirm the title of the page matches as expected.

        Thread.sleep(2000);
        String source = driver.getPageSource();
        if (source.contains(errorMSG))
            testPage = false;

      //  Assert.assertEquals(testPage,test);

        if (testPage) {
            Thread.sleep(2000);
            CarDriver cr = new CarDriver(driver);
            selectByValue("S", cr.getMaritalStatusSelect());
            ListOfString(cr.getGender(), "Female").click();
            cr.getSsn().sendKeys("102125403");
            ListOfString(cr.getOwnOrRent(), "Own").click();
            selectByValue("N", cr.getHasInsuranceSelect());
            cr.getAgeFirstLicense().sendKeys("19");
            selectByValue("T", cr.getEducationSelect());
            selectByValue("07", cr.getEducationSelect());
            cr.getAddNoNewCar();

       /* url = driver.getCurrentUrl();
        Assert.assertEquals("driverhistory",url.contains("driverhistory"));
*/
            Thread.sleep(4000);
            cr.getAddNoNewCar();
        }
        else{
            System.out.println("Incorrect , ");
        }
    }

    @Test(dependsOnMethods = "driverInfoTest")
    public void discountsandcontactinfo (){

        String source = driver.getPageSource();
        if (source.contains(errorMSG))
            testPage = false;
        // Assert.assertEquals(testPage,test);
        if (testPage) {


            DetailPage dp = new DetailPage(driver);
            dp.getSelectNo();
            dp.getEmail().sendKeys("ihoq@gmail.com");

            try {
                dp.getKeepOriginal().click();
            } catch (Exception e) {};

            dp.getSubmit();
        }
        else
            System.out.println(incorrectMsg);
    }
    @Test(dependsOnMethods ="discountsandcontactinfo" )
    public void quota(){

        DetailPage dp = new DetailPage(driver);
        String url = driver.getCurrentUrl();
        String source = driver.getPageSource();
        if (source.contains(errorMSG))
            testPage = false;
       // Assert.assertEquals(testPage,test);
        if (testPage) {
            String expectedUrl = "https://auto-buy.geico.com/nb#/sale/coverage/gskmsi?id=";
            if (url.equalsIgnoreCase(expectedUrl)) {
                dp.getContinue1().click();
            }
        }
        else
            System.out.println(incorrectMsg);
    }

    @AfterTest
    public void clean(){
        cleanUp();
    }
}
