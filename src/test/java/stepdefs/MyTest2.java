package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pageObjects.BasePage;
import static pageObjects.Locators.*;

public class MyTest2 extends BaseSteps{
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

        click(bp.clickByString("camera wifi"));
    }

    @Then("ich sehe Ergebnissen oder Vorschlägen für camera wifi text")
    public void ichSeheErgebnissenOderVorschlägenFürCameraWifiText() {

        waitForVisibility(xpath(lAllTexts,"Ergebnissen oder Vorschlägen für"));
        waitForVisibility(xpath(lAllTexts,"camera wifi"));
    }

    @And("ich sehe verschiedene camera wifis mit kleiner fotos, beschreibungen, Bewertungen, Preise und Lieferung infos")
    public void ichSeheVerschiedeneCameraWifisMitKleinerFotosBeschreibungenBewertungenPreiseUndLieferungInfos() {

        bp.checkPhotos();
        bp.checkInfos();
        bp.checkRezensionen();
        bp.checkPrices();
        bp.checkLieferungInfos();
    }

    @And("ich sehe Dropdown-Menübutton mit dem Namen Alle als klickbar")
    public void ichSeheDropdownMenübuttonMitDemNamenAlleAlsKlickbar() {

        bp.checkClickableOf(lDdButtonsName,"Alle");

    }

    @When("ich klicke Alle button")
    public void ichKlickeAlleButton() {

        click(bp.clickByString(lDdButtonsName,"Alle"));
        bp.sleep(2500);
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
}
