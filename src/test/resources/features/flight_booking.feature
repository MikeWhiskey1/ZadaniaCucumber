Feature: Exercise 5

  Scenario Outline: user makes flight reservation

    Given there is open browser with "https://www.phptravels.net/" page

    When user clicks on flights button
    And user selects -Round Trip-
    And user enters "WAW" departure aiport
    And user enters "JFK" destination aiport
    And users selects departure date
    And user selects return date
    And user presses -Search- button

    When user is presented with available flights
    And user selects -Book now-

    When user is presented with personal data form
    And user enters first Name <firstName>
    And user enters last Name <lastName>
    And user enters email <email>
    And user reconfirms email <email>
    And user enters mobile <mobile>
    And user enters address <address>
    And user selects country <country>
    And users confirms the booking

    When having invoice
    Then gets the invoice screenshot
#    And web browser is automatically closed
    Examples:
      | email            | mobile | firstName | lastName | address                         | country |
      | anna47@gmail.com | mobile | Anna      | Mapsa    | 01-494 Warszawa, ul Kolorowa 96 | Poland  |
