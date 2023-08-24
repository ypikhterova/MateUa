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

    public void clickOnProduct(int productNumber) {
        clickOnElement(allProductsListItems.get(productNumber));
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
