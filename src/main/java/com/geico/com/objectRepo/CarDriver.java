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

public class CarDriver {

    WebDriver driver ;

    public  CarDriver(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = ".//*[@id='maritalStatus']") WebElement maritalStatusSelect;
    @FindBy (xpath = ".//input[@id='ssn']") WebElement ssn;
    @FindBy (css = ".//select[@id='hasAutoInsurance']") WebElement autoInsuranceSelect;
    @FindBy (xpath = ".//*[@id='ageFirstLicensed']") WebElement ageFirstLicense;
    @FindBy (css = "button#btnSubmit") WebElement addNoNewCar;
    @FindBy (xpath = ".//select[@id='highestEducation']") WebElement educationSelect;
    @FindBy (xpath = ".//*[@id='employmentStatus']") WebElement employSelect;

    public WebElement getHasInsuranceSelect() {
        return hasInsuranceSelect;
    }

    @FindBy(xpath = ".//*[@id='hasAutoInsurance']") WebElement hasInsuranceSelect;
    // This list will return all the radio button with primary . Use of radio can be alternate option
    @FindAll(@FindBy (xpath ="//label[contains(@for,'gender')]")) List<WebElement> gender;
    @FindAll(@FindBy (xpath ="//label[contains(@for,'ownOrRentHome')]")) List<WebElement> ownOrRent;


	
    public WebElement getMaritalStatusSelect() {
        return maritalStatusSelect;
    }

    public WebElement getSsn() {
        return ssn;
    }

    public WebElement getAutoInsuranceSelect() {
        return autoInsuranceSelect;
    }

    public WebElement getAgeFirstLicense() {
        return ageFirstLicense;
    }

    public WebElement getAddNoNewCar() {
        return addNoNewCar;
    }

    public WebElement getEducationSelect() {
        return educationSelect;
    }

    public WebElement getEmploySelect() {
        return employSelect;
    }

    public List<WebElement> getGender() {
        return gender;
    }

    public List<WebElement> getOwnOrRent() {
        return ownOrRent;
    }
}
