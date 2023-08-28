package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends ParentPageWithHeader {

    @FindBy(xpath = "//*[@id=\"TPAMultiSection_ldv9t2f9\"]/div/div/div/main/main/section/div[2]/ul/li")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//*[@id=\"total-sum\"]")
    private WebElement totalSum;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/cart-page";
    }

    @Override
    public CartPage openPage() {
        openPage(baseUrl + getRelativeUrl());
        checkUrl();
        logger.info("Cart page was opened");
        return this;
    }

    public CartPage checkNumberOfCartItems(int expectedNumberOfCartItems) {
        Assert.assertEquals("Number of cart items is not as expected", expectedNumberOfCartItems, cartItems.size());
        logger.info(String.format("Number of cart items is %d", expectedNumberOfCartItems));
        return this;
    }

    public CartPage checkProductName(int index, String expectedProductName) {

        String actualProductName = getProductName(index);

        Assert.assertEquals("Product name is not as expected", expectedProductName, actualProductName);

        logger.info(String.format("Product name is %s", expectedProductName));

        return this;

    }

    public double getProductPrice(int index) {

        String actualProductPrice = cartItems.get(index)
                .findElement(By.className("BjY0SH"))
                .findElement(By.tagName("span")).getText();

        return Double.parseDouble(actualProductPrice.substring(0, actualProductPrice.length() - 1).replace(" ", "").replace(",", "."));

    }

    public CartPage incrementNumberOfProducts(int index) {

        ProductPage productPage = new ProductPage(webDriver, getProductName(index));

        clickOnElement(cartItems.get(index).findElements(By.tagName("img")).get(0));

        productPage.selectFirstSize();

        productPage.addProductToCart();

        logger.info("Product was added to cart");

        return this;

    }

    public CartPage deleteProduct(int index) {

        while (true) {

            try {;

                clickOnElementThrowable(cartItems.get(index).findElement(By.xpath("//*[@id=\"TPAMultiSection_ldv9t2f9\"]/div/div/div/main/main/section/div[2]/ul/li[1]/div/div/div[2]/button")));

            } catch (StaleElementReferenceException e) {
                break;
            }

        }

        logger.info(String.format("Product #%d was deleted", index + 1));

        return openPage();

    }

    public double getTotalSum() {

        String actualTotalSum = totalSum.getText();

        return Double.parseDouble(actualTotalSum.substring(0, actualTotalSum.length() - 1).replace(" ", "").replace(",", "."));

    }

    public void checkTotalSumDifference(int index) {

        double initialTotalSum = getTotalSum();
        double ProductPrice = getProductPrice(index);

        double expectedTotalSum = initialTotalSum + ProductPrice;

        incrementNumberOfProducts(index);

        double actualTotalSum = getTotalSum();

        Assert.assertEquals("Total sum is not as expected", expectedTotalSum, actualTotalSum, 0.01);

        logger.info(String.format("Total sum is as expected: %f", expectedTotalSum));

    }

    public String getProductName(int index) {
        return cartItems.get(index).findElement(By.className("u3J7hK")).getText();
    }

}
