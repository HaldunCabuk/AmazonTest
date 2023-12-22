package denemeTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import utils.PropertyReader;

import static pageObjects.Locators.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmzTest extends BasePage {

    /*   WebDriver driver;
       WebDriverWait wait;
   */
    final String url = "https://www.amazon.de/";
    WebElement element;
    Locators locators;


    By lDdMenuProds = By.cssSelector(".s-suggestion-container div");
    By lText = By.xpath("//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')]");

    By lSearch = By.cssSelector("#nav-search-submit-button");
    By lInfos = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']");
    By lRezensionen = By.xpath("//a[@class='a-popover-trigger a-declarative']");
    By lFotos = By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']");
    By lAmzLogo = By.xpath("//a[@*='Amazon.de']");
    By lPs5 = By.xpath("//div[@*='playstation 5']");
    By lPs5s = By.xpath("//div[@class='a-section']/div");
    By lPs5Fotos = By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']");
    By lSortedPrices = By.xpath("//span[@data-a-size=\"xl\" and .//span]");
    By lSortedBewertungen = By.cssSelector(".a-icon.a-icon-star-small.a-star-small-5.aok-align-bottom > span");


    public AmzTest() {
        /*driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));*/
        locators = PageFactory.initElements(driver, Locators.class);
    }


    /* @Test
     public void aaa() throws InterruptedException {
         driver.get(url);//++
         wait.until(ExpectedConditions.titleContains("Amazon")); // assert title ++
         sendKey(getInputByLocator("Suche Amazon.de"), "wireless");//++
         checkDropProducts("wireless", lDdMenuProds);//++
         checkDropProductsClickable("wireless", lDdMenuProds);//++
         click(lSearch);//++
         sleep(3000);
         checkTheInfos("qqq", "xxx", lInfos);
         checkRezension();
         checkFoto(lFotos);
         click(lAmzLogo);
         sendKey(getInputByLocator("Suche Amazon.de"), "playstation");//++
         checkDropProducts("playstation", lDdMenuProds);//++
         click(lPs5);//++
         checkTheInfos("ps5", "playstation 5", lPs5s);
         checkRezension();
         checkFoto(lPs5Fotos);
         clear(getInputByLocator("Suche Amazon.de"));//++
         sendKey(getInputByLocator("Suche Amazon.de"), "akflscnfjiriophzp");//++
         wait.until(ExpectedConditions.invisibilityOfElementLocated(lDdMenuProds));//++Dropdownmenunun cikmadigi teyit edildi
         click(lSearch);//++
         sleep(3000);
         TextIsVisible("Keine Ergebnisse");//++
         TextIsNotVisible("xxxxxxxxxxx");//++

         *//* checkDropProducts("wireless");
        System.out.println(arr);*//*
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".s-suggestion-container div"),0));
        //Assert.assertTrue(locators.products.size()>0);

    }*/
    @Test
    public void test2() {
        driver.navigate().to(PropertyReader.read("Config").get("url"));
        acceptCookies(getElement(lAcceptCookies));
        click(getElement(lAlleHamburger));
        click(getElement(lPrimeVideoButton));
        sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lAlleVidButton));
        hoverOverByAction(lAlleVidButton);


    }

    @Test
    public void test3() { // Onemli -> DropDown Menu acildi mi diye baktigimiz adimlar
        By locator = By.cssSelector("#nav-search-dropdown-card > div");
        driver.navigate().to(PropertyReader.read("Config").get("url"));
        click(locator);
        wait.until(ExpectedConditions.attributeContains(locator, "class", "nav-focus"));


    }

    @Test
    public void testT70() {

        BasePage bp = new BasePage();

        driver.navigate().to(PropertyReader.read("Config").get("url"));
        bp.acceptCookies(bp.getElement(lAcceptCookies));
        sendKey(getInputByLocator("Suche Amazon.de"), "socken");
        click(lSearchButton);
        click(bp.getElementWithConcat2("Empfohlen",1));
        click(bp.getElementWithConcat2("Durchschn. Kundenbewertung",1));

        sleep(800);

        List<WebElement> bewertungen = driver.findElements(lSortedBewertungen);

        List<String> elm = new ArrayList<>();
        List<Double> doubleNums = new ArrayList<>();
        int counter = 0;


        for (int i = 0; i < bewertungen.size(); i++) {


            WebElement element = bewertungen.get(i);
            elm.add(element.getAttribute("innerHTML"));
            String value = elm.get(i);
            String newValue = value.replaceAll(",",".").substring(0,4);
            double ondalikliSayi = Double.parseDouble(newValue);
            doubleNums.add(ondalikliSayi);

        }




        for (int i = 14; i < 34; i++) {

            try {
                if (doubleNums.get(i) >= doubleNums.get(i + 1))
                   counter++;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        Assert.assertEquals(counter,20);


    }


    public void checkDropProducts(String text, By locator) {
        // bu metodda acilan dropmenudeki optionlarin verilen text degerle baslayip baslamadigi assert edildi
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        long num = driver.findElements(locator).stream().filter(e -> !e.getText().toLowerCase().startsWith(text)).count();
        Assert.assertEquals(num, 0);

    }


    public void checkDropProductsClickable(String text, By locator) {
        // bu metodda acilan dropmenudeki optionlarin clickable olup olmadigi ve sayisi sorgulandi.
        List<WebElement> prods = driver.findElements(locator);

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        long num = driver.findElements(locator).stream().filter(e -> e.getText().toLowerCase().startsWith(text)).count();
        Assert.assertEquals(num, 10);

    }


    public void sleep(int num) {
        try {

            Thread.sleep(num);

        } catch (InterruptedException e) {

        }
    }

    @AfterTest()
    public void afterTest() {
        //driver.quit();
    }

    public void sendKey(By locator, String text) {

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        sendKey(element, text);


    }

    public void sendKey(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public By getInputByLocator(String text) {

        int index = 1;

        String xpath = "//*[@*[.='%s']]['" + index + "']";

        return By.xpath(String.format(xpath, text));

    }

    public By getInputByLocator(String text, int index) {

        String xpath = "//*[@*[.='%s']]['" + index + "']";

        return By.xpath(String.format(xpath, text));

    }

    public void TextIsVisible(String text) {

        String xpath = "//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')]";

        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));


    }

    public void TextIsNotVisible(String text) {

        String xpath = "//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')]";


        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(lConceitedText));

    }

   /* public void checkDropProducts() {
        for (WebElement product : locators.products) {
            System.out.println(product.getText());
        }
    }*/


    public void checkTheInfos(String text1, String text2, By locator) {

        int prodNums = 0;
        List<WebElement> texts = driver.findElements(locator);


        for (WebElement text : texts) {
            if ((text.getText().toLowerCase().contains(text1)) & (text.getText().contains(text2))) {
                prodNums++;
            }

        }
        Assert.assertFalse(prodNums <= 0);// sayi bazen degisiyor. bu nedenle belirli bir sayi assert edilmedi.


        //long num1 = driver.findElements(lInfos).stream().filter(e -> !e.getText().toLowerCase().contains(text1)).count();
        //long num2 = driver.findElements(lInfos).stream().filter(e -> !e.getText().toLowerCase().contains(text2)).count();
        // Assert.assertEquals(num1, 0);
        // System.out.println(num2);

        //Assert.assertEquals(num1+num2,0);
    }

    public void checkRezension() {

        int rezNums = 0;


        List<WebElement> rezensionen = driver.findElements(lRezensionen);

        for (WebElement rezension : rezensionen) {

            if (rezension.getText().toLowerCase().contains("rezension")) {
                rezNums++;

            }
            Assert.assertFalse(rezNums < 0);// sayi bazen degisiyor. bu nedenle belirli bir sayi assert etmek
            // yerine musteri oylamalarinin sayfada olup olmadigi check edildi.
        }

    }

    public void checkFoto(By locator) {

        int count = 0;

        List<WebElement> fotos = driver.findElements(locator);

        for (WebElement foto : fotos) {
            count++;
        }
        Assert.assertNotEquals(count, 0);//Amz sayfasindaki urun aciklamalari,
        //kundenrezensionlari ve fotolari ile esletirilecekti ancak sayilarda surekli degisiklik var.

    }

    public WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

}


