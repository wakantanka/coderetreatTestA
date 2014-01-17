Scenario: Overnightparking

Given Car is Parking in SHORT-TERM PARKING
When Arrived 13/12/2012 at 7:00 Daytime PM
And  Departure 12/13/2012 at 7:00 Daytime AM
And SUBMIT is pressed
Then Calculatet Fee is 24.00 €