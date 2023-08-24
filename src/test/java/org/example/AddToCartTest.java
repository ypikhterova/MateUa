package org.example;

import org.example.pages.AllProductsPage;
import org.junit.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void checkAddToCart() {

        logger.info("Add to cart test");

        AllProductsPage allProductsPage = pageProvider.getAllProductsPage();

        allProductsPage.openPage();

        logger.info("All products page was opened");

        allProductsPage.clickOnProduct(1);

        logger.info("First product was opened");

    }

}
