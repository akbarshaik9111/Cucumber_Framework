Feature: Place the order for products

@PlaceOrder
Scenario Outline: Add items to the cart and place the order

Given User is on GreenKart landing page
When user searched with short name <Name> and extracted acutal name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom  |