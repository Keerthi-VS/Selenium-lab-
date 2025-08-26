package Pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

public class Testng_lab4 {
	 WebDriver driver;
	    WebDriverWait wait;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) throws InterruptedException {
	  System.out.println("This is the test");
	  driver.get("https://tutorialsninja.com/demo");
	  Reporter.log("Opened URL in Chrome", true);
	  // Step 1: Verify title
      String expectedTitle = "Your Store";
      Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title mismatch");
      Reporter.log("Verified page title: " + expectedTitle, true);

      // Step 2: Navigate to Desktops > Mac
      driver.findElement(By.linkText("Desktops")).click();
      driver.findElement(By.linkText("Mac (1)")).click();
      Reporter.log("Navigated to Mac section", true);

      // Step 3: Verify Mac heading
      WebElement macHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mac']")));
      Assert.assertTrue(macHeading.isDisplayed(), "Mac heading not visible");
      Reporter.log("Verified Mac heading", true);

      // Step 4: Sort by Name (A-Z)
      Select sortDropdown = new Select(driver.findElement(By.id("input-sort")));
      sortDropdown.selectByVisibleText("Name (A - Z)");
      Reporter.log("Selected sort: Name (A-Z)", true);
   // Step 5: Add to Cart
      WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick[contains(., 'cart.add')]]")));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
      addToCartBtn.click();
      Reporter.log("Clicked Add to Cart for Mac", true);

      // Step 6: Search for 'Monitors'
      WebElement searchBox = driver.findElement(By.name("search"));
      searchBox.clear();
      searchBox.sendKeys("Monitors");

      WebElement searchBtn = driver.findElement(By.cssSelector("button.btn-default"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBtn);
      Thread.sleep(500); // Let overlays settle
      try {
          searchBtn.click();
      } catch (ElementClickInterceptedException e) {
          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
      }
      Reporter.log("Searched for 'Monitors'", true);

      // Step 7: Wait for page to load
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

      // Step 8: Clear 'Search Criteria' and enable description search
      WebElement searchCriteria = driver.findElement(By.id("input-search"));
      searchCriteria.clear();

      WebElement descriptionCheckbox = driver.findElement(By.name("description"));
      if (!descriptionCheckbox.isSelected()) {
          descriptionCheckbox.click();
      }
      WebElement advancedSearchBtn = driver.findElement(By.id("button-search"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", advancedSearchBtn);
      advancedSearchBtn.click();
      Reporter.log("Performed advanced search with description enabled", true);

      // Step 9: Verify search results loaded
      WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
      Assert.assertTrue(results.isDisplayed(), "Search results not loaded");
      Reporter.log("Verified search results", true);
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
