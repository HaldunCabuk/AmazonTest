Feature: Verbesserte Suchgenauigkeit

  Scenario: ECPA-92 Verbesserte suchgenauigkeit(SortierOptionen)

    Given ich gehe auf die Amazon.de Startseite.
    Then ich sehe title Amazon.de
    When ich schreibe im Suchfeld der Suche Amazon.de enthält, den text socken
    And ich klicke auf die Suchtaste
    Then ich sehe Ergebnissen oder Vorschlägen für socken text
    And ich sehe Ergebnisse Titel
    And ich sehe verschiedene socken Produkte mit der Beschreibungen
    And ich sehe verschiedene socken Produkte mit der Bewertungen
    And ich sehe verschiedene socken Produkte mit der Preise
    And ich sehe verschiedene socken Produkte mit der Lieferung infos
    And ich sehe Dropdown-Menübutton mit dem Namen Sortieren nach:Empfohlen als sichtbar
    And ich sehe Dropdown-Menübutton mit dem Namen Sortieren nach:Empfohlen als klickbar
    When ich klicke auf Sortieren nach:Empfohlen-Button
    Then ich sehe im Dropdown-Menü verschiedene SortierenOptionen als sichtbar
    When Ich klicke im Dropdown-Menü auf die Option Preis: Aufsteigend
    Then ich sehe Dropdown-Menübutton mit dem Namen Preis: Aufsteigend-Button als sichtbar
    And ich sehe Ergebnissen oder Vorschlägen für socken text
    And ich sehe Ergebnisse Titel
    And ich sehe verschiedene socken Produkte mit der Beschreibungen
    And ich sehe verschiedene socken Produkte mit der Aufsteigende Preise
    When Ich klicke Dropdown-Menübutton mit dem Namen Preis: Aufsteigend
    Then ich sehe im Dropdown-Menü den Preis: Absteigend-Button als sichtbar
    When Ich klicke im Dropdown-Menü auf die Option Preis: Absteigend
    And ich sehe Ergebnissen oder Vorschlägen für socken text
    And ich sehe Ergebnisse Titel
    And ich sehe verschiedene socken Produkte mit der Beschreibungen
    And ich sehe verschiedene socken Produkte mit der Absteigende Preise
    When Ich klicke auf die Option Preis: Absteigend
    Then ich sehe den Durchschn. Kundenbewertung-Button als sichtbar
    When Ich klicke im Dropdown-Menü auf die Option Durchschn. Kundenbewertung
    And ich sehe Ergebnissen oder Vorschlägen für socken text
    And ich sehe Ergebnisse Titel
    And ich sehe verschiedene socken Produkte mit der Beschreibungen
    And ich sehe verschiedene socken Produkte mit der Absteigende Kundenbewertungen