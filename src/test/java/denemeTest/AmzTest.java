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


    public AmzTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        locators = PageFactory.initElements(driver, Locators.class);
    }


    @Test
    public void aaa() {
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("Amazon")); // assert title
        sendKey(getInputByLocator("Suche Amazon.de"), "wireless");
       /* checkDropProducts("wireless");
        System.out.println(arr);*/
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".s-suggestion-container div"),0));
        //Assert.assertTrue(locators.products.size()>0);

        long num = driver.findElements(lLocator).stream().filter(e -> !e.getText().toLowerCase().contains("wireless")).count();
        Assert.assertEquals(num,0);

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

    public void checkDropProducts() {
        for (WebElement product : locators.products) {
            System.out.println(product.getText());
        }
    }

    public void checkDropProducts(String pName) {


        for (WebElement element : locators.products) {
            if (element.getText().contains(pName)) {
                arr.add(element.getText());
                System.out.println(element.getText());
            }

        }


    }


}


