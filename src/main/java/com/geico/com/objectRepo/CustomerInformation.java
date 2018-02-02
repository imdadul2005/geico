package com.geico.com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.datatransfer.StringSelection;
import java.util.StringTokenizer;

/**
 * @author Imdadul Hoq
 *
 */

public class CustomerInformation {

    WebDriver driver ;

    public  CustomerInformation(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Must check if intro dialog is present. If present, it must be closed.

    @FindBy(xpath =".//*[contains(@id,'introduction-dialog')]/div/button") WebElement intoDialog;
    @FindBy(css = "#firstName") WebElement firstName;
    @FindBy(css = "#lastName") WebElement lastName;
    @FindBy(css = "#street") WebElement street;
    @FindBy(css = "#apt") WebElement apt;
    @FindBy(css = "#zip") WebElement zip;
    @FindBy(css = "#date-monthdob") WebElement month;
    @FindBy(css = "#date-daydob") WebElement day;
    @FindBy(css = "#date-yeardob") WebElement year;
    @FindBy(xpath = ".//button[@id='btnSubmit']") WebElement next;


    public WebElement getIntoDialog() {
        return intoDialog;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getStreet() {
        return street;
    }

    public WebElement getApt() {
        return apt;
    }

    public WebElement getZip() {
        return zip;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getNext() {
        return next;
    }

    public void customerInfo(String firstName, String lastName, String street, String apt, String zip, String DOB){ // DOB should be in month/Date/Year format
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getStreet().sendKeys(street);
        getApt().sendKeys(apt);
        getZip().sendKeys(zip);

        StringTokenizer tokenizer = new StringTokenizer(DOB, "/");
        String month = tokenizer.nextToken();
        String day = tokenizer.nextToken();
        String year = tokenizer.nextToken();

        getMonth().sendKeys(month);
        getDay().sendKeys(day);
        getYear().sendKeys(year);

    }
}
