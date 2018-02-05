package com.geico.com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Imdadul Hoq
 *
 */

public class HomePage {

    WebDriver driver ;

    public  HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = ".//*[@id='submitButton']") WebElement submit;
    @FindBy(xpath = ".//*[@id='zip']") WebElement zipcode;

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getZipcode() {
        return zipcode;
    }
}
