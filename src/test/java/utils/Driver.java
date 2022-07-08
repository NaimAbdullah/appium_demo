package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Environment{

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver == null){
            if(isMobile){
                DesiredCapabilities caps = new DesiredCapabilities();

                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                //caps.setCapability(MobileCapabilityType.UDID, "emulator-5554"); // this can be used instead of DEVICE_NAME
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, browser);

                URL url = null;
                try {
                    url = new URL("http://127.0.0.1:4723/wd/hub/");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

                driver = new RemoteWebDriver(url, caps);
            }
            else{
                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver = new SafariDriver();
                        break;
                    case "headless":
                        driver = new HtmlUnitDriver();
                        break;
                    default:
                        throw new NotFoundException("Browser IS NOT DEFINED properly!!!");
                }
                if(!ConfigReader.getProperty("browser").equals("headless")){
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
                }
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}