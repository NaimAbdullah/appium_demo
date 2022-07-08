package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarvanaHomePage extends BasePage{
    public CarvanaHomePage(WebDriver driver){
        super();
    }

    @FindBy(xpath = "//div[@data-qa='header-menu-wrapper']/div[@data-qa='logo-wrapper']")
    public WebElement webLogo;

    @FindBy(xpath = "//div[@data-qa='header-menu-mobile-wrapper']/div[@data-qa='logo-wrapper']")
    public WebElement mobileLogo;

    @FindBy(className = "beITXo")
    public WebElement supportAndContactButton;

    @FindBy(className = "hyiiZC")
    public WebElement mainPageDrowdown;

    @FindBy(className = "jMwYVy")
    public WebElement howItWorksButton;

    @FindBy(className = "cUsSTs")
    public WebElement aboutCarvanaButton;

    @FindBy(css = ".guzpJd>div:nth-child(2)>div:nth-child(2) a")
    public WebElement signInButton;

    @FindBy(className = "kVBfpP")
    public WebElement signInModalMessage;

    @FindBy(id = "usernameField")
    public WebElement usernameInputBox;

    @FindBy(id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy(className = "nqLpU")
    public WebElement modalSignInButton;

    @FindBy(className = "dhUWhc")
    public WebElement signInErrorMessage;

    @FindBy(css = ".hwDgKT:nth-child(3)>a")
    public WebElement searchCarsButton;
}