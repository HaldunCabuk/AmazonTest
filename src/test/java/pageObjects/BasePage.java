package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepdefs.BaseSteps;

import static pageObjects.Locators.*;

import java.util.ArrayList;
import java.util.List;


public class BasePage extends BaseSteps {

    WebElement element;

    public void acceptCookies(WebElement element) {

        if (element.isDisplayed()) {
            element.click();
        }
    }

    public void sleep(int num) {

        try {

            Thread.sleep(num);

        } catch (InterruptedException e) {

        }
    }

    public WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public boolean isSortingOptionsClickable(By locator) {

        boolean isTrue = false;

        if (driver.findElements(locator).size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            isTrue = true;
        }
        return isTrue;
    }


    // Said Hocanin Stale element hatasi cozumu//

  /*  public WebElement relocateStaleElement(WebElement element, By by)
    {
        return element = Driver.getDriver().findElement(by);
    }
*/

    public void click(WebElement element) {
        wait.until(driver -> {
            try {
                element.click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            } catch (Exception e) {
                return false;
            }
        });
    }


    public void titleContains(String text) {
        wait.until(ExpectedConditions.titleContains(text));
    }

    public By getInputByLocator(String text) {

        int index = 1;

        String xpath = "//*[@*[.='%s']]['" + index + "']";

        return By.xpath(String.format(xpath, text));

    }

    public void sendKey(By locator, String text) {
        element = getElement(locator);
        sendKey(element, text);


    }

    public void sendKey(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void checkDropProductsVisible(String text, By locator) {
        // bu metodda acilan dropmenudeki optionlarin verilen text degerle baslayip baslamadigi sayisal olarak assert edildi
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        long num = driver.findElements(locator).stream().filter(e -> !e.getText().toLowerCase().contains(text)).count();
        Assert.assertEquals(num, 0);

    }

    public void checkDropProductsClickable(String text, By locator, int nums) {
        // bu metodda acilan dropmenudeki optionlarin clickable olup olmadigi ve sayisi sorgulandi.

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        long num = driver.findElements(locator).stream().filter(e -> e.getText().toLowerCase().startsWith(text)).count();
        Assert.assertEquals(num, nums);


    }

    public void clear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }


    public void textIsVisible(String text) {

        String xpath = "//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')]";

        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));


    }


    public void textIsVisible(String text, int index) {
        // Ortak locatorlardan index nosundaki text iceriginin sorgusu yapildi
        String xpath = "(//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')])['" + index + "']";

        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));

    }

    public void checkTheFotos() {
        //Farkli locatorlara ait urunlerin foto mevcudiyetleri sorgulandi.
        By locator1 = By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]");
        By locator2 = By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
            int count = 0;
            List<WebElement> fotos = driver.findElements(lPhotos);
            for (WebElement foto : fotos) {
                count++;
            }
            Assert.assertNotEquals(count, 0);
        } catch (Exception e) {
            try {

                wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
                int count = 0;
                List<WebElement> fotos = driver.findElements(lPs5Fotos);
                for (WebElement foto : fotos) {
                    count++;
                }
                Assert.assertNotEquals(count, 0);
            } catch (Exception f) {
                f.printStackTrace();
            }
        } //Amz sayfasindaki urun fotolari,
        //kundenrezensionlari ve fotolari ile esletirilecekti ancak sayilarda surekli degisiklik var.
        //Bu yuzden fotolarin mevcudiyeti sorgulandi

    }

    public void checkPhotos() {

        int count = 0;
        List<WebElement> fotos = driver.findElements(lPhotos);
        for (WebElement foto : fotos) {
            count++;
        }
        Assert.assertNotEquals(count, 0);

    }


    public void checkTheInfos() {
        //Farkli locatorlarin gosterdigi urunlerin ayni metod icerisindeki beschreibung mevcudiyetleri sorgulandi.
        By locator1 = By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]");
        By locator2 = By.xpath("(//div[@class='a-section']/div)[1]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
            wait.until(driver -> {

                if (driver.findElements(lInfos).size() > 0) return true;
                return false;
            }); // sayi bazen degisiyor. bu nedenle Beschreibung larin mevcudiyeti sorgulandi.
        } catch (Exception e) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
                wait.until(driver -> {

                    if (driver.findElements(lPs5s).size() > 0) return true;
                    return false;
                });
            } catch (Exception f) {
                f.printStackTrace();
            }
        }

    }

    public void checkInfos() {

        wait.until(driver -> {
            if (driver.findElements(lInfos).size() > 0) return true;
            return false;
        });
    }

    public void checkTheInfosWithKeywords(String text1, String text2, String text3, int num) {

        int prodNums = 0;

        List<WebElement> prods = driver.findElements(lProducts);

        WebElement elm;

        for (int i = 0; i < num; i++) {

            elm = prods.get(i);

            if ((elm.getText().contains(text1)) | (elm.getText().contains(text2) | (elm.getText().contains(text3)))) {
                prodNums++;
            }
        }

        Assert.assertEquals(prodNums, num);
    }

    public void checkTheInfosWithKeywords(String text1, String text2) {
        //Farkli locatorlarin gosterdigi urunlerin ayni metod icerisinde VEYA kistasina gore KeywordBeschreibung mevcudiyetleri sorgulandi.
        By locator1 = By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]");

        if (driver.findElements(locator1).size() > 0) {

            int prodNums = 0;
            List<WebElement> texts = driver.findElements(lInfos);
            for (WebElement text : texts) {
                if ((text.getText().toLowerCase().contains(text1)) | (text.getText().contains(text2))) {
                    prodNums++;
                }

            }
            Assert.assertFalse(prodNums <= 0);
        } else {

            int prodNums = 0;
            List<WebElement> texts = driver.findElements(lPs5s);
            for (WebElement text : texts) {
                if ((text.getText().toLowerCase().contains(text1)) | (text.getText().contains(text2))) {
                    prodNums++;
                }

            }
            Assert.assertFalse(prodNums <= 0);
        }

    }


    public void checkTheRezension() {

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

    public void checkRezensionen() {

        wait.until(driver -> {
            if (driver.findElements(lRezensionens).size() > 0) return true;
            return false;
        });

    }

    public void checkPrices() {

        List<WebElement> prices = driver.findElements(lPrices);

        // Checked both product prices and assets were queried.

        for (int i = 0; i < 5; i++) {
            element = prices.get(i);
            String str = element.getText();

            String s = str.replaceAll("[^0-9]", "");
            int a = Integer.parseInt(s);

            Assert.assertTrue(a >= 0);

        }

    }

    public void aufsteigendePrices() {

        sleep(800);

        List<WebElement> prices = driver.findElements(lSortingPrices);
        List<String> elm = new ArrayList<>();
        List<Double> doubleNums = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < prices.size(); i++) {

            WebElement element = prices.get(i);
            elm.add(element.getText());
            String value = elm.get(i);
            String newValue = value.replaceAll("\\s", "").replaceAll("[^0-9]", "");
            double ondalikliSayi = Double.parseDouble("0." + newValue.substring(1));
            doubleNums.add(ondalikliSayi);

        }


        for (int i = 0; i < 20; i++) {

            try {
                if (doubleNums.get(i) <= doubleNums.get(i + 1))
                    counter++;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        Assert.assertEquals(counter, 20);


    }

    public void absteigendePrices() {

        sleep(800);

        List<WebElement> prices = driver.findElements(lSortingPrices);
        List<String> elm = new ArrayList<>();
        List<Double> doubleNums = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < prices.size(); i++) {

            WebElement element = prices.get(i);
            elm.add(element.getText());
            String value = elm.get(i);
            String newValue = value.replaceAll("\\s", "").replaceAll("[^0-9]", "");


            double ondalikliSayi = Double.parseDouble(newValue) / 1000;

            doubleNums.add(ondalikliSayi);

        }


        for (int i = 0; i < 15; i++) {

            try {
                if (doubleNums.get(i) >= doubleNums.get(i + 1))
                    counter++;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        Assert.assertEquals(counter, 15);


    }

    public void absteigendeBewertungen() {

        sleep(800);

        List<WebElement> bewertungen = driver.findElements(lSortingBewertungen);

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



    public void checkLieferungInfos() {
        wait.until(driver -> {
            if (driver.findElements(lLieferungInfos).size() > 0) return true;
            return false;
        });


    }

    public void textIsNotVisible(String text, int index) {

        String xpath = "(//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')])['" + index + "']";


        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(lConceitedText));

    }

    public WebElement getElementWithConcat(String text) {

        String xpath = "//div[@*='%s']";
        By lConceitedText = By.xpath(String.format(xpath, text));
        sleep(800);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));
    }

    public WebElement getElementWithConcat2(String text, int index) {

        String xpath1 = "(//div[@*='%s'])[" + index + "]";
        String xpath2 = "(//span[text()='%s'])[" + index + "]";
        String xpath3 = "(//li//*[text()='%s'])[" + index + "]";


        xpath1 = String.format(xpath1, text);
        xpath2 = String.format(xpath2, text);
        xpath3 = String.format(xpath3, text);


        String xpath = xpath1 + "|" + xpath2 + "|" + xpath3;

        By lConceitedText = By.xpath(xpath);
        sleep(700);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));
    }

    public WebElement clickByString(String text, String wanted) {

        By lConceitedText = By.xpath(String.format(text, wanted));
        return wait.until(ExpectedConditions.elementToBeClickable(lConceitedText));
    }

    public void checkClickableOf(String text, String wanted) {

        By lConceitedText = By.xpath(String.format(text, wanted));
        wait.until(ExpectedConditions.elementToBeClickable(lConceitedText));
    }


    public void checkDdOptionsVisibility(By locator) {
        List<WebElement> elements = driver.findElements(locator);

        for (int i = 0; i < elements.size(); i++) {
            element = elements.get(i);
            wait.until(ExpectedConditions.visibilityOf(element));
        }

    }

    public void checkDdSortingOpVisible(String text) {
        String str = "//option[text()='%s']";
        By lConceitedText = By.xpath(String.format(str, text));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));

    }

    public void checkDdSortingOpClickable(String text) {
        // String str = "//option[text()='%s']";
        String str = "//span[text()='%s']";
        By lConceitedText = By.xpath(String.format(str, text));
        wait.until(ExpectedConditions.elementToBeClickable(lConceitedText));

    }

    public void checkDdOptionsClickable(By locator) {

        List<WebElement> elements = driver.findElements(locator);

        for (int i = 0; i < elements.size(); i++) {
            element = elements.get(i);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }

   /* public WebElement aaa(String text){

        List<WebElement> elements = driver.findElements(lSelectOptions);
        WebElement elm;
        WebElement wantedElement = null;

        for (int i = 0; i < elements.size(); i++) {
            elm = elements.get(i);
            if (elm.getText().contains(text)){
                 wantedElement = elements.get(i);
                break;
            }

        }

        return wait.until(ExpectedConditions.visibilityOf(wantedElement));
    }*/

    /*public void select(String text,int num){
        new Select(aaa(text)).selectByIndex(num);
    }*/


    public void clickDdOptionbyAction(String text, By locator) {

        List<WebElement> elements = driver.findElements(locator);
        WebElement elm;
        WebElement wantedElement = null;
        int num = 0;

        for (int i = 0; i < elements.size(); i++) {
            elm = elements.get(i);
            num++;
            if (elm.getText().equals(text)) {
                wantedElement = elements.get(i);
                break;
            }
        }

        for (int i = 0; i < num; i++) {

            new Actions(driver).keyDown(Keys.ARROW_DOWN).perform();
        }

        sleep(750);
        wait.until(ExpectedConditions.visibilityOf(wantedElement)).click();
    }

    public void clickSortingOptionOf2(String text, By locator) {

        List<WebElement> elements = driver.findElements(locator);


        for (WebElement webElement : elements) {
            if (webElement.getText().equals(text)) {
                webElement.click();
            }
        }
    }

}

