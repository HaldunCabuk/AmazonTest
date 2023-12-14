Feature: Verbesserte Suchgenauigkeit

  Scenario: ECPA-92 Verbesserte suchgenauigkeit(SortierOptionen)

    Given ich gehe auf die Amazon.de startseite.
    Then ich sehe title Amazon.de
    When ich schreibe im suchfeld der Suche Amazon.de enthält, den text kochbuch
    And ich klicke auf die suchtaste