import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class AppiumDemo {

    @Test
    public void demo1() throws Exception {

        /*
        Go to Google
        Search for TechGlobal
         */

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4_28");
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        //caps.setCapability("appPackage", "com.android.chrome");
        //caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        URL url = new URL("http://127.0.0.1:4723/wd/hub/");

        //com.android.chrome/com.google.android.apps.chrome.Main
        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("TechGlobal");

        //Thread.sleep(10000);



        //BROWSER TESTING FOR WEB APPLICATION BUT ON MOBILE DEVICES
        WebDriver driver = new RemoteWebDriver(url, caps);

        driver.get("https://www.carvana.com");

        //driver.findElement(By.name("q")).sendKeys("TechGlobal" + Keys.ENTER);

        Thread.sleep(10000);


    }
}