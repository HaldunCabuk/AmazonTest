package pageObjects;

import org.openqa.selenium.By;

public interface Locators {
    By lDdMenuProds = By.cssSelector(".s-suggestion-container div");
    By lSearch = By.cssSelector("#nav-search-submit-button");
    By lInfos = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']");
    By lRezensionen = By.xpath("//a[@class='a-popover-trigger a-declarative']");
    By lPhotos = By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']");
    By lAmzLogo = By.xpath("//a[@*='Amazon.de']");
    By lPs5s = By.xpath("//div[@class='a-section']/div");
    By lPs5Fotos = By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']");

    // MyTest2 locators begin here

    String lAllTexts ="//*/span[contains(text(),'%s')]";
    String lDdButtonsName = "//div[@class='nav-search-facade']/span[text()='%s']";
    By lSelectOptions = By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']/option");
    By lProducts = By.xpath("//div[@data-asin]/div[@class='sg-col-inner']/div[@cel_widget_id]"); //CheckHowManyProductsBeforeTestAsManuall

    By lDdOptions = By.id("searchDropdownBox");
    By lRezensionens = By.cssSelector(".a-icon.a-icon-star-small.a-star-small-4-5.aok-align-bottom");
    By lPrices = By.xpath("//div[@class='a-row']//span[@class='a-price']");
    By lLieferungInfos = By.xpath("//div[@class='a-row s-align-children-center']");



}
