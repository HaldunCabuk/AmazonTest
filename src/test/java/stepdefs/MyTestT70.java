package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;

import static pageObjects.Locators.lAllTexts;

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
}
