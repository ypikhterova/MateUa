package org.example.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Override
    public HomePage openPage() {
        openPage(baseUrl + getRelativeUrl());
        checkUrl();
        logger.info("Home page was opened");
        return this;
    }

}
