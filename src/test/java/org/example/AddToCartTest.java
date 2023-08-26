package org.example;

import org.example.pages.AllProductsPage;
import org.example.pages.CartPage;
import org.example.pages.ProductPage;
import org.junit.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void checkAddToCart() {

        int productIndex = 0;

        logger.info("Add to cart test");

        AllProductsPage allProductsPage = pageProvider.getAllProductsPage();

        allProductsPage.openPage();

        String productName = allProductsPage.getProductName(productIndex);

        allProductsPage.clickOnProduct(productIndex);

        logger.info(String.format("Product '%s' was opened", productName));

        ProductPage productPage = pageProvider.getProductPage(productName);

        logger.info("Product page was opened");

        productPage.selectSize(0);

        logger.info("Size was selected");

        productPage.clickOnAddToCartButton();

        logger.info("Add to cart button was clicked");

        CartPage cartPage = pageProvider.getCartPage();

        cartPage.openPage();

        logger.info("Cart opened");

        cartPage.checkNumberOfCartItems(1);

        logger.info("Number of cart items is 1");

        cartPage.checkProductName(productIndex, productName);

    }

}
