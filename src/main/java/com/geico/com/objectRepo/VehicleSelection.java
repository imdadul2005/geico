package com.geico.com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Imdadul Hoq
 *
 */


import java.util.List;

public class VehicleSelection {

    WebDriver driver ;

    public  VehicleSelection(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "select[id=vehicleYear]") WebElement vehicleYearSelect;
    @FindBy (css = "select[id=vehicleMake]") WebElement vehicleMakeSelect;
    @FindBy (css = "select[id=vehicleModel]") WebElement vehicleModelSelect;
    @FindBy (css = "select[id=antiTheftDevice]") WebElement antiTheftDeviceSelect;
    @FindBy (xpath = "//button[@id='btnSubmit']") WebElement addNoNewCar;
    @FindBy (css = "select[id=bodyStyles]") WebElement bodyStyleSelect;



    @FindBy (xpath = ".//select[@id='annualMileage']") WebElement annualMileageSelect;


    // This list will return all the radio button with primary . Use of radio can be alternate option
    @FindAll(@FindBy (xpath ="//label[contains(@for,'primary')]")) List<WebElement> primaryUse;
  //  @FindAll(@FindBy (xpath ="//input[contains(@id,'vehicleOwned')]")) List<WebElement> vehicleOwner;
    @FindAll(@FindBy (xpath ="//label[contains(@for,'vehicleOwned')]")) List<WebElement> vehicleOwner;

    @FindBy (xpath = ".//*[@id='vehicleForm']/div[1]/div[1]/div[2]/div/div[1]/div/div/label/span[1]") WebElement yearLabel;
    @FindBy(xpath = ".//*[@id='vehicleForm']/div[1]/div[1]/div[17]/div[3]/div/div[1]/div/div/label/span[1]") WebElement vehicleUsed;

    public WebElement getAnnualMileageSelect() {
        return annualMileageSelect;
    }

    public WebElement getYearLabel() {
        return yearLabel;
    }

    public WebElement getVehicleUsed() {
        return vehicleUsed;
    }

    public WebElement getVehicleYearSelect() {
        return vehicleYearSelect;
    }

    public WebElement getVehicleMakeSelect() {
        return vehicleMakeSelect;
    }

    public WebElement getVehicleModelSelect() {
        return vehicleModelSelect;
    }

    public WebElement getAntiTheftDeviceSelect() {
        return antiTheftDeviceSelect;
    }

    public WebElement getAddNoNewCar() {
        return addNoNewCar;
    }

    public WebElement getBodyStyleSelect() {
        return bodyStyleSelect;
    }

    public List<WebElement> getPrimaryUse() {
        return primaryUse;
    }

    public List<WebElement> getVehicleOwner() {
        return vehicleOwner;
    }



}
