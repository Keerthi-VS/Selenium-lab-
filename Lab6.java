package Pac1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Lab6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("https://tutorialsninja.com/demo");

            // Components > Monitors
            driver.findElement(By.linkText("Components")).click();
            driver.findElement(By.linkText("Monitors (2)")).click();

            // Select 25 from 'Show' dropdown
            Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
            showDropdown.selectByVisibleText("25");

            // Add to cart for first item (Monitor)
            WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='product-thumb'])[1]"));
            WebElement addToCartBtn = firstProduct.findElement(By.xpath(".//button[@onclick[contains(., 'cart.add')]]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
            addToCartBtn.click();

            // ✅ Verify success message for monitor
            try {
                WebElement monitorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
                String monitorText = monitorMsg.getText();
                if (monitorText.contains("Success: You have added Apple Cinema 30")) {
                    System.out.println("✅ Monitor message is appearing.");
                } else {
                    System.out.println("⚠️ Monitor message appeared but content mismatch.");
                }
            } catch (Exception e) {
                System.out.println("❌ Monitor message is not appearing: " + e.getMessage());
            }

            // Click on 'Apple Cinema 30"' to open product page
            driver.findElement(By.linkText("Apple Cinema 30\"")).click();

            // Click on 'Specification' tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Specification']"))).click();

            // Verify specification details
            WebElement specTable = driver.findElement(By.id("tab-specification"));
            if (specTable.isDisplayed()) {
                System.out.println("✅ Specification details are present.");
            }

            // Add to Wish List
            WebElement wishBtn = driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishBtn);
            wishBtn.click();

            // Verify wish list success message
            try {
                WebElement wishMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
                if (wishMsg.getText().contains("Success: You have added Apple Cinema 30")) {
                    System.out.println("✅ Wish list message verified.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Wish list message not found: " + e.getMessage());
            }

            // Search for 'Mobile'
            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.clear();
            searchBox.sendKeys("Mobile");
            driver.findElement(By.cssSelector("button.btn-default")).click();

            // Enable 'Search in product descriptions'
            WebElement descCheckbox = driver.findElement(By.name("description"));
            if (!descCheckbox.isSelected()) {
                descCheckbox.click();
            }
            driver.findElement(By.id("button-search")).click();

            // Click on 'HTC Touch HD'
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("HTC Touch HD"))).click();

            // Set quantity to 3
            WebElement qtyBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-quantity")));
            qtyBox.clear();
            qtyBox.sendKeys("3");

            // Add to Cart
            WebElement cartBtn = driver.findElement(By.id("button-cart"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartBtn);
            cartBtn.click();

            // ✅ Verify success message for mobile
            try {
                WebElement mobileMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
                String mobileText = mobileMsg.getText();
                if (mobileText.contains("Success: You have added HTC Touch HD")) {
                    System.out.println("✅ Mobile message is appearing.");
                } else {
                    System.out.println("⚠️ Mobile message appeared but content mismatch.");
                }
            } catch (Exception e) {
                System.out.println("❌ Mobile message is not appearing: " + e.getMessage());
            }

            // View cart
            driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

            // Verify HTC Touch HD is in cart
            WebElement cartItem = driver.findElement(By.xpath("//table//a[text()='HTC Touch HD']"));
            if (cartItem.isDisplayed()) {
                System.out.println("✅ HTC Touch HD is present in cart.");
            }

            // Checkout
            driver.findElement(By.linkText("Checkout")).click();

            // My Account > Logout
            WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));
            accountDropdown.click();

            // Scroll fix before clicking Logout
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
            js.executeScript("window.scrollBy(0, 1500)");

            WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
            logoutLink.click();

            // Verify logout heading
            WebElement logoutHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            if (logoutHeading.getText().equals("Account Logout")) {
                System.out.println("✅ Logout verified.");
            }

            // Continue
            driver.findElement(By.linkText("Continue")).click();

        } catch (Exception e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
