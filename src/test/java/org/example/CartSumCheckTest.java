package org.example;

import org.junit.Test;

public class CartSumCheckTest extends BaseTest {

    @Test
    public void checkCartSum() {

        int productIndex = 1;

        pageProvider.getAllProductsPage().openPage()
                .clickOnProduct(productIndex)
                .selectFirstSize()
                .addProductToCart()
                .checkTotalSumDifference(0);

    }

}
