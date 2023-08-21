package org.example;

import org.example.pages.AllProductsPage;
import org.junit.Test;


public class AllProductsPageTest extends BaseTest {

    @Test
    public void checkNumberOfFilters() {

        AllProductsPage allProductsPage = pageProvider.getAllProductsPage();

        allProductsPage.openPage();

        logger.info("All products page was opened");

        allProductsPage.checkIsFiltersListItemsVisible();

        logger.info("All filters are visible");

        int expectedNumberOfFilters = 4;

        allProductsPage.checkNumberOfFilters(expectedNumberOfFilters);

        logger.info(String.format("Number of filters is %d", expectedNumberOfFilters));

    }

}
