package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import static pageObjects.Locators.*;

public class MyTestT71 extends BaseSteps{
    BasePage bp = new BasePage();



    @Then("ich sehe title Amazon.de")
    public void ichSeheTitleAmazonDe() {

        bp.titleContains("Amazon.de");
    }

    @When("ich schreibe im Suchfeld der Suche Amazon.de enthält, den text camera wifi")
    public void ichSchreibeImSuchfeldDerSucheAmazonDeEnthältDenTextCameraWifi() {

        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"),"camera wifi");
        bp.sleep(1500);
    }

    @And("ich sehe die verschiedene Produkten im Dropdown-Menu camera wifi enthält")
    public void ichSeheDieVerschiedeneProduktenImDropdownMenuCameraWifiEnthält() {

        bp.checkDropProductsVisible("camera wifi",lDdMenuProds);
    }

    @And("ich klicke auf camera wifi")
    public void ichKlickeAufCameraWifi() {

        click(bp.getElementWithConcat("camera wifi"));
    }

    @Then("ich sehe Ergebnissen oder Vorschlägen für camera wifi text")
    public void ichSeheErgebnissenOderVorschlägenFürCameraWifiText() {

        waitForVisibility(xpath(lAllTexts,"Ergebnissen oder Vorschlägen für"));
        waitForVisibility(xpath(lAllTexts,"camera wifi"));
    }

    @And("ich sehe Dropdown-Menübutton mit dem Namen Alle als klickbar")
    public void ichSeheDropdownMenübuttonMitDemNamenAlleAlsKlickbar() {

        bp.checkClickableOf(lDdButtonsName,"Alle");

    }

    @When("ich klicke auf Alle button")
    public void ichKlickeAufAlleButton() {

        click(bp.clickByString(lDdButtonsName,"Alle"));
        bp.sleep(2000);
    }

    @Then("ich sehe im Dropdown-Menü verschiedene Produktkategorien als klickbar")
    public void ichSeheImDropdownMenüVerschiedeneProduktkategorienAlsKlickbar() {

        bp.checkDdOptionsVisibility();
        bp.checkDdOptionsClickable();
    }

    @And("Ich klicke im Dropdown-Menü auf die Option Zeitschriften")
    public void ichKlickeImDropdownMenüAufDieOptionZeitschriften() {

        bp.clickDdOptionbyAction("Zeitschriften");
    }

    @Then("ich sehe den Zeitschriften-Button als klickbar")
    public void ichSeheDenZeitschriftenButtonAlsKlickbar() {

        bp.checkClickableOf(lDdButtonsName,"Zeitschriften");
    }

    @And("ich klicke auf die Suchtaste")
    public void ichKlickeAufDieSuchtaste() {

        click(lSearchButton);
    }

    @And("ich sehe Ergebnisse von Alle Kategorien text")
    public void ichSeheErgebnisseVonAlleKategorienText() {

        waitForVisibility(xpath(lAllTexts,"Ergebnisse von Alle Kategorien"));
    }

    @And("ich sehe Keine Ergebnisse für camera wifi in Zeitschriften text")
    public void ichSeheKeineErgebnisseFürCameraWifiInZeitschriftenText() {

        waitForVisibility(xpath(lAllTexts,"Keine Ergebnisse für camera wifi in Zeitschriften"));
    }

    @When("ich klicke auf den Zeitschriften-Button")
    public void ichKlickeAufDenZeitschriftenButton() {

        click(bp.clickByString(lDdButtonsName,"Zeitschriften"));
    }

    @And("ich klicke im Dropdown-Menü auf die Option Bücher")
    public void ichKlickeImDropdownMenüAufDieOptionBücher() {

        bp.clickDdOptionbyAction("Bücher");
    }

    @Then("ich sehe den Bücher-Button als klickbar")
    public void ichSeheDenBücherButtonAlsKlickbar() {

        bp.checkClickableOf(lDdButtonsName,"Bücher");
    }


    @And("ich sehe Ergebnisse Titel")
    public void ichSeheErgebnisseTitel() {

        waitForVisibility(xpath(lAllTexts,"Ergebnisse"));
    }

    @And("ich sehe verschiedene camera wifi Produkte mit der Beschreibungen")
    public void ichSeheVerschiedeneCameraWifiProdukteMitDerBeschreibungen() {

        bp.checkInfos();
    }

    @And("ich sehe verschiedene camera wifi Produkte mit der Bewertungen")
    public void ichSeheVerschiedeneCameraWifiProdukteMitDerBewertungen() {

        bp.checkRezensionen();
    }

    @And("ich sehe verschiedene camera wifi Produkte mit der Preise")
    public void ichSeheVerschiedeneCameraWifiProdukteMitDerPreise() {

        bp.checkPrices();
    }

    @And("ich sehe verschiedene camera wifi Produkte mit der Lieferung infos")
    public void ichSeheVerschiedeneCameraWifiProdukteMitDerLieferungInfos() {

        bp.checkLieferungInfos();
    }


    @And("Ich sehe Produkte in den Suchergebnissen mit Bezeichnungen wie buch, Ausgabe oder Kindle-Beschreibungen.")
    public void ichSeheProdukteInDenSuchergebnissenMitBezeichnungenWieBuchAusgabeOderKindleBeschreibungen() {

        bp.checkTheInfosWithKeywords("buch","Ausgabe","Kindle",3);
    }
}
