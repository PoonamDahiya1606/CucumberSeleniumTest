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

    //    @FindBy(how = How.CSS, using = ".actPanel.vi-noborder  div.u-cb  span a[role=\"button\"]")
    @FindBy(how = How.CSS, using = ".actPanel .u-cb #atcRedesignId_btn")

    private WebElement addToCart;

    //    @FindBy(how = How.CSS, using = "div.app-atc-layer__actionRow a.btn.btn-prim.vi-VR-btnWdth-XL + a")
    @FindBy(how = How.CSS, using = ".app-atc-layer__actionRow .btn-scnda")

    private WebElement goToCart;

    public void add_To_Cart() {
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
    }

    public void go_To_Cart() {
        wait.until(ExpectedConditions.elementToBeClickable(goToCart));
        goToCart.click();
    }

}