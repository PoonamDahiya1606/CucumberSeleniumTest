package pageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumDriver;

public class BasePage {

    WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(SeleniumDriver.getDriver(), 10, 50);
    }

}
