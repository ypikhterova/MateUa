package org.example.pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public AllProductsPage getAllProductsPage() {
        return new AllProductsPage(webDriver);
    }

    public ProductPage getProductPage(String productName) {
        return new ProductPage(webDriver, productName);
    }

    public CartPage getCartPage() {
        return new CartPage(webDriver);
    }

}
