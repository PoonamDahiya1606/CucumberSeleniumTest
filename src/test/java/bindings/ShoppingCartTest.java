package bindings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.ShoppingCartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import pageObjects.ProductPage;
import utils.SeleniumDriver;

public class ShoppingCartTest {

    HomePage homePage;
    ProductListingPage productListingPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    ProductPage productPage;

    @Given("I am on Home Page")
    public void i_am_on_home_page() throws Throwable {
        SeleniumDriver.openPage("https://ebay.com.au");
    }

    @When("I search for {string}")
    public void i_search_for(String product) throws Throwable {
        homePage = new HomePage();
        homePage.shop_By_Category(product);
    }


    @When("choose to buy the item")
    public void choose_to_buy_the_first_item() throws Throwable {
        productListingPage = new ProductListingPage();
        productListingPage.choose_Product();
    }

    @When("add the item in cart")
    public void i_add_the_item_in_cart() throws Throwable {
        productPage = new ProductPage();
        productPage.add_To_Cart();
        productPage.go_To_Cart();
    }

    @When("proceed with checkout with wrong credit card details")
    public void proceed_with_checkout() throws Throwable {
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();

        shoppingCartPage.clickOn_GoToCheckout();
        shoppingCartPage.clickOn_ContinueAsAGuest();
        checkoutPage.fill_PersonalDetails();
        checkoutPage.click_PersonalDetailsDone();
        checkoutPage.select_PaymentOption();
        checkoutPage.fill_PaymentDetails();
        checkoutPage.add_CreditCard();

    }

    @Then("I should get payment error notification")
    public void i_should_get_payment_error_notification() throws Throwable {
        checkoutPage = new CheckoutPage();
        String ExpectedErrorNotification = "Looks like something wasn't correct. Please enter the payment details again.";
        Assert.assertEquals(ExpectedErrorNotification, checkoutPage.incorrect_CreditCarddetailsNotification());
    }

}



