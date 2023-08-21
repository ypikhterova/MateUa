package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.libs.ConfigProvider;
import org.example.pages.AllProductsPage;
import org.example.pages.PageProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App
{
    public static void main( String[] args ) {

        WebDriver webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
        System.out.println("Browser was opened");

        AllProductsPage allProductsPage = new PageProvider(webDriver).getAllProductsPage();

        allProductsPage.openPage();

        System.out.println("All products page was opened");

        // List<WebElement> filtersListItems = webDriver.findElements(By.xpath("//*[@id=\"TPASection_ldv9swwx\"]/div/div/div/div[1]/aside/section/ul/li"));

        System.out.println(String.format("Number og Filters is %d", allProductsPage.getFiltersListItems().size()));

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
