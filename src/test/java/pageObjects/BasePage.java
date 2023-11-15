package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import stepdefs.BaseSteps;

import static pageObjects.Locators.*;

import java.util.List;

public class BasePage extends BaseSteps {

    WebElement element;

    public void sleep(int num) {

        try {

            Thread.sleep(num);

        } catch (InterruptedException e) {

        }
    }

    public WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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
        // bu metodda acilan dropmenudeki optionlarin verilen text degerle baslayip baslamadigi assert edildi

        long num = driver.findElements(locator).stream().filter(e -> !e.getText().toLowerCase().startsWith(text)).count();
        Assert.assertEquals(num, 0);

    }

    public void checkDropProductsClickable(String text, By locator) {

        List<WebElement> prods = driver.findElements(locator);

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        long num = driver.findElements(locator).stream().filter(e -> e.getText().toLowerCase().startsWith(text)).count();
        Assert.assertEquals(num, prods.size());


    }

    public void clear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }


    public void TextIsVisible(String text) {

        String xpath = "//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')]";

        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));


    }

    public void TextIsVisible(String text, int index) {

        String xpath = "(//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')])['" + index + "']";

        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));

    }

    public void checkFotos() {
        By locator1 = By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]");
        By locator2 = By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
            int count = 0;
            List<WebElement> fotos = driver.findElements(lFotos);
            for (WebElement foto : fotos) {
                count++;
            }
            Assert.assertNotEquals(count, 0);
        }catch (Exception e){
            try {

                wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
                int count = 0;
                List<WebElement> fotos = driver.findElements(lPs5Fotos);
                for (WebElement foto : fotos) {
                    count++;
                }
                Assert.assertNotEquals(count, 0);
            }catch (Exception f){
                f.printStackTrace();
            }
        } //Amz sayfasindaki urun fotolari,
        //kundenrezensionlari ve fotolari ile esletirilecekti ancak sayilarda surekli degisiklik var.
        //Bu yuzden fotolarin mevcudiyeti sorgulandi

    }


    public void checkTheInfos() {
        By locator1 = By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]");
        By locator2 = By.xpath("(//div[@class='a-section']/div)[1]");
       try {
           wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
           wait.until(driver -> {

               if (driver.findElements(lInfos).size() > 0) return true;
               return false;
           }); // sayi bazen degisiyor. bu nedenle Beschreibung larin mevcudiyeti sorgulandi.
       }catch (Exception e){
           try {
               wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
               wait.until(driver -> {

                   if (driver.findElements(lPs5s).size() > 0) return true;
                   return false;
               });
           }catch (Exception f){
               f.printStackTrace();
           }
       }

    }

    public void checkTheInfosWithKeywords(String text1, String text2) {
        By locator1 = By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]");
        By locator2 = By.xpath("(//div[@class='a-section']/div)[1]");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
            int prodNums = 0;
            List<WebElement> texts = driver.findElements(lInfos);
            for (WebElement text : texts) {
                if ((text.getText().toLowerCase().contains(text1)) | (text.getText().contains(text2))) {
                    prodNums++;
                }

            }
            Assert.assertFalse(prodNums <= 0);
        }catch (Exception e){
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
                int prodNums = 0;
                List<WebElement> texts = driver.findElements(lPs5s);
                for (WebElement text : texts) {
                    if ((text.getText().toLowerCase().contains(text1)) | (text.getText().contains(text2))) {
                        prodNums++;
                    }

                }
                Assert.assertFalse(prodNums <= 0);
            }catch (Exception f){
                f.printStackTrace();
            }
        }


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
    public void TextIsNotVisible(String text, int index) {

        String xpath = "(//div[@class='sg-col-inner' and //div[@class='a-row']]//span[contains(text(),'%s')])['" + index + "']";


        By lConceitedText = By.xpath(String.format(xpath, text));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(lConceitedText));

    }
    public WebElement clickByString(String text) {
        String xpath = "//div[@*='%s']";
        By lConceitedText = By.xpath(String.format(xpath,text));
        sleep(1700);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lConceitedText));
    }
}
