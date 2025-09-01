package com.orangehrm.Base;
 
import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.orangehrm.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseTest {
 
		protected WebDriver driver;
		protected ExtentReports extent;
		@BeforeSuite
		public void setupreport()
		{
			extent=ExtentManager.getinstance();
			
		}
	
	  @BeforeMethod
	  public void setup() {
		
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	  }
	  
	  @AfterMethod
	  public void teardown() {
		  driver.quit();
	  }
 
	  @AfterSuite
		public void flushreport()
		{
		  extent.flush();
			
		}
	
}
