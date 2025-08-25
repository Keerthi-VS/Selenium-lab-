package Pac1;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class synchronization {
 
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		WebElement uname=driver.findElement(By.name("username"));

		if(uname.isDisplayed())

		{

			uname.sendKeys("Admin");

		System.out.println("Get placeholder:"+uname.getAttribute("placeholder"));

		}

		else

		{

			System.out.println("username is not displayed");

		}

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.name("username")).sendKeys(Keys.ENTER);



	}
 
}

 

