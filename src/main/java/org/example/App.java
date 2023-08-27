package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.PageProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class App
{

    public static void main( String[] args ) {

        int productIndex = 5;

        new PageProvider(initDriver()).getAllProductsPage().openPage()
                .findFirstProductWithMultipleSizes(productIndex)
                .clickAddToCartButton()
                .checkNoSizeSelectedMessageDisplayed();

    }

    private static WebDriver initDriver() {

        WebDriver webDriver;

        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) {//default browser -Dbrowser=chrome
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {//-Dbrowser=firefox
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("ie".equals(browser.toLowerCase())) {
            WebDriverManager.iedriver().setup();
            webDriver = new InternetExplorerDriver();//security level - medium, zoom - 100%
        } else if ("safari".equals(browser.toLowerCase())) {
            WebDriverManager.safaridriver().setup();
            webDriver = new SafariDriver();
        } else if ("edge".equals(browser.toLowerCase())){
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        else {
            throw new IllegalArgumentException("Unknown browser " + browser);
        }
        return webDriver;
    }



}
