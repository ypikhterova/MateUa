package org.example.pages;

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

    public CartPage addProductToCart() {

        clickOnElement(addToCartButton);

        logger.info("Product was added to cart");

        return new CartPage(webDriver).openPage();

    }

}
