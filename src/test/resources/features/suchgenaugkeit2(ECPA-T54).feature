Feature: Verbesserte Suchgenauigkeit

  Scenario: ECPA-92 Verbesserte suchgenauigkeit(Genauigkeit der Suche/SuchVorschläge)

    Given ich gehe auf die Amazon.de startseite.
    Then ich sehe title Amazon.de
    When ich schreibe im Suchfeld der Suche Amazon.de enthält, den text wireless
    Then ich sehe im Dropdown-Menu wireless beginnende Producktüberschrifften
    And ich sehe im Dropdown-Menu wireless beginnende Producktüberschrifften als klickbar
    When ich klicke auf die suchtaste.
    Then ich sehe unter dem Ergebnisse titel wireless oder kabellos Produkte
    Then ich sehe unter dem navbar Ergebnissen oder Vorschlägen text
    And ich sehe unter dem navbar wireless text
    And ich sehe Ergebnisse titel
    When ich klicke auf das Amazon.de Logo.
    Then ich sehe title Amazon.de
    And ich sehe nicht unter dem navbar Ergebnissen oder Vorschlägen für text
    When ich schreibe im Suchfeld der Suche Amazon.de enthält, den text playstation
    Then ich sehe im Dropdown-Menu playstation beginnende Producktüberschrifften
    Then ich sehe im Dropdown-Menu playstation beginnende Producktüberschrifften als klickbar
    When ich klicke playstation 5 auf im DropdownMenu
    Then ich sehe unter dem Ergebnisse titel ps5 oder playstation 5 Produkte
    And ich sehe unter dem navbar Ergebnissen oder Vorschlägen für text
    And ich sehe unter dem navbar playstation 5 text
    And ich sehe Ergebnisse titel
    Then ich gebe akflscnfjiriophzp wort statt playstation 5 wort im Suchfeld ein
    And ich sehe kein Dropdown-Menu
    When ich klicke auf die suchtaste.
    Then ich sehe Keine Ergebnisse text
    And  ich sehe nicht unter dem navbar Ergebnissen oder Vorschlägen für text
    And ich sehe Benötigst du Hilfe? text



