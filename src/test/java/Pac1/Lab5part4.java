package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab5part4 {
    public static void main(String[] args) {
        // Set path to your chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vskee\\eclipse-workspace\\seleniumsetup\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the registration page
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        try {
            // -------- Part 4: PASSWORD --------
            // Enter Password (between 4 and 20 characters)
            WebElement passwordField = driver.findElement(By.id("input-password"));
            passwordField.sendKeys("Test@123");  // Example: 8 characters

            // Enter Confirm Password
            WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
            confirmPasswordField.sendKeys("Test@123");  // Must match the above

            System.out.println("✅ Password and Confirm Password entered successfully.");

            // Pause for a while just to see result before quitting
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}

