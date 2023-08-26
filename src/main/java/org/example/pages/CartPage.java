package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends ParentPageWithHeader {

    @FindBy(xpath = "//*[@id=\"TPAMultiSection_ldv9t2f9\"]/div/div/div/main/main/section/div[2]/ul/li")
    private List<WebElement> cartItems;

    private final String productNameXpath = "";

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/cart-page";
    }

    @Override
    public CartPage openPage() {
        openPage(baseUrl + getRelativeUrl());
        checkUrl();
        logger.info("Cart page was opened");
        return this;
    }

    public CartPage checkNumberOfCartItems(int expectedNumberOfCartItems) {
        Assert.assertEquals("Number of cart items is not as expected", expectedNumberOfCartItems, cartItems.size());
        logger.info(String.format("Number of cart items is %d", expectedNumberOfCartItems));
        return this;
    }

    public CartPage checkProductName(int index, String expectedProductName) {

        String actualProductName = cartItems.get(index).findElement(By.className("u3J7hK")).getText();

        Assert.assertEquals("Product name is not as expected", expectedProductName, actualProductName);

        logger.info(String.format("Product name is %s", expectedProductName));

        return this;

    }

}
