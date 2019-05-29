Feature: Exercise 3

  Scenario Outline: user registers "Company" user with Coders Guru page
    Given there is open browser with Coders Guru "https://men-men-s-01.codersguru.pl" page
    When user click on registration button
    Then user is on registration page
    And user selects Company
    When user fills email <email>
    And user fills first Name <firstName>
    And user fills second Name <secondName>
    And user fills password <password>
    And user again fills password <passwordRepeat>
    And user fills city <city>
    And user fills zip Code <zipCode>
    And user fills street <street>
    And user fills home Number <homeNumber>
    And user fills company name <companyName>
    And user fills NIP
    And user acknowledges rules
    And user confirms registration
    And user closes browser
    Examples:
      | email         | firstName | secondName | password | passwordRepeat | city     | zipCode | street   | homeNumber | companyName |
      | ala@gmail.com | Ala       | Makota     | ala123   | ala123         | Warszawa | 01-494  | Bema     | 69         | XYZ         |
      | ola@gmail.com | ola       | Mapsa      | ola123   | ola123         | Warszawa | 01-494  | Kolorowa | 96         | ABC         |

