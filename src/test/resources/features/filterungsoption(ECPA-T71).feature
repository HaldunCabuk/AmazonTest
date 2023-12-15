Feature: ECPA-92 Verbesserte Suchgenauigkeit

  Scenario: Überprüfung der Amazon.de-Suchfunktion und FilterungsOptionen

    Given ich gehe auf die Amazon.de Startseite.
    Then  ich sehe title Amazon.de
    When  ich schreibe im Suchfeld der Suche Amazon.de enthält, den text camera wifi
    And   ich sehe die verschiedene Produkten im Dropdown-Menu camera wifi enthält
    And   ich klicke auf camera wifi
    Then  ich sehe Ergebnissen oder Vorschlägen für camera wifi text
    And   ich sehe verschiedene camera wifi Produkte mit der beschreibungen
    And   ich sehe verschiedene camera wifi Produkte mit der Bewertungen
    And   ich sehe verschiedene camera wifi Produkte mit der Preise
    And   ich sehe verschiedene camera wifi Produkte mit der Lieferung infos
    And   ich sehe Dropdown-Menübutton mit dem Namen Alle als klickbar
    When  ich klicke auf Alle button
    Then  ich sehe im Dropdown-Menu verschiedene Produktkatagorie als klickbar
    And   Ich klicke im Dropdown-Menü auf die Option Zeitschriften
    Then  ich sehe Zeitschriften button als klickbar
    And   ich klicke auf die suchtaste
    Then  ich sehe Zeitschriften button als klickbar
    Then  ich sehe Ergebnissen oder Vorschlägen für camera wifi text
    And   ich sehe Ergebnisse von Alle Kategorien text
    And   ich sehe Keine Ergebnisse für camera wifi in Zeitschriften text
    When  ich klicke auf Zeitschriften button
    Then  ich sehe im Dropdown-Menu verschiedene Produktkatagorie als klickbar
    And   ich klicke im Dropdown-Menu auf die Option Bücher
    Then  ich sehe Bücher button als klickbar
    When  ich klicke auf die suchtaste
    Then  ich sehe Bücher button als klickbar
    And   ich sehe Ergebnissen oder Vorschlägen für camera wifi text
    And   ich sehe Ergebnisse titel
    And   Ich sehe Produkte mit buch, Ausgabe oder Kindle Beschreibungen unter den Ergebnissen.