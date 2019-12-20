package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SeleniumDriver;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(SeleniumDriver.getDriver(), this);
    }

    @FindBy(how = How.CSS, using = "button#gh-shop-a")
    private WebElement ShopByCategory;

    @FindBy(how = How.CSS, using = "input#gh-btn")
    private WebElement SearchButton;

    @FindBy(how = How.CSS, using = "input.gh-tb.ui-autocomplete-input")
    private WebElement SearchField;


    public void shop_By_Category(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(SearchField));
        SearchField.click();
        SearchField.sendKeys(product);
        SearchButton.click();

    }

}
