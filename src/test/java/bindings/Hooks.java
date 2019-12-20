package bindings;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import utils.SeleniumDriver;

public class Hooks {

    @Before
    public static void setUp() {
        System.out.println("This will run before the Scenario");
        SeleniumDriver.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) SeleniumDriver.getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();
                scenario.embed(screenshot, "image/png");
                scenario.write(testName);
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        SeleniumDriver.tearDown();
    }
}
