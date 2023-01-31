package com.Testng;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fb_Testng {

	
	public class Amazon_testng   {
		WebDriver driver = null;
		String url;
		String title1;

		private ChromeOptions desiredOption() {

			ChromeOptions option = new ChromeOptions();

			option.addArguments("start-maximized");

			return option;

		}

		@BeforeTest

		private void browserLaunch() {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(desiredOption());

		}

		@BeforeClass

		private void launchUrl() {

			driver.get("https://www.facebook.com/");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		@Test (priority= 0)
		public void checkurl() throws Exception {

			url = "https://www.facebook.com";

			String title = driver.getTitle();

			title1 = "facebook";
			System.out.println(title);

			if (url.contains(title1)) {
				System.out.println("Correcturl");
			} else {
				System.out.println("not correct url");
			}

		}

		@Test 
		private void username() {
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("janu123@gmail");// TODO Auto-generated method stub

		}
		

		@Test (dependsOnMethods = "username")

		private void password() {

			WebElement pass = driver.findElement(By.id("pass"));
			pass.sendKeys("123458");

		}

		@Test 
		private void click() throws IOException, InterruptedException {
			WebElement log = driver.findElement(By.name("login"));
			log.click();
			TakesScreenshot v = (TakesScreenshot) driver;
			File v1 = v.getScreenshotAs(OutputType.FILE);
			File f1 = new File("C:\\Users\\Vijay\\eclipse-workspace\\Facebook.Mini\\screenshot\\fbloginerror.png");
			FileUtils.copyFile(v1, f1);
			Thread.sleep(3000);
			
		}
		
		@Test //timeOut =5000, expectedExceptions = ThreadTimeoutException.class)
		private void navigateurl() throws InterruptedException {
		
			
			driver.navigate().to(url);
			//Thread.sleep(3000);

			WebElement newacct = driver.findElement(By.xpath("//a[text()='Create New Account']"));
			newacct.click();

		}

		@Test (priority= 5)

		private void formfilling() {
			WebElement firstname = driver.findElement(By.name("firstname"));
			firstname.sendKeys("janu");
			WebElement lastname = driver.findElement(By.name("lastname"));
			lastname.sendKeys("k");

			WebElement regemail = driver.findElement(By.name("reg_email__"));
			regemail.sendKeys("vijay1432@gmail.com");

			WebElement newpass = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
			newpass.sendKeys("59745545");
			WebElement day = driver.findElement(By.name("birthday_day"));
			Select s = new Select(day);
			boolean multiple = s.isMultiple();
			System.out.println(multiple);
			s.selectByIndex(4);
			WebElement month = driver.findElement(By.id("month"));
			Select s1 = new Select(month);
			s1.selectByValue("3");
			WebElement year = driver.findElement(By.name("birthday_year"));
			Select s2 = new Select(year);
			s2.selectByVisibleText("1997");

			WebElement gender = driver.findElement(By.name("sex"));
			gender.click();

		}
	@Test (priority= 6)
		private void signupclick() throws IOException {
			WebElement signup = driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));
		    signup.click();
		    
		    TakesScreenshot t = (TakesScreenshot) driver;                                     
			File v2 = t.getScreenshotAs(OutputType.FILE);
			File f2 = new File("C:\\Users\\Vijay\\eclipse-workspace\\Facebook.Mini\\screenshot\\fbsignup.png");
		    FileUtils.copyFile(v2, f2);
		}
		@Test (priority= 7)
		private void title() throws InterruptedException {
			  driver.findElement(By.xpath("//img[@class='_8idr img']")).click();  
			  String title2 = driver.getTitle();
			  System.out.println("current page title" + title2);
			    if (title1.equals(title2)) {
					System.out.println("currentpage and initial user launched is same");
				}
			    else {
					driver.close();
				}
			    Thread.sleep(1000);

		}
		@AfterTest @Ignore
		private void closewebpage() {
		    driver.quit();

		}

	}

}


