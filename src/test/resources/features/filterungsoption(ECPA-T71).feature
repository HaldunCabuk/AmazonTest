Feature: ECPA-92 Verbesserte Suchgenauigkeit

  Scenario: Überprüfung der Amazon.de-Suchfunktion und FilterungsOptionen

    Given ich gehe auf die Amazon.de Startseite.
    Then  ich sehe title Amazon.de
    When  ich schreibe im Suchfeld der Suche Amazon.de enthält, den text camera wifi
    And   ich sehe die verschiedene Produkten im Dropdown-Menu camera wifi enthält
    And   ich klicke auf camera wifi
    Then  ich sehe Ergebnissen oder Vorschlägen für camera wifi text
    And   ich sehe verschiedene camera wifi Produkte mit der Beschreibungen
    And   ich sehe verschiedene camera wifi Produkte mit der Bewertungen
    And   ich sehe verschiedene camera wifi Produkte mit der Preise
    And   ich sehe verschiedene camera wifi Produkte mit der Lieferung infos
    And   ich sehe Dropdown-Menübutton mit dem Namen Alle als klickbar
    When  ich klicke auf Alle button
    Then  ich sehe im Dropdown-Menü verschiedene Produktkategorien als klickbar
    And   Ich klicke im Dropdown-Menü auf die Option Zeitschriften
    Then  ich sehe den Zeitschriften-Button als klickbar
    And   ich klicke auf die Suchtaste
    Then  ich sehe den Zeitschriften-Button als klickbar
    Then  ich sehe Ergebnissen oder Vorschlägen für camera wifi text
    And   ich sehe Ergebnisse von Alle Kategorien text
    And   ich sehe Keine Ergebnisse für camera wifi in Zeitschriften text
    When  ich klicke auf den Zeitschriften-Button
    Then  ich sehe im Dropdown-Menü verschiedene Produktkategorien als klickbar
    And   ich klicke im Dropdown-Menü auf die Option Bücher
    Then  ich sehe den Bücher-Button als klickbar
    When  ich klicke auf die Suchtaste
    Then  ich sehe den Bücher-Button als klickbar
    And   ich sehe Ergebnissen oder Vorschlägen für camera wifi text
    And   ich sehe Ergebnisse Titel
    And   Ich sehe Produkte in den Suchergebnissen mit Bezeichnungen wie buch, Ausgabe oder Kindle-Beschreibungen.
