Feature: Verbesserte Suchgenauigkeit

  Scenario: ECPA-92 Verbesserte suchgenauigkeit(FilterungsOption)

Given ich gehe auf die Amazon.de startseite.
Then ich sehe title Amazon.de
When ich schreibe im suchfeld der Suche Amazon.de enthält, den text camera wifi
And ich sehe die verschiedene Produkten im Dropdown-Menu camera wifi enthält
And ich klicke camera wifi
Then ich sehe Ergebnissen oder Vorschlägen für camera wifi text
And ich sehe verschiedene camera wifis mit beschreibungen, Bewertungen, Preise und Lieferung infos
And ich sehe Dropdown-Menübutton mit dem Namen Alle als klickbar
When ich klicke Alle button
Then ich sehe im Dropdown-Menu verschiedene Produktkatagorie als klickbar
And ich klicke im Dropdown-Menu Zeitschriften option
Then ich sehe Zeitschriften button als klickbar
And ich klicke auf die suchtaste
Then ich sehe Zeitschriften button als klickbar
Then ich sehe Ergebnissen oder Vorschlägen für camera wifi text
And ich sehe Ergebnisse von Alle Kategorien text
And ich sehe Keine Ergebnisse für camera wifi in Zeitschriften text
When ich klicke Zeitschriften button
Then ich sehe im Dropdown-Menu verschiedene Produktkatagorie als klickbar
And ich klicke im Dropdown-Menu Bücher option
Then ich sehe Bücher button als klickbar
When ich klicke auf die suchtaste
Then ich sehe Bücher button als klickbar
And ich sehe Ergebnissen oder Vorschlägen für camera wifi text
And ich sehe Ergebnisse titel
And ich sehe unter dem Ergebnisse titel buch, Ausgabe oder Kindle Produkte