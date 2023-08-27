package org.example;

import org.example.pages.AllProductsPage;
import org.junit.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void checkAddToCart() {

        int productIndex = 1;

        AllProductsPage allProductsPage = pageProvider.getAllProductsPage().openPage();

        String productName = allProductsPage.getProductName(productIndex);

        allProductsPage.clickOnProduct(productIndex)
                .selectFirstSize()
                .addProductToCart()
                .checkNumberOfCartItems(1)
                .checkProductName(0, productName);

    }

}
