package Pac1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5part2 {
    public static void main(String[] args) throws InterruptedException {
        // Set path for chromedriver (update the path as per your system)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vskee\\eclipse-workspace\\seleniumsetup\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            // 1. Launch URL
            driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
            driver.manage().window().maximize();

            // 2. Verify Title of the page
            String expectedTitle = "Register Account";
            String actualTitle = driver.getTitle();
            if (actualTitle.contains(expectedTitle)) {
                System.out.println("✅ Title verified: " + actualTitle);
            } else {
                System.out.println("❌ Title mismatch. Found: " + actualTitle);
            }

            // 3. Enter First Name
            WebElement firstName = driver.findElement(By.name("firstname")); // locator fixed
            firstName.sendKeys("KeerthanaAutomationTesting123456789012345"); // 33 chars

            // 4. Enter Last Name
            WebElement lastName = driver.findElement(By.name("lastname"));
            lastName.sendKeys("LastnameAutomationTesting123456789012345");

            // 5. Enter valid Email
            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys("keerthana.test" + System.currentTimeMillis() + "@gmail.com");

            // 6. Enter Telephone (within 3 to 32 characters)
            WebElement telephone = driver.findElement(By.name("telephone"));
            telephone.sendKeys("9876543210");

            // 7. Click Continue without filling password (to trigger validation)
            WebElement continueBtn = driver.findElement(By.cssSelector("input.btn.btn-primary"));
            continueBtn.click();

            Thread.sleep(2000);

            // 8. Verify warning message (if shown)
            WebElement warning = driver.findElement(By.cssSelector(".alert-danger"));
            if (warning.isDisplayed()) {
                System.out.println("⚠️ Warning Displayed: " + warning.getText());
            } else {
                System.out.println("❌ Warning not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            
        }
    }
}
