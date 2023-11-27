package denemeTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Locators {

    @FindBy(css = ".s-suggestion-container div")
    public List<WebElement> products;
    @FindBy(xpath = "(//li/a[text()='Alle Videos'])[1]")
    public WebElement AllevideosButton;


}
