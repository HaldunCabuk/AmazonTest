package pageObjects;

import org.openqa.selenium.By;

public interface Locators {
    By lDdMenuProds = By.cssSelector(".s-suggestion-container div");
    By lSearch = By.cssSelector("#nav-search-submit-button");
    By lInfos = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']");
    By lRezensionen = By.xpath("//a[@class='a-popover-trigger a-declarative']");
    By lFotos = By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']");
    By lAmzLogo = By.xpath("//a[@*='Amazon.de']");
    By lPs5s = By.xpath("//div[@class='a-section']/div");
    By lPs5Fotos = By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']");
}
