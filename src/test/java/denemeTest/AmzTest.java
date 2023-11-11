package denemeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static denemeTest.Locators.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AmzTest {

    WebDriver driver;
    WebDriverWait wait;

    String url = "https://www.amazon.de/";
    WebElement element;
    Locators locators;
    ArrayList<String> arr = new ArrayList<>();

    By lLocator = By.cssSelector(".s-suggestion-container div");
    By lSearch = By.cssSelector("#nav-search-submit-button");
    By lInfos = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']");
    By lRezensionen = By.xpath("//a[@class='a-popover-trigger a-declarative']");


    public AmzTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        locators = PageFactory.initElements(driver, Locators.class);
    }


    @Test
    public void aaa() throws InterruptedException {
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("Amazon")); // assert title
        sendKey(getInputByLocator("Suche Amazon.de"), "wireless");
        checkDropProducts("wireless");
        click(lSearch);
        checkTheInfos("Wireless", "Kabellos");

        /* checkDropProducts("wireless");
        System.out.println(arr);*/
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".s-suggestion-container div"),0));
        //Assert.assertTrue(locators.products.size()>0);


    }

    public void sleep(int num) throws InterruptedException {
        try {

            Thread.sleep(num);

        }catch (InterruptedException e){

        }
    }

    @AfterTest()
    public void afterTest() {
        driver.quit();
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

   /* public void checkDropProducts() {
        for (WebElement product : locators.products) {
            System.out.println(product.getText());
        }
    }*/

    public void checkDropProducts(String pName) {

        long num = driver.findElements(lLocator).stream().filter(e -> !e.getText().toLowerCase().startsWith(pName)).count();
        Assert.assertEquals(num, 0);
    }

    public void checkTheInfos(String text1, String text2) {

        String texts = ""+ text1 + " | " + text2;

       long num = driver.findElements(lInfos).stream().filter(e -> !e.getText().toLowerCase().contains(texts)).count();
        System.out.println(num);
    }
    public void checkRezensionWithProduct(){

        int rezNums=0;

        List<WebElement> rezensionen = driver.findElements(lRezensionen);

        for (WebElement rezension : rezensionen) {

            if (rezension.getText().toLowerCase().contains("sternen")) {
                rezNums++;
            } else {

            }
        }

    }

}


