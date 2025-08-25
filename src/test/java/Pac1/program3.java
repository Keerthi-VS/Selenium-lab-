package Pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class program3 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("title is:"+driver.getTitle());
		System.out.println("url is:"+driver.getCurrentUrl());
		System.out.println("page source is:"+driver.getPageSource());
	}
 
}	

