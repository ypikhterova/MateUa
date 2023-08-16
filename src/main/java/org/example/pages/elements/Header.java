package org.example.pages.elements;

import org.example.pages.ActionsWithElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends ActionsWithElements {

    @FindBy(xpath = "//.//div[@class='pniDPk']")
    private WebElement cart;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsCartVisible() {
        checkElementDisplayed(cart);
    }

    public boolean isCartVisible() {
        return isElementDisplayed(cart);
    }

    public void clickOnCart() {
        clickOnElement(cart);
    }

}
