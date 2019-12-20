Feature: Shopping Cart
	As a customer
	I want to add the items in the shopping cart
	so that i can proceed with the payment
	
	Scenario: Add to shopping cart
		Given I am on Home Page
		When I search for "casio keyboard"
		And choose to buy the item
		And add the item in cart
		And proceed with checkout with wrong credit card details
		Then I should get payment error notification
	
