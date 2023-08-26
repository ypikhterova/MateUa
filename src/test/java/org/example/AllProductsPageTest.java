package org.example;

import org.junit.Test;


public class AllProductsPageTest extends BaseTest {

    @Test
    public void checkNumberOfFilters() {

        int expectedNumberOfFilters = 4;

        pageProvider.getAllProductsPage()
                .openPage()
                .checkIsFiltersListItemsVisible()
                .checkNumberOfFilters(expectedNumberOfFilters);

    }

}
