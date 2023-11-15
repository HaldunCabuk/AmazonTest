package pageObjects;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='nav-xshop-container']//a[text()='Bestseller ']")
    public WebElement topMenuBestsellerLink;

    @FindBy(xpath = "//form[@id='nav-search-bar-form']//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

}
