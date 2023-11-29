package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;

import static pageObjects.Locators.*;

public class MyTest3 {

    BasePage bp = new BasePage();
    @When("ich schreibe im Suchfeld der Suche Amazon.de enthält, den text wireless")
    public void ichSchreibeImSuchfeldDerSucheAmazonDeEnthältDenTextWireless() {

        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"), "wireless");
        bp.sleep(800);
    }


    @Then("ich sehe im Dropdown-Menu wireless beginnende Producktüberschrifften")
    public void ichSeheImDropdownMenuWirelessBeginnendeProducktüberschrifften() {

        bp.checkDropProductsVisible("wireless",lDdMenuProds);
    }
    @And("ich sehe im Dropdown-Menu wireless beginnende Producktüberschrifften als klickbar")
    public void ichSeheImDropdownMenuWirelessBeginnendeProducktüberschrifftenAlsKlickbar() {

        bp.checkDropProductsClickable("wireless",lDdMenuProds,10);
    }

    @Then("ich sehe unter dem Ergebnisse titel wireless oder kabellos Produkte")
    public void ichSeheUnterDemErgebnisseTitelWirelessOderKabellosProdukte() {

        bp.checkTheInfosWithKeywords("wireless","kabellos");
    }

    @Then("ich sehe unter dem navbar Ergebnissen oder Vorschlägen text")
    public void ichSeheUnterDemNavbarErgebnissenOderVorschlägenText() {

        bp.textIsVisible("Ergebnissen oder Vorschlägen");
    }

    @And("ich sehe unter dem navbar wireless text")
    public void ichSeheUnterDemNavbarWirelessText() {

        bp.textIsVisible("wireless");
    }

    @And("ich sehe nicht unter dem navbar Ergebnissen oder Vorschlägen für text")
    public void ichSeheNichtUnterDemNavbarErgebnissenOderVorschlägenFürText() {

        bp.textIsNotVisible("Ergebnissen oder Vorschlägen für",1);
    }

    @When("ich schreibe im Suchfeld der Suche Amazon.de enthält, den text playstation")
    public void ichSchreibeImSuchfeldDerSucheAmazonDeEnthältDenTextPlaystation() {

        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"), "playstation");
    }

    @Then("ich sehe im Dropdown-Menu playstation beginnende Producktüberschrifften")
    public void ichSeheImDropdownMenuPlaystationBeginnendeProducktüberschrifften() {

        bp.checkDropProductsVisible("playstation",lDdMenuProds);
    }

    @Then("ich sehe im Dropdown-Menu playstation beginnende Producktüberschrifften als klickbar")
    public void ichSeheImDropdownMenuPlaystationBeginnendeProducktüberschrifftenAlsKlickbar() {

        bp.checkDropProductsClickable("playstation",lDdMenuProds,10);
    }

    @When("ich klicke playstation 5 auf im DropdownMenu")
    public void ichKlickePlaystationFünfAufImDropdownMenu() {

        bp.getElementWithConcat("playstation 5").click();
    }


    @Then("ich sehe unter dem Ergebnisse titel ps5 oder playstation 5 Produkte")
    public void ichSeheUnterDemErgebnisseTitelPsfünfOderPlaystationFünfProdukte() {

        bp.checkTheInfosWithKeywords("ps5","playstation 5");
    }

    @And("ich sehe unter dem navbar Ergebnissen oder Vorschlägen für text")
    public void ichSeheUnterDemNavbarErgebnissenOderVorschlägenFürText() {

        bp.textIsVisible("Ergebnissen oder Vorschlägen für");
    }

    @And("ich sehe unter dem navbar playstation 5 text")
    public void ichSeheUnterDemNavbarPlaystationFünfText() {

        bp.textIsVisible("playstation 5");
    }

    @Then("ich gebe akflscnfjiriophzp wort statt playstation 5 wort im Suchfeld ein")
    public void ichGebeAkflscnfjiriophzpWortStattPlaystationFünfWortImSuchfeldEin() {

        bp.clear(bp.getInputByLocator("Suche Amazon.de"));
        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"), "akflscnfjiriophzp");
    }

    @Then("ich sehe Keine Ergebnisse text")
    public void ichSeheKeineErgebnisseText() {

        bp.textIsVisible("Keine Ergebnisse");
    }

    @And("ich sehe Benötigst du Hilfe? text")
    public void ichSeheBenötigstDuHilfeText() {

        bp.textIsVisible("Benötigst du Hilfe?");
    }
}
