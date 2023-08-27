package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends ParentPageWithHeader {

    private final String productName;

    @FindBy(xpath = "//*[@id=\"TPAMultiSection_ldv9szsf\"]/div/div/article/div[1]/section[2]/div[7]/div[1]/div/div[1]/div/div[2]")
    private WebElement selectSizeDropdown;

    @FindBy(xpath = "//*[starts-with(@id, 'dropdown-options-container_-1_option-')]")
    private List<WebElement> dropdownItems;

    @FindBy(xpath = "//*[@id=\"TPAMultiSection_ldv9szsf\"]/div/div/article/div[1]/section[2]/div[7]/div[2]/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"TPAMultiSection_ldv9szsf\"]/div/div/article/div[1]/section[2]/div[7]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]")
    private WebElement noSizeSelectedMessage;

    public ProductPage(WebDriver webDriver, String productName) {

        super(webDriver);

        this.productName = productName;

    }

    @Override
    protected String getRelativeUrl() {
        return "/product-page/" + productName.toLowerCase().replace(" ", "-");
    }

    @Override
    public ProductPage openPage() {
        openPage(baseUrl + getRelativeUrl());
        logger.info("Product page was opened");
        return this;
    }

    public ProductPage selectSize(int index) {

        while (dropdownItems.size() == 0)
            clickOnElement(selectSizeDropdown);

        if (index >= 0 && index < dropdownItems.size()) {

            clickOnElement(dropdownItems.get(index));

            logger.info("Size was selected");

            return this;

        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

    }

    public ProductPage selectFirstSize() {
        return selectSize(0);
    }

    public int getNumberOfSizes() {

        while (dropdownItems.size() == 0)
            clickOnElement(selectSizeDropdown);

        logger.info(String.format("Number of sizes is %d", dropdownItems.size()));

        int numberOfSizes = dropdownItems.size();

        clickOnElement(selectSizeDropdown);

        return numberOfSizes;

    }

    public ProductPage clickAddToCartButton() {

        clickOnElement(addToCartButton);

        logger.info("Add to cart button was clicked");

        return this;

    }

    public CartPage addProductToCart() {

        clickOnElement(addToCartButton);

        logger.info("Product was added to cart");

        return new CartPage(webDriver).openPage();

    }

    public void checkNoSizeSelectedMessageDisplayed() {

        checkElementDisplayed(noSizeSelectedMessage);

        logger.info("No size selected message is displayed");

        Assert.assertEquals(
                "No size selected message text is not as expected",
                "Оберіть Розмір",
                noSizeSelectedMessage.findElement(By.tagName("div")).getText()
        );

        logger.info("No size selected message text is as expected");

    }

}
