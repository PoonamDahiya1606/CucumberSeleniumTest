package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumDriver;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage() {
        PageFactory.initElements(SeleniumDriver.getDriver(), this);
    }

    @FindBy(how = How.CSS, using = "button.call-to-action.btn.btn--large.btn--primary")
    private WebElement btn_GoToCheckout;

    @FindBy(how = How.CSS, using = "button#gxo-btn")
    private WebElement btn_ContinueAsAGuest;

    @FindBy(how = How.CSS, using = "div.listsummary-content-itemdetails h3 span[class=\"BOLD\"]")
    private WebElement item_Title;

    public void clickOn_GoToCheckout() {
        btn_GoToCheckout.click();
    }

    public void clickOn_ContinueAsAGuest() {
        btn_ContinueAsAGuest.click();
    }
}