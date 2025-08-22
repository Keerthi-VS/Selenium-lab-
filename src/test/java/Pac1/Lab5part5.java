package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab5part5 {
    public static void main(String[] args) {
        // Set path for ChromeDriver (update path as per your system)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vskee\\eclipse-workspace\\seleniumsetup\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open the registration page
            driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
            driver.manage().window().maximize();

            // ✅ Fill minimum required details (Firstname, Lastname, Email, Telephone, Password)
            driver.findElement(By.id("input-firstname")).sendKeys("Keerthana");
            driver.findElement(By.id("input-lastname")).sendKeys("VS");
            driver.findElement(By.id("input-email")).sendKeys("keerthana" + System.currentTimeMillis() + "@mail.com");
            driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
            driver.findElement(By.id("input-password")).sendKeys("test1234");
            driver.findElement(By.id("input-confirm")).sendKeys("test1234");

            // ✅ Click on 'Yes' for Newsletter
            WebElement yesRadio = driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
            yesRadio.click();

            // ✅ Click on checkbox for Privacy Policy
            WebElement privacyPolicyCheckbox = driver.findElement(By.name("agree"));
            privacyPolicyCheckbox.click();

            // ✅ Click Continue button
            WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
            continueBtn.click();

            // ✅ Verify account creation message
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")));
            if (successMsg.getText().equals("Your Account Has Been Created!")) {
                System.out.println("✅ Account Created Successfully!");
            } else {
                System.out.println("❌ Account creation failed!");
            }

            // ✅ Click Continue after success
            WebElement continueAfterSuccess = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
            continueAfterSuccess.click();

            // ✅ Click "View your order history" under "My Orders"
            WebElement orderHistory = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View your order history")));
            orderHistory.click();

            System.out.println("✅ Navigated to Order History page!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}

