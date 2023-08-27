package org.example;

import org.junit.Test;

public class SizeValidationTest extends BaseTest {

    @Test
    public void checkSizeValidation() {

        int productIndex = 5;

        pageProvider.getAllProductsPage().openPage()
                .findFirstProductWithMultipleSizes(productIndex)
                .clickAddToCartButton()
                .checkNoSizeSelectedMessageDisplayed();

    }

}
