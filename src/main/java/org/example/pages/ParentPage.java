package org.example.pages;

import org.example.libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class ParentPage extends ActionsWithElements {

    String baseUrl;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = ConfigProvider.configProperties.BASE_URL();
    }

    protected void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page " + url + " was opened");
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

    public abstract void openPage();

    protected abstract String getRelativeUrl();

}
