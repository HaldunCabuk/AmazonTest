package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;

import static pageObjects.Locators.*;

public class MyTestT70 extends BaseSteps{
    BasePage bp = new BasePage();
    @When("ich schreibe im Suchfeld der Suche Amazon.de enthält, den text socken")
    public void ichSchreibeImSuchfeldDerSucheAmazonDeEnthältDenTextSocken() {

        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"),"socken");
    }

    @Then("ich sehe Ergebnissen oder Vorschlägen für socken text")
    public void ichSeheErgebnissenOderVorschlägenFürSockenText() {

        waitForVisibility(xpath(lAllTexts,"Ergebnissen oder Vorschlägen für"));
        waitForVisibility(xpath(lAllTexts,"socken"));
    }

    @And("ich sehe verschiedene socken Produkte mit der Beschreibungen")
    public void ichSeheVerschiedeneSockenProdukteMitDerBeschreibungen() {

        bp.checkInfos();
    }

    @And("ich sehe verschiedene socken Produkte mit der Bewertungen")
    public void ichSeheVerschiedeneSockenProdukteMitDerBewertungen() {

        bp.checkRezensionen();
    }

    @And("ich sehe verschiedene socken Produkte mit der Preise")
    public void ichSeheVerschiedeneSockenProdukteMitDerPreise() {

        bp.checkPrices();
    }

    @And("ich sehe verschiedene socken Produkte mit der Lieferung infos")
    public void ichSeheVerschiedeneSockenProdukteMitDerLieferungInfos() {

        bp.checkLieferungInfos();
    }

    @And("ich sehe Dropdown-Menübutton mit dem Namen Sortieren nach:Empfohlen als sichtbar")
    public void ichSeheDropdownMenübuttonMitDemNamenSortierenNachEmpfohlenAlsSichtbar() {

        waitForVisibility(bp.getElementWithConcat2("Empfohlen",1));
    }

    @And("ich sehe Dropdown-Menübutton mit dem Namen Sortieren nach:Empfohlen als klickbar")
    public void ichSeheDropdownMenübuttonMitDemNamenSortierenNachEmpfohlenAlsKlickbar() {

        bp.checkDdSortingOpClickable("Empfohlen");
    }

    @When("ich klicke auf Sortieren nach:Empfohlen-Button")
    public void ichKlickeAufSortierenNachEmpfohlenButton() {
        click(bp.getElementWithConcat2("Empfohlen",1));

    }

    @Then("ich sehe im Dropdown-Menü verschiedene SortierenOptionen als sichtbar")
    public void ichSeheImDropdownMenüVerschiedeneSortierenOptionenAlsSichtbar() {

        bp.checkDdOptionsVisibility(lSortingOptions);
    }

    @When("Ich klicke im Dropdown-Menü auf die Option Preis: Aufsteigend")
    public void ichKlickeImDropdownMenüAufDieOptionPreisAufsteigend() {

        click(bp.getElementWithConcat2("Preis: Aufsteigend",1));
    }

    @Then("ich sehe Dropdown-Menübutton mit dem Namen Preis: Aufsteigend-Button als sichtbar")
    public void ichSeheDropdownMenübuttonMitDemNamenPreisAufsteigendButtonAlsSichtbar() {

        waitForVisibility(bp.getElementWithConcat2("Preis: Aufsteigend",1));
    }

    @And("ich sehe verschiedene socken Produkte mit der Aufsteigende Preise")
    public void ichSeheVerschiedeneSockenProdukteMitDerAufsteigendePreise() {

        bp.aufsteigendePrices();
    }

    @Then("ich sehe den Preis: Absteigend-Button als sichtbar")
    public void ichSeheDenPreisAbsteigendButtonAlsSichtbar() {

        waitForVisibility(bp.getElementWithConcat2("Preis: Aufsteigend",2));
    }

    @When("Ich klicke im Dropdown-Menü auf die Option Preis: Absteigend")
    public void ichKlickeImDropdownMenüAufDieOptionPreisAbsteigend() {

        click(bp.getElementWithConcat2("Preis: Absteigend",2));
    }

    @And("ich sehe verschiedene socken Produkte mit der Absteigende Preise")
    public void ichSeheVerschiedeneSockenProdukteMitDerAbsteigendePreise() {

        bp.absteigendePrices();
    }


    @When("Ich klicke auf die Option Preis: Absteigend")
    public void ichKlickeAufDieOptionPreisAbsteigend() {

        click(bp.getElementWithConcat2("Preis: Absteigend",1));
    }

    @Then("ich sehe den Durchschn. Kundenbewertung-Button als sichtbar")
    public void ichSeheDenDurchschnKundenbewertungButtonAlsSichtbar() {

        waitForVisibility(bp.getElementWithConcat2("Durchschn. Kundenbewertung",3));
    }

    @When("Ich klicke im Dropdown-Menü auf die Option Durchschn. Kundenbewertung")
    public void ichKlickeImDropdownMenüAufDieOptionDurchschnKundenbewertung() {

        click(bp.getElementWithConcat2("Durchschn. Kundenbewertung",3));
    }

    @And("ich sehe verschiedene socken Produkte mit der Absteigende Kundenbewertungen")
    public void ichSeheVerschiedeneSockenProdukteMitDerAbsteigendeKundenbewertungen() {

        bp.absteigendeBewertungen();
    }
}
