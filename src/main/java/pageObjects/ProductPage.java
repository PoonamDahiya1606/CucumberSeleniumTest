package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SeleniumDriver;

public class ProductPage extends BasePage {

    public ProductPage() {
        PageFactory.initElements(SeleniumDriver.getDriver(), this);
    }

    @FindBy(how = How.CSS, using = "a.btn.btn-scnd.vi-VR-btnWdth-XL")
    private WebElement addToCart;

    @FindBy(how = How.LINK_TEXT, using = "Go to cart")
    private WebElement goToCart;

    public void add_To_Cart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        addToCart.click();
    }

    public void go_To_Cart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        goToCart.click();
    }

}