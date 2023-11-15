Feature: Verbesserte Suchgenauigkeit

  Scenario: ECPA-92 Verbesserte suchgenauigkeit(Genauigkeit der Suche/SuchVorschläge)
    Given ich gehe auf die Amazon.de startseite.
    Then ich sollte den "Amazon.de" title sehen.
    When ich schreibe in weissem Suchfeld der "Suche Amazon.de" enthält, den text "wireless".
    Then In einem Dropdown-Menu, "wireless" beginnende Producktüberschrifften sollten sichtbar sein.
    And In diesem Dropdown-Menu, "wireless" beginnende Producktüberschrifften sollten klickbar sein.
    When ich klicke die suchtaste.
    Then ich sollte unter dem navbar "Ergebnissen oder Vorschlägen für" sehen.
    And ich sollte unter dem navbar "wireless" text sehen dazu.
    And in der mitte der seite "Ergebnisse" haupttitel sollte sichtbar sein.
    Then unter dem Ergebnisse titel sollte ich die kleine fotos, beschreibungen und Kundenrezensionen sehen.
    And unter dem Ergebnisse titel Produkte sollten "wireless" oder "kabellos" sein.
    When ich klicke auf das Amazon.de Logo ganz oben links.
    Then ich sollte den "Amazon.de" title sehen.
    And  unter dem navbar "Ergebnissen oder Vorschlägen für" text nicht sichtbar sein.
    When ich schreibe in weissem Suchfeld der "Suche Amazon.de" enthält, den text "playstation".
    Then In einem Dropdown-Menu, "playstation" beginnende Producktüberschrifften sollten sichtbar sein.
    Then In diesem Dropdown-Menu, "playstation" beginnende Producktüberschrifften sollten klickbar sein.
    And ich klicke "playstation 5" auf im DropdownMenu.
    Then ich sollte unter dem navbar "Ergebnissen oder Vorschlägen für" sehen.
    And ich sollte unter dem navbar "playstation 5" text sehen dazu.
    And in der mitte der seite "Ergebnisse" haupttitel sollte sichtbar sein.
    And unter dem Ergebnisse titel sollte ich die kleine fotos, beschreibungen und Kundenrezensionen sehen.
    And unter dem Ergebnisse titel Produkte sollten "ps5" oder "playstation 5" sein.
    When ich gebe "akflscnfjiriophzp" wort statt playstation fünf wort in weissem Suchfeld ein.
    Then Kein Dropdown-Menu sollte sichtbar sein.
    When ich klicke die suchtaste.
    Then "Keine Ergebnisse" text sollte sichtbar sein.
    And unter dem navbar "Ergebnissen oder Vorschlägen für" text nicht sichtbar sein.
