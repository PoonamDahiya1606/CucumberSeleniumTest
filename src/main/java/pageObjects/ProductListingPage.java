package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SeleniumDriver;

public class ProductListingPage extends BasePage {

    public ProductListingPage() {
        PageFactory.initElements(SeleniumDriver.getDriver(), this);
    }

    @FindBy(how = How.CSS, using = "li#srp-river-results-listing1 h3")
    private WebElement product;

    private By ProductTitle = By.xpath("h3");

    public void choose_Product() {
        wait.until(ExpectedConditions.elementToBeClickable(product));
        product.click();
    }

    public String Expected_ItemName() {
        String titleText = product.getText();
        return titleText;
    }

}
