package Pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Testng_lab3 {
	WebDriver driver;
    WebDriverWait wait;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println("This is the test");
	  driver.get("https://tutorialsninja.com/demo");
      Reporter.log("Opened URL in Chrome", true);
   // Navigate to Desktops > Mac
      driver.findElement(By.linkText("Desktops")).click();
      driver.findElement(By.linkText("Mac (1)")).click();
      Reporter.log("Navigated to Mac section", true);

      // Sort by Name (A-Z)
      Select sortDropdown = new Select(driver.findElement(By.id("input-sort")));
      sortDropdown.selectByVisibleText("Name (A - Z)");
      Reporter.log("Selected sort: Name (A-Z)", true);

      // Click Add to Cart
      WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick[contains(., 'cart.add')]]")));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
      addToCartBtn.click();
      Reporter.log("Clicked Add to Cart for Mac", true);

      // Verify success message
      WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
      String msgText = successMsg.getText();
      Reporter.log("Success message: " + msgText, true);
      Assert.assertTrue(msgText.contains("Success: You have added"), "Success message not found or incorrect");
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      driver.manage().window().maximize();
      
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
      Reporter.log("Closed browser", true);
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
    
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}


 
