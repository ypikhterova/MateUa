package org.example;

import org.example.pages.AllProductsPage;
import org.example.pages.CartPage;
import org.junit.Test;

public class DeleteProductTest extends BaseTest {

    @Test
    public void checkDeleteProduct() {

        int firstProductIndex = 1;
        int secondProductIndex = 2;

        AllProductsPage allProductsPage = pageProvider.getAllProductsPage();

        allProductsPage.openPage()
                .clickOnProduct(firstProductIndex)
                .selectFirstSize()
                .addProductToCart();

        CartPage cartPage = allProductsPage.openPage()
                .clickOnProduct(secondProductIndex)
                .selectFirstSize()
                .addProductToCart();

        cartPage.deleteProduct(0).checkNumberOfCartItems(1);

    }

}
