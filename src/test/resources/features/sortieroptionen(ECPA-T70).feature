Feature: Verbesserte Suchgenauigkeit

  Scenario: ECPA-92 Verbesserte suchgenauigkeit(SortierOptionen)

    Given ich gehe auf die Amazon.de Startseite.
    Then ich sehe title Amazon.de
    When ich schreibe im suchfeld der Suche Amazon.de enthält, den text socken
    And ich klicke auf die suchtaste
    Then  ich sehe Ergebnissen oder Vorschlägen für socken text
    And   ich sehe verschiedene socken Produkte mit der beschreibungen