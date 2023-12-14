package stepdefs;

import io.cucumber.java.en.And;
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

    @When("ich schreibe im suchfeld der Suche Amazon.de enthält, den text camera wifi")
    public void ichSchreibeImSuchfeldDerSucheAmazonDeEnthältDenTextCameraWifi() {

        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"),"camera wifi");
        bp.sleep(1500);
    }

    @And("ich sehe die verschiedene Produkten im Dropdown-Menu camera wifi enthält")
    public void ichSeheDieVerschiedeneProduktenImDropdownMenuCameraWifiEnthält() {

        bp.checkDropProductsVisible("camera wifi",lDdMenuProds);
    }

    @And("ich klicke camera wifi")
    public void ichKlickeCameraWifi() {

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

    @When("ich klicke Alle button")
    public void ichKlickeAlleButton() {

        click(bp.clickByString(lDdButtonsName,"Alle"));
        bp.sleep(2000);
    }

    @Then("ich sehe im Dropdown-Menu verschiedene Produktkatagorie als klickbar")
    public void ichSeheImDropdownMenuVerschiedeneProduktkatagorieAlsKlickbar() {

        bp.checkDdOptionsVisibility();
        bp.checkDdOptionsClickable();
    }

    @And("ich klicke im Dropdown-Menu Zeitschriften option")
    public void ichKlickeImDropdownMenuZeitschriftenOption() {

      bp.clickDdOptionbyAction("Zeitschriften");
    }

    @Then("ich sehe Zeitschriften button als klickbar")
    public void ichSeheZeitschriftenButtonAlsKlickbar() {

        bp.checkClickableOf(lDdButtonsName,"Zeitschriften");
    }

    @And("ich klicke auf die suchtaste")
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

    @When("ich klicke Zeitschriften button")
    public void ichKlickeZeitschriftenButton() {

        click(bp.clickByString(lDdButtonsName,"Zeitschriften"));
    }

    @And("ich klicke im Dropdown-Menu Bücher option")
    public void ichKlickeImDropdownMenuBücherOption() {

        bp.clickDdOptionbyAction("Bücher");
    }

    @Then("ich sehe Bücher button als klickbar")
    public void ichSeheBücherButtonAlsKlickbar() {

        bp.checkClickableOf(lDdButtonsName,"Bücher");
    }

    @And("ich sehe Ergebnisse titel")
    public void ichSeheErgebnisseTitel() {

        waitForVisibility(xpath(lAllTexts,"Ergebnisse"));
    }
    @And("ich sehe unter dem Ergebnisse titel buch, Ausgabe oder Kindle Produkte")
    public void ichSeheUnterDemErgebnisseTitelBuchAusgabeOderKindleProdukte() {

        bp.checkTheInfosWithKeywords("buch","Ausgabe","Kindle",3);
    }


    @And("ich sehe verschiedene camera wifi Produkte mit der beschreibungen")
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
}
