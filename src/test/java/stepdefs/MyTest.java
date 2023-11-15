package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import stepdefs.BaseSteps;
import utils.PropertyReader;
import static pageObjects.Locators.*;


public class MyTest extends BaseSteps {
    BasePage bp = new BasePage();


    @Given("ich gehe auf die Amazon.de startseite.")
    public void ichGeheAufDieAmazonDeStartseite() {
        driver.navigate().to(PropertyReader.read("Config").get("url"));
    }

    @Then("ich sollte den {string} title sehen.")
    public void ichSollteDenTitleSehen(String text) {
        bp.titleContains(text);
    }

    @When("ich schreibe in weissem Suchfeld der {string} enthält, den text {string}.")
    public void ichSchreibeInWeissemSuchfeldDerEnthältDenText(String text1, String text2) {

        bp.sendKey(bp.getInputByLocator(text1), text2);

    }


    @Then("In einem Dropdown-Menu, {string} beginnende Producktüberschrifften sollten sichtbar sein.")
    public void inEinemDropdownMenuBeginnendeProducktüberschrifftenSolltenSichtbarSein(String text) {

        bp.checkDropProductsVisible(text,lDdMenuProds);
    }

    @And("In diesem Dropdown-Menu, {string} beginnende Producktüberschrifften sollten klickbar sein.")
    public void inDiesemDropdownMenuBeginnendeProducktüberschrifftenSolltenKlickbarSein(String text) {

        bp.checkDropProductsClickable(text,lDdMenuProds);
    }

    @When("ich klicke die suchtaste.")
    public void ichKlickeDieSuchtaste() throws InterruptedException {

        click(bp.getElement(lSearch));
        bp.sleep(3000);
    }


    @Then("ich sollte unter dem navbar {string} sehen.")
    public void ichSollteUnterDemNavbarSehen(String text) {

        bp.TextIsVisible(text);


    }

    @And("ich sollte unter dem navbar {string} text sehen dazu.")
    public void ichSollteUnterDemNavbarTextSehenDazu(String text) {

        bp.TextIsVisible(text);
    }

    @And("in der mitte der seite {string} haupttitel sollte sichtbar sein.")
    public void inDerMitteDerSeiteHaupttitelSollteSichtbarSein(String text) {

        bp.TextIsVisible(text,2);
    }

    @Then("unter dem Ergebnisse titel sollte ich die kleine fotos, beschreibungen und Kundenrezensionen sehen.")
    public void unterDemErgebnisseTitelSollteIchDieKleineFotosBeschreibungenUndKundenrezensionenSehen() {
        bp.checkFotos();
        bp.checkTheInfos();
        bp.checkRezension();

    }


    @And("unter dem Ergebnisse titel Produkte sollten {string} oder {string} sein.")
    public void unterDemErgebnisseTitelProdukteSolltenOderSein(String text1, String text2) {

        bp.checkTheInfosWithKeywords(text1,text2);
    }

    @When("ich klicke auf das Amazon.de Logo ganz oben links.")
    public void ichKlickeAufDasAmazonDeLogoGanzObenLinks() {
        click(lAmzLogo);

    }

    @And("unter dem navbar {string} text nicht sichtbar sein.")
    public void unterDemNavbarTextNichtSichtbarSein(String text) {
        bp.TextIsNotVisible(text,1);

    }


    @When("ich gebe {string} wort statt playstation fünf wort in weissem Suchfeld ein.")
    public void ichGebeAkflscnfjiriophzpWortStattPlaystationFünfWortInWeissemSuchfeldEin(String text) {

        bp.clear(bp.getInputByLocator("Suche Amazon.de"));
        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"), text);
    }

    @Then("Kein Dropdown-Menu sollte sichtbar sein.")
    public void keinDropdownMenuSollteSichtbarSein() {
        waitForInvisibility(lDdMenuProds);
    }

    @Then("{string} text sollte sichtbar sein.")
    public void textSollteSichtbarSein(String text) {
        bp.TextIsVisible(text);
    }


    @And("ich klicke {string} auf im DropdownMenu.")
    public void ichKlickeAufImDropdownMenu(String text) throws InterruptedException {
      bp.clickByString(text).click();
    }


}
