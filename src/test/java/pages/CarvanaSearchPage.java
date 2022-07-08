package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchPage extends BasePage{
    public CarvanaSearchPage(WebDriver driver){
        super();
    }

    @FindBy(css = ".lYQCK>button")
    public List<WebElement> searchFilters;

    @FindBy(className = "react-autosuggest__input")
    public WebElement searchInputBox;

    @FindBy(className = "iPPBRN")
    public WebElement searchGoButton;

    //Tile Validation Elements
    @FindBy(css = ".vehicle-image>img")
    public List<WebElement> carImages;

    @FindBy(css = ".favorite-vehicle>svg")
    public List<WebElement> favoriteButtons;

    @FindBy(className = "inventory-type-variant")
    public List<WebElement> inventoryTypes;

    @FindBy(css = ".make-model>div")
    public List<WebElement> yearMakeModels;

    @FindBy(className = "trim-mileage")
    public List<WebElement> trimAndMileages;

    @FindBy(className = "price")
    public List<WebElement> prices;

    @FindBy(className = "monthly-payment")
    public List<WebElement> monthlyPayments;

    @FindBy(className = "down-payment")
    public List<WebElement> downPayments;

    @FindBy(className = "delivery-chip")
    public List<WebElement> deliveryChips;
}
