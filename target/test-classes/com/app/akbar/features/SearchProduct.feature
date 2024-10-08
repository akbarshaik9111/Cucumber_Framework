Feature: Search and Place the order for products

@OffersPage
Scenario: Search experience for product search in both home and offers page

Given User is on GreenKart landing page
When user searched with short name <Name> and extracted acutal name of product
Then user searched for <Name> shortname in offers page
And validate product name in offers page matches with landing page

Examples:
| Name |
| Tom  |
| Beet |


