package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllProductsPage extends ParentPageWithHeader {

    @FindBy(xpath = "//*[@id=\"TPASection_ldv9swwx\"]/div/div/div/div[1]/aside/section/ul/li")
    private List<WebElement> filtersListItems;

    @FindBy(xpath = "//*[@id=\"TPASection_ldv9swwx\"]/div/div/div/div[2]/section/div/ul[1]/li")
    private List<WebElement> allProductsListItems;

    public AllProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/shop";
    }

    @Override
    public AllProductsPage openPage() {
        openPage(baseUrl + getRelativeUrl());
        checkUrl();
        logger.info("All products page was opened");
        return this;
    }

    private boolean isFiltersListItemsVisible() {

        boolean allVisible = true;

        for (WebElement filter : filtersListItems) {
            if (!filter.isDisplayed()) {
                allVisible = false;
                break;
            }
        }

        return allVisible;

    }

    public AllProductsPage checkIsFiltersListItemsVisible() {
        Assert.assertTrue("Not all filters are visible", isFiltersListItemsVisible());
        logger.info("All filters are visible");
        return this;
    }

    public AllProductsPage checkNumberOfFilters(int expectedNumberOfFilters) {
        Assert.assertEquals("Number of filters is not as expected", expectedNumberOfFilters, filtersListItems.size());
        logger.info(String.format("Number of filters is %d", expectedNumberOfFilters));
        return this;
    }

    public ProductPage clickOnProduct(int productNumber) {

        String productName = getProductName(productNumber);

        logger.info(String.format("Product '%s' was opened", productName));

        clickOnElement(allProductsListItems.get(productNumber));

        return new ProductPage(webDriver, productName).openPage();

    }

    public String getProductName(int index) {

        if (index >= 0 && index < allProductsListItems.size()) {
            WebElement listItem = allProductsListItems.get(index);
            WebElement h3Element = listItem.findElement(By.tagName("h3"));
            return h3Element.getText();
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

    }

}
