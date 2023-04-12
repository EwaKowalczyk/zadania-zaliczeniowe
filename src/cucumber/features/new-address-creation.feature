@create
Feature: New address creation

  Scenario Outline: User can create new address
    Given I'm on a store main page
    When I go to login page
    And I log in using email "hdqwcrrmekdrpsuvyj@tpwlb.com" and password "Ewa12345"
    And I go on addresses page
    And I go on Create new address
    And I enter new address "<alias>", "<address>", "<city>", "<postal code>", "<country>", "<phone>"
    Then I verify created address "<alias>", "<address>", "<city>", "<postal code>", "<country>", "<phone>"
    And I close browser
    Examples:
    |alias|address|city|postal code|country|phone|
    |Home |Astoria 50|New York|00001|United Kingdom|789456123|



