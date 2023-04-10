package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Firebox";
    static WebDriver driver;
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2";

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firebox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else{
            System.out.println("Wrong Browser Name");
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //Get the tittle of the Page
        System.out.println(driver.getTitle());

        // We give  implicit wait to  driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

       // Get the Current URL
        System.out.println("Current URL: "+ driver.getCurrentUrl());
        // Get Page Source
        System.out.println("Page Source : " + driver.getPageSource());
        //Find the Email Field element
        WebElement emailField = driver.findElement(By.name("Email"));
        // Type the Email Address to email field element
        emailField.sendKeys("prime123@gmail.com");

        /// Find the password Field Element and type the password
        driver.findElement(By.name("Password")).sendKeys("Prime123");

        // close driver
        driver.close();

    }
}
