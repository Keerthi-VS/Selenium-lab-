package Pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lab5full {
    public static void main(String[] args) throws InterruptedException {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\vskee\\eclipse-workspace\\seleniumsetup\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // ---------- Part 1: Launch Application ----------
            driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
            driver.manage().window().maximize();

            // Verify Title
            String actualTitle = driver.getTitle();
            System.out.println("Title: " + actualTitle);

            // Click My Account -> Register using linkText
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();

            // Verify Heading
            String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
            System.out.println("Heading: " + heading);

            // Click Continue without filling → Warning
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']"))).click();
            String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger"))).getText();
            System.out.println("Warning: " + warning);

            // ---------- Part 2: Personal Details ----------
            wait.until(ExpectedConditions.elementToBeClickable(By.id("input-firstname"))).sendKeys("Keerthana");
            driver.findElement(By.id("input-lastname")).sendKeys("VS");
            driver.findElement(By.id("input-email")).sendKeys("keerthana" + System.currentTimeMillis() + "@mail.com");
            driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

            // ---------- Part 4: Password ----------
            driver.findElement(By.id("input-password")).sendKeys("Test@123");
            driver.findElement(By.id("input-confirm")).sendKeys("Test@123");

            // ---------- Part 5: Newsletter & Policy ----------
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='newsletter' and @value='1']"))).click(); // Yes
            wait.until(ExpectedConditions.elementToBeClickable(By.name("agree"))).click(); // Privacy Policy
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']"))).click();

            // Verify Account Created
            String successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"))).getText();
            System.out.println("Success Message: " + successMsg);

            // Continue after success
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue"))).click();

            // Go to Order History
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View your order history"))).click();
            System.out.println("Navigated to Order History page!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
          
        }
    }
}
