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

    @Then("ich sehe title {string}")
    public void ichSeheTitle(String text) {
        bp.titleContains(text);

    }

    @When("ich schreibe im Suchfeld der {string} enthält, den text {string}.")
    public void ichSchreibeImSuchfeldDerEnthältDenText(String text1, String text2) {

        bp.sendKey(bp.getInputByLocator(text1), text2);
        bp.sleep(1700);
    }

    @Then("ich sehe im Dropdown-Menu {string} beginnende Producktüberschrifften")
    public void ichSeheImDropdownMenuBeginnendeProducktüberschrifften(String text) {
        bp.checkDropProductsVisible(text,lDdMenuProds);
    }

    @And("ich sehe im Dropdown-Menu {string} beginnende Producktüberschrifften als klickbar")
    public void ichSeheImDropdownMenuBeginnendeProducktüberschrifftenAlsKlickbar(String text) {
        bp.checkDropProductsClickable(text,lDdMenuProds,10);
    }

    @When("ich klicke die suchtaste.")
    public void ichKlickeDieSuchtaste() {

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

    @And("ich sehe {string} haupttitel.")
    public void ichSeheInDerMitteDerSeiteHaupttitel(String text) {

        bp.TextIsVisible(text,2);
    }

    @And("ich sehe unter der Ergebnisse titel die kleine fotos, beschreibungen und Kundenrezensionen")
    public void ichSeheUnterDerErgebnisseTitelDieKleineFotosBeschreibungenUndKundenrezensionen() {

        bp.checkFotos();
        bp.checkTheInfos();
        bp.checkRezension();
    }

    @And("ich sehe unter dem Ergebnisse haupttitel {string} oder {string} Produkte.")
    public void ichSeheUnterDemErgebnisseHaupttitelOderProdukte(String text1, String text2) {

        bp.checkTheInfosWithKeywords(text1,text2);
    }



    @When("ich klicke auf das Amazon.de Logo.")
    public void ichKlickeAufDasAmazonDeLogo() {
        click(lAmzLogo);
    }

    @And("ich sehe nicht unter dem navbar {string} text")
    public void ichSeheNichtUnterDemNavbarText(String text) {

        bp.TextIsNotVisible(text,1);
    }


    @When("ich gebe {string} wort statt playstation fünf wort im Suchfeld ein.")
    public void ichGebeWortStattPlaystationFünfWortImSuchfeldEin(String text) {

        bp.clear(bp.getInputByLocator("Suche Amazon.de"));
        bp.sendKey(bp.getInputByLocator("Suche Amazon.de"), text);
    }

    @Then("ich sehe kein Dropdown-Menu")
    public void ichSeheKeinDropdownMenu() {

        waitForInvisibility(lDdMenuProds);
    }

    @Then("ich sehe {string} text.")
    public void ichSeheText(String text) {

        bp.TextIsVisible(text);
    }

    @And("ich klicke {string} auf im DropdownMenu.")
    public void ichKlickeAufImDropdownMenu(String text) {
      bp.clickByString(text).click();
    }

}