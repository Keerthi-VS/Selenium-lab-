package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HEllo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		 // Verify the heading "Register Account"
        WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        if (heading.isDisplayed()) {
            System.out.println("Heading Verified: " + heading.getText());
        } else {
            System.out.println("Heading NOT found!");
        }

        // Click on 'Continue' button at the bottom of the page
        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueBtn.click();

        // Verify the warning message
        WebElement warning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
        String warningMsg = warning.getText();
        if (warningMsg.contains("Warning: You must agree to the Privacy Policy!")) {
            System.out.println("Warning Verified: " + warningMsg);
        } else {
            System.out.println("Warning message mismatch!");
        }

    }
}		

	
