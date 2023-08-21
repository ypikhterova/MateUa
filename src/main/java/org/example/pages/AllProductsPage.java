package org.example.pages;

import org.openqa.selenium.WebDriver;

public class AllProductsPage extends ParentPageWithHeader {

    public AllProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/shop";
    }

}
