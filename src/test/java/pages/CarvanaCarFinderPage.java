package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarvanaCarFinderPage extends BasePage{
    public CarvanaCarFinderPage(){
        super();
    }

    //Locators common both for mobile and web
    @FindBy(tagName = "h1")
    public WebElement mainHeader;

    @FindBy(tagName = "h3")
    public WebElement subHeader;


    //Web locators


    //Mobile locators
}