Feature: Exercise 4

  Scenario Outline: user makes E2E Mentor reservation

    Given there is open browser with Coders Guru "https://men-men-s-01.codersguru.pl" page

    When user click on registration button
    Then user is on registration page with Private option active

    When user fills email <email>
    And user fills first Name <firstName>
    And user fills second Name <secondName>
    And user fills password <password>
    And user again fills password <passwordRepeat>
    And user fills city <city>
    And user fills zip Code <zipCode>
    And user fills street <street>
    And user fills home Number <homeNumber>
    And user acknowledges rules
    And user confirms registration

    When user is on page with - Help in programming issues - caption
    And user clicks on - Need Help - button
    And user selects subject to be discusses with the Mentor
    And user clicks - Find Mentor - button

    When user is on the page with a chosen subject
    And user reserves Mentor
    And user describes the issue
    And user chooses date of consultation
    And user chooses time of consultation
    And user acknowledges the order

    When user is on payment page
    Then web browser is automatically closed

    Examples:
      | email           | firstName | secondName | password | passwordRepeat | city     | zipCode | street   | homeNumber |
#      | ula@gmail.com   | Ula       | Machomika  | ula123   | ula123         | Warszawa | 01-494  | Bema     | 69         |
#      | ala@gmail.com   | Ala       | Makota     | ala123   | ala123         | Warszawa | 01-494  | Bema     | 69         |
#      | ola@gmail.com   | Ola       | Mapsa      | ola123   | ola123         | Warszawa | 01-494  | Kolorowa | 96         |
      | anna47@gmail.com | Anna      | Mapsa      | anna123  | anna123        | Warszawa | 01-494  | Kolorowa | 96         |
