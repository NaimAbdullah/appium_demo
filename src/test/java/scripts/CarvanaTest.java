package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waiter;

public class CarvanaTest extends Base{

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testHomePage(){
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate Carvana logo")
    public void testLogo(){
        if(isMobile) Assert.assertTrue(carvanaHomePage.mobileLogo.isDisplayed());
        else Assert.assertTrue(carvanaHomePage.webLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testMainNavigation(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.supportAndContactButton.isDisplayed());
        Assert.assertEquals(carvanaHomePage.supportAndContactButton.getText(), "SUPPORT & CONTACT");
        carvanaHomePage.mainPageDrowdown.click();
        Assert.assertTrue(carvanaHomePage.howItWorksButton.isDisplayed());
        Assert.assertEquals(carvanaHomePage.howItWorksButton.getText(), "HOW IT WORKS");
        Assert.assertTrue(carvanaHomePage.aboutCarvanaButton.isDisplayed());
        Assert.assertEquals(carvanaHomePage.aboutCarvanaButton.getText(), "ABOUT CARVANA");
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignInError(){
        driver.get("https://www.carvana.com/");
        Waiter.pause(3);
        carvanaHomePage.mainPageDrowdown.click();
        carvanaHomePage.signInButton.click();
        Assert.assertTrue(carvanaHomePage.signInModalMessage.isDisplayed());
        Assert.assertEquals(carvanaHomePage.signInModalMessage.getText(), "HEY THERE, WELCOME BACK.");
        actions.sendKeys(carvanaHomePage.usernameInputBox, "johndoe@gmail.com")
                .sendKeys(carvanaHomePage.passwordInputBox, "abcd1234")
                .click(carvanaHomePage.modalSignInButton).perform();
        Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.signInErrorMessage, 5);
        Assert.assertTrue(carvanaHomePage.signInErrorMessage.isDisplayed());
        Assert.assertEquals(carvanaHomePage.signInErrorMessage.getText(),
                "Email address and/or password combination is incorrect\nPlease try again or reset your password.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilters(){
        driver.get("https://www.carvana.com/");
        Waiter.pause(3);
        carvanaHomePage.mainPageDrowdown.click();
        carvanaHomePage.searchCarsButton.click();
        Waiter.pause(3);
        String[] expectedFilters = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < carvanaSearchPage.searchFilters.size(); i++) {
            Assert.assertTrue(carvanaSearchPage.searchFilters.get(i).isDisplayed());
            Assert.assertEquals(carvanaSearchPage.searchFilters.get(i).getText(), expectedFilters[i]);
        }
    }

    // Task - 6
    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchTiles(){
        driver.get("https://www.carvana.com/");

        Waiter.pause(3);
        carvanaHomePage.mainPageDrowdown.click();
        carvanaHomePage.searchCarsButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        Waiter.pause(4);
        actions.sendKeys(carvanaSearchPage.searchInputBox, "mercedes-benz").perform();
        carvanaSearchPage.searchGoButton.click();
        Waiter.waitUntilURLContains(driver, 30, "mercedes-benz");
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for(WebElement element : carvanaSearchPage.carImages){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.favoriteButtons){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.inventoryTypes){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.yearMakeModels){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.trimAndMileages){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.prices){
            Assert.assertTrue(Integer.parseInt(element.getText().replaceAll("[\\D]", "")) > 0);
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.monthlyPayments){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.downPayments){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaSearchPage.deliveryChips){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }
    }
}