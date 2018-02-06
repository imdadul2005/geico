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

        String os = "Windows";
        String browserName = "Firefox";

        driver = getLocalDriver(os, browserName);
        driver.manage().deleteAllCookies();
        setUp("http://www.geico.com");
    }

    @Test(priority = 0)
    public void test() throws InterruptedException {
        Thread.sleep(3000);
        HomePage hp = new HomePage(driver);
        hp.getSubmit().click();

        Thread.sleep(2000);
        CustomerInformation ci = new CustomerInformation(driver);
        ci.customerInfo("Adam","Hoq", "7035 Broadway", "3B", "11372", "10/19/1980");
        Thread.sleep(2000);
     //   ci.getNext().click();
    }

    // This it to test that next button on Vehicles page display Year and How is this vehicle primarily used? in red

   /* @Test(dependsOnMethods = "test")
    public void vehicleNegativeTest() throws InterruptedException {

        Thread.sleep(4000);
        VehicleSelection vs = new VehicleSelection(driver);
        vs.getAddNoNewCar().click();

        // Assert that clicking next button on this page will change the year in red
        Assert.assertEquals(redColor,getColor(vs.getYearLabel()));

        // Assert that clicking next button on this page will change How is this vehicle primarily used? color
        Assert.assertEquals(redColor,getColor(vs.getVehicleUsed()));
    }
*/
    @Test(dependsOnMethods = "test")

    public void vehiclePositiveTest() throws InterruptedException {


        String vehicleYear = "2014";
        String vehicleMake = "Honda";
        String vehicleModel = "Accord LX";
        String use = "Pleasure";
        String ownerType ="Owner";


        String source = driver.getPageSource();
        if (source.contains(errorMSG))
            testPage = false;

        // Assert.assertEquals(testPage,test);
        //To do confirm the title of the page matches as expected.

        if (testPage) {
            Thread.sleep(4000);
            VehicleSelection vs = new VehicleSelection(driver);
            selectByVisibleText(vehicleYear, vs.getVehicleYearSelect());
            selectByVisibleText(vehicleMake, vs.getVehicleMakeSelect());
            selectByVisibleText(vehicleModel, vs.getVehicleModelSelect());

            try {
                selectByIndex(2, vs.getBodyStyleSelect());
            } catch (Exception e) {
            }
            selectByValue("40",vs.getAntiTheftDeviceSelect());
            ListOfString(vs.getVehicleOwner(), ownerType).click();
            ListOfString(vs.getPrimaryUse(), use).click();
            selectByValue("6000", vs.getAnnualMileageSelect());
            Thread.sleep(2000);
       //     vs.getAddNoNewCar().click();
          }
        else
            System.out.println(incorrectMsg);
        }
    @Test(dependsOnMethods ="vehiclePositiveTest")

    public void driverInfoTest() throws InterruptedException {

        //To do confirm the title of the page matches as expected.

        String gender = "Female";
        String ssn ="102125403";
        String houseType="Own";

        Thread.sleep(2000);
        String source = driver.getPageSource();
        if (source.contains(errorMSG))
            testPage = false;

      //  Assert.assertEquals(testPage,test);

        if (testPage) {
            Thread.sleep(2000);
            CarDriver cr = new CarDriver(driver);
            selectByValue("S", cr.getMaritalStatusSelect());
            ListOfString(cr.getGender(), gender).click();
            cr.getSsn().sendKeys(ssn);
            ListOfString(cr.getOwnOrRent(), houseType).click();
            selectByValue("N", cr.getHasInsuranceSelect());
            cr.getAgeFirstLicense().sendKeys("19");
            selectByValue("T", cr.getEducationSelect());
            selectByValue("07", cr.getEmploySelect());
            Thread.sleep(2000);
            cr.getAddNoNewCar().click();
			System.out.println("Clicked first Time");
			
			Thread.sleep(5000);
			CarDriver cr1 = new CarDriver(driver);
			waitUntilClickAble(cr1.getAddNoNewCar());
			cr1.getAddNoNewCar().click();
			System.out.println("Clicked 2nd Time");

       /* url = driver.getCurrentUrl();
        Assert.assertEquals("driverhistory",url.contains("driverhistory"));
*/
            Thread.sleep(4000);
			try{
            cr.getAddNoNewCar().click();
			}catch(Exception e){
				
			}
        }
        else{
            System.out.println(incorrectMsg);
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
			waitUntilVisible(dp.getSelectNo());
		    ListOfString(dp.getOptions(), "No").click();
            dp.getEmail().sendKeys("ihoq@gmail.com");

            //Expect user to set correct address ignoring incorrect address checking for now.
          /*  try {
                dp.getKeepOriginal().click();
            } catch (Exception e) {};
          */
            dp.getSubmit().click();
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
	
    /*@AfterTest
    public void clean(){
        cleanUp();
    }*/
	
}
