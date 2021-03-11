Feature: Book A Filght Ticket with LowCost
  Scenario Outline: Check for the low cost and book a ticket
    Given Navigate to <url>
    When Select DepatureCity
    And Select ArrivalCity
    And Select Depature Date And return Date
    And Select Traveller and Class
    And Select Type of Fare
    Then Search for the flight
    And book the cheapest flight
    Examples:
      | url                       |
      |https://www.makemytrip.com/|