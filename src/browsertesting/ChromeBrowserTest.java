package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {

    public static void main(String[] args) {
        String baseUrl ="https://demo.nopcommerce.com/login?returnUrl=%2";
        // launch the Chrome Browser
        WebDriver driver = new ChromeDriver();
        // Open the URL into Browser
        driver.get(baseUrl);
        //Maximise the Browser
        driver.manage().window().maximize();
        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Get the Title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // Get the Current URL
        System.out.println("Current URL :" + driver.getCurrentUrl());

        // Get Page Source
        System.out.println("Page Source :" + driver.getPageSource());

        // Find the Login link element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        // Click on login link element
        loginLink.click();

        // Find the Email Field Element
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime123@gmail.com ");

        // Find the Password Field Element and type the password
        driver.findElement(By.name("Password")).sendKeys("Prime123");

        // Close the Browser
        driver.close();


    }
}
