package Pac1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class grouptesting {
	@Test(groups= {"smoke"}, priority=4,enabled=false)
	  public void test1() {
		  System.out.println("This is smoketest1");
	  }
	  @Test(groups= {"regression"},priority=3)
	  public void test2() {
		  System.out.println("This is regressiontest1");
	  }
	  @Test(groups= {"regression"},priority=2)
	  public void test3() {
		  System.out.println("This is  regressiontest2");
	  }
	  @Test(groups= {"smoke"},priority=1)
	  public void test4() {
		  System.out.println("This is smoketest2");
	  }
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
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
