package Pac1;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab9_2 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
		driver.get("https://tutorialsninja.com/demo/index.php?");
		System.out.println("Title is:"+driver.getTitle());
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		WebElement sort = driver.findElement(By.id("input-sort"));
		sort.sendKeys("Name(A-Z)");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
		WebElement search = driver.findElement(By.name("search"));
		search.sendKeys("Mobile");
		search.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.id("input-search")).clear();
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]/label")).click();
		driver.findElement(By.id("button-search")).click();
		
		WebElement verifyMacHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
		if(verifyMacHeading.isDisplayed()) {
			System.out.println("Mac heading is successfully verified");
			
		}
		else {
			System.out.println("Mac heading is not verified");
		}
		
		WebElement searchbox = driver.findElement(By.name("search"));
		searchbox.clear();
		searchbox.sendKeys("Monitor");
		
	
  }
  @Parameters("browser")
  
  @BeforeMethod
  public void beforeMethod(String browser) {
	  System.out.println("This is Before Method");
	  if(browser.equalsIgnoreCase("chrome"))
	  {
	   WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	  }
	  if (browser.equalsIgnoreCase("edge")) {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	  }
	 
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite");
  }

}