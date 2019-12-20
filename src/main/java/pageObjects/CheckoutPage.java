package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SeleniumDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage() {
        PageFactory.initElements(SeleniumDriver.getDriver(), this);
    }

    @FindBy(how = How.CSS, using = "input#firstName")
    private WebElement txtbx_FirstName;

    @FindBy(how = How.CSS, using = "input#lastName")
    private WebElement txtbx_LastName;

    @FindBy(how = How.CSS, using = "input#email")
    private WebElement txtbx_Email;

    @FindBy(how = How.CSS, using = "input#phoneNumber")
    private WebElement txtbx_Phone;

    @FindBy(how = How.CSS, using = "input#emailConfirm")
    private WebElement txtbx_EmailConfirm;

    @FindBy(how = How.CSS, using = "select#stateOrProvince")
    private WebElement drpdwn_StateDropDownArrow;

    @FindBy(how = How.CSS, using = "select#country")
    private WebElement drpdwn_CountryDropDownArrow;

    @FindAll(@FindBy(how = How.CSS, using = "#country option"))
    private List<WebElement> country_List;

    @FindAll(@FindBy(how = How.CSS, using = "#stateOrProvince option"))
    private List<WebElement> state_List;

    @FindBy(how = How.CSS, using = "input#city")
    private WebElement txtbx_City;

    @FindBy(how = How.CSS, using = "input#addressLine1")
    private WebElement txtbx_Address;

    @FindBy(how = How.CSS, using = "input#postalCode")
    private WebElement txtbx_PostCode;

    @FindBy(how = How.CSS, using = "div.auto-address-menu-item")
    private WebElement auto_CompleteAddress;

    @FindBy(how = How.CSS, using = "input#cardNumber")
    private WebElement card_Number;

    @FindBy(how = How.CSS, using = "input#cardExpiryDate")
    private WebElement card_ExpiryDate;

    @FindBy(how = How.CSS, using = "input#securityCode")
    private WebElement card_SecurityCode;

    @FindBy(how = How.CSS, using = "input#cardHolderFirstName")
    private WebElement cardholder_FirstName;

    @FindBy(how = How.CSS, using = "input#cardHolderLastName")
    private WebElement cardholder_LastName;

    @FindBy(how = How.CSS, using = "button[data-test-id=\"ADD_CARD\"]")
    private WebElement add_CreditCard;

    @FindBy(how = How.CSS, using = "div[data-test-id=\"NOTIFICATIONS\"] span[class=\"text-display\"] span")
    private WebElement incorrect_CreditCarddetailsNotification;

    @FindBy(how = How.CSS, using = ".payment-selection .payment-entry--CC.payment-entry")
    private WebElement select_creditCard;

    @FindAll(@FindBy(how = How.CSS, using = "button[data-test-id=\"ADD_ADDRESS_SUBMIT\"]"))
    private WebElement done;

    public void enter_Name(String name) {
        txtbx_FirstName.sendKeys(name);
    }

    public void enter_LastName(String lastName) {
        txtbx_LastName.sendKeys(lastName);
    }

    public void enter_Email(String email) {
        txtbx_Email.sendKeys(email);
    }

    public void confirm_Email(String email) {
        txtbx_EmailConfirm.sendKeys(email);
    }

    public void enter_Phone(String phone) {
        txtbx_Phone.sendKeys(phone);
    }

    public void enter_City(String city) {
        txtbx_City.sendKeys(city);
    }

    public void enter_Address(String address) {
        txtbx_Address.sendKeys(address);
        auto_CompleteAddress.click();
    }

    public void enter_PostCode(String postCode) {
        txtbx_PostCode.sendKeys(postCode);
    }

    public void select_Country(String countryName) {
        drpdwn_CountryDropDownArrow.click();

        for (WebElement country : country_List) {
            if (country.getText().equals(countryName)) {
                country.click();
            }
        }
    }

    public void select_State(String countyName) {
        drpdwn_StateDropDownArrow.click();
        for (WebElement state : state_List) {
            if (state.getText().equals(countyName)) {
                state.click();
            }
        }
    }

    public void fill_PersonalDetails() {
        select_Country("Australia");
        enter_Name("Automation");
        enter_LastName("Test");
        enter_Address("700 Bourke St");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        enter_Email("Automation@gmail.com");
        confirm_Email("Automation@gmail.com");
        enter_Phone("0450000000");
    }

    public void click_PersonalDetailsDone() {
        done.click();
    }

    public void enter_CreditCardNumber(String cardnumber) {
        card_Number.sendKeys(cardnumber);
    }

    public void enter_CreditExpiryDate(String cardnumber) {
        card_ExpiryDate.sendKeys(cardnumber);
    }

    public void enter_CreditCardSecurityNumber(String cardnumber) {
        card_SecurityCode.sendKeys(cardnumber);
    }

    public void enter_CreditCardHolderFirstName(String cardnumber) {
        cardholder_FirstName.sendKeys(cardnumber);
    }

    public void enter_CreditCardHolderLastName(String cardnumber) {
        cardholder_LastName.sendKeys(cardnumber);
    }

    public void select_PaymentOption() {
        wait.until(ExpectedConditions.visibilityOf(select_creditCard));
        select_creditCard.click();
    }

    public void fill_PaymentDetails() {
        enter_CreditCardNumber("1234 5667 1111 1111");
        enter_CreditExpiryDate("01/20");
        enter_CreditCardSecurityNumber("123");
        enter_CreditCardHolderFirstName("TestFirstName");
        enter_CreditCardHolderLastName("TestLastName");
    }

    public void add_CreditCard() {
        wait.until(ExpectedConditions.elementToBeClickable(add_CreditCard));
        add_CreditCard.click();
    }

    public String incorrect_CreditCarddetailsNotification() {
        String errorNotification = incorrect_CreditCarddetailsNotification.getText();
        return errorNotification;
    }


}
