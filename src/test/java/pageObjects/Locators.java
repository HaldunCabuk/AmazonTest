package pageObjects;

import org.openqa.selenium.By;

public interface Locators {
    By lAcceptCookies = By.id("sp-cc-accept");
    By lDdMenuProds = By.cssSelector(".s-suggestion-container div");
    By lSearch = By.cssSelector("#nav-search-submit-button");
    By lInfos = By.xpath("//h2[contains(@class,'a-color-base')]");
    By lRezensionen = By.xpath("//a[@class='a-popover-trigger a-declarative']");
    By lPhotos = By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']");
    By lAmzLogo = By.xpath("//a[@*='Amazon.de']");
    By lPs5s = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By lPs5Fotos = By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']");



    By lAlleHamburger = By.cssSelector(".hm-icon.nav-sprite");
    By lPrimeVideoButton = By.xpath("(//li//div[text()='Prime Video'])[1]");
    By lAlleVidButton = By.xpath("//a[text()='Alle Videos']");


    // MyTest2 locators begin from here

    String lAllTexts ="//*/span[contains(text(),'%s')]";
    String lDdButtonsName = "//div[@class='nav-search-facade']/span[text()='%s']";
    By lSelectOptions = By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']/option");
    By lSortingOptions = By.xpath("//span[@class='a-dropdown-container']/select");
    By lProducts = By.xpath("//div[@class='a-row a-spacing-mini a-size-base a-color-base']"); //CheckHowManyProductsBeforeTestAsManuall
    By lRezensionens = By.cssSelector(".a-icon.a-icon-star-small.a-star-small-4-5.aok-align-bottom");
    By lPrices = By.xpath("//span[@class=\"a-price-whole\"]");
    By lLieferungInfos = By.xpath("//div[@class='a-row s-align-children-center']");
    By lSearchButton = By.id("nav-search-submit-button");
    By lSortingPrices = By.xpath("//span[@class='a-price']/span[@class='a-offscreen']");




}
