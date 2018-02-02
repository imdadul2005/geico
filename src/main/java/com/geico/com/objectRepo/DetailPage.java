package com.geico.com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * @author Imdadul Hoq
 *
 */

public class DetailPage {

    WebDriver driver ;

    public  DetailPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public WebElement getSelectNo() {
        return selectNo;
    }

    @FindBy(xpath = ".//*[@id='discountForm']/div[1]/div[3]/div[2]/div/div/div/div[2]/div[2]/label") WebElement selectNo;
    @FindAll(@FindBy (xpath ="//div[@class='radio-button-group']/div/input"))  List<WebElement> defenseDriver;
    @FindAll(@FindBy (xpath =".//form[@id='discountForm']/div[1]/div[3]/div[3]/div[1]/div/div/div"))  List<WebElement> group;
    @FindBy (xpath = ".//input[@id='email']") WebElement emailAddress;
    @FindBy (xpath = "//div[@class='page-group']/div/div[2]/label") WebElement keepOriginal;
    @FindBy(xpath = ".//*[@id='submitButton']") WebElement submit;
    @FindBy (xpath = ".//*[@id='email']") WebElement email;

    public WebElement getContinue1() {
        return continue1;
    }

    @FindBy (xpath = ".//*[@id='auto-coverage-summary-modal']/div/div/button") WebElement continue1;

    public WebElement getEmail() {
        return email;
    }

    public List<WebElement> getDefenseDriver() {
        return defenseDriver;
    }

    public List<WebElement> getGroup() {
        return group;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getKeepOriginal() {
        return keepOriginal;
    }

    public WebElement getSubmit() {
        return submit;
    }
}
