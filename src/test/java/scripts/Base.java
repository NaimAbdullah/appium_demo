package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaHomePage;
import pages.CarvanaSearchPage;
import utils.ConfigReader;
import utils.Driver;
import utils.Environment;

public class Base extends Environment {

    WebDriver driver;
    String applicationURL = ConfigReader.getProperty("applicationURL");

    //Pages
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchPage carvanaSearchPage;
    Actions actions;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(applicationURL);
        actions = new Actions(driver);
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaSearchPage = new CarvanaSearchPage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}