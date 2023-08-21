package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllProductsPage extends ParentPageWithHeader {

    @FindBy(xpath = "//*[@id=\"TPASection_ldv9swwx\"]/div/div/div/div[1]/aside/section/ul/li")
    private List<WebElement> filtersListItems;

    public AllProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/shop";
    }

    public boolean isFiltersListItemsVisible() {

        boolean allVisible = true;

        for (WebElement filter : filtersListItems) {
            if (!filter.isDisplayed()) {
                allVisible = false;
                break;
            }
        }

        return allVisible;

    }

    public List<WebElement> getFiltersListItems() {
        return filtersListItems;
    }

    public void checkIsFiltersListItemsVisible() {
        Assert.assertTrue("Not all filters are visible", isFiltersListItemsVisible());
    }

    public void checkNumberOfFilters(int expectedNumberOfFilters) {
        Assert.assertEquals("Number of filters is not as expected", expectedNumberOfFilters, filtersListItems.size());
    }

}
