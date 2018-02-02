package com.geico.com;

import com.geico.com.objectRepo.CustomerInformation;
import com.geico.com.objectRepo.HomePage;
import com.geico.com.objectRepo.VehicleSelection;
import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.DataReader;

import java.io.IOException;

public class DataTest extends Base {

    WebDriver driver;

    @BeforeTest
    public void setUPOS() {
        driver = getLocalDriver("Windows", "chrome");

    }
    @BeforeMethod
    public void setUp() throws IOException {
        setUp("http://www.geico.com");
    }

    @Test(dataProvider = "data")
    public void dataReader(String firstName, String lastName, String street, String apt, String zip, String DOB) throws IOException, InterruptedException {
        if(firstName!=null); //confirm data is not null
        HomePage hp = new HomePage(driver);
        hp.getSubmit().click();

        Thread.sleep(2000);
        CustomerInformation ci = new CustomerInformation(driver);
        ci.customerInfo(firstName, lastName, street, apt, zip, DOB);
        ci.getNext().click();

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

    @DataProvider(name = "data")
    public static Object[][] credentials() throws IOException {

        DataReader dr = new DataReader();
        String [][] data = dr.fileReader1("C:\\Users\\imdadul\\IdeaProjects\\Geico\\data\\us-500.xlsx");
        return data;

    }

    @AfterTest
    public static void cleanUp(){
        cleanUp();
    }
}
