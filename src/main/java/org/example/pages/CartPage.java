package org.example.pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends ParentPageWithHeader {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/cart-page";
    }

}
