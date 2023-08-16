package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.example.pages.elements.Header;

abstract public class ParentPageWithHeader extends ParentPage {

    private final Header header = new Header(webDriver);

    public ParentPageWithHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public Header getHeader() {
        return header;
    }

}
