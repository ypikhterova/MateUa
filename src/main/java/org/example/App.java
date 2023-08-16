package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.libs.ConfigProvider;
import org.example.pages.elements.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        WebDriver webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
        System.out.println("Browser was opened");

        webDriver.get(ConfigProvider.configProperties.BASE_URL());

        System.out.println("Opened site " + ConfigProvider.configProperties.BASE_URL());

        Header header = new Header(webDriver);

        header.clickOnCart();

        System.out.println("Clicked on cart");

    }

    private static WebDriver initDriver() {

        WebDriver webDriver;

        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) {//default browser -Dbrowser=chrome
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unknown browser " + browser);
        }
        return webDriver;
    }

}
