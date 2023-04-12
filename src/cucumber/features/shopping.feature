@shop

Feature: Buying products

  Scenario Outline: User can buy products from shop
    Given I'm on a shop main page
    When I go to the login page
    And I log in using my email "hdqwcrrmekdrpsuvyj@tpwlb.com" and password "Ewa12345"
    And I choose clothes category
    And I add sweater size "<size>" and quantity "<quantity>" to the cart
    And I go to cart checkout
    And I confirm the address
    And I choose shipping method
    And I choose payment option
    And I order with an obligation to pay
    Then I do screenshot with order confirmation
    And I close the browser
    Examples:
      | size | quantity |
      | M    | 1        |



#  Scenario Outline: User can buy products from shop
#    Given I'm on a shop main page
#    When I go to the login page
#    And I log in using my email "test@gmail.com" and password "Ewa12345"
#    And I choose clothes category
#    And I add "<quantity>" sweater in "<size>" size to the cart
#    Examples:
#      | quantity | size |
##      | 1        | S    |
##      | 2        | M    |
##      | 3        | L    |
##      | 4        | XL   |
#      | 5        | M    |

