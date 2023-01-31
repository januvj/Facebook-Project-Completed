package com.facebook.propertyfile;

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
import org.openqa.selenium.support.ui.Select;

import com.Resuablemethods.Facebook_Base;
import com.property.ConfigurationHelper;

public class Facebook_PropertyScript extends Facebook_Base {

	
	
	public static void main(String[] args) throws Exception {
		String browser1 = ConfigurationHelper.getInstanceCR().getbrowser();

			 browserlaunch(browser1);
		
				String url1 = ConfigurationHelper.getInstanceCR().getUrl();

			 String url= getUrl(url1);
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String title = driver.getTitle();
			
			String tit = ConfigurationHelper.getInstanceCR().getWebPageTitle();

			String title1 =tit;
	        System.out.println(title);
	        
	        if (url.contains(title1)) {
				System.out.println("Correcturl");
			}
	        else {
	      System.out.println("not correct url");		
		}
		
		WebElement email =driver.findElement(By.name("email"));
	    userInput(email, "janu123@gmail");

		WebElement pass =driver.findElement(By.id("pass"));
		userInput(pass, "123458");
		
		WebElement log = driver.findElement(By.name("login"));
		clickOnElement(log);
		capture();
//		TakesScreenshot v = (TakesScreenshot) driver;                                     
//		File v1 = v.getScreenshotAs(OutputType.FILE);
//		File f1 = new File("C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\fbvj.png");
//	    FileUtils.copyFile(v1, f1);	
	    driver.navigate().to(url);
	    sleep();
	    WebElement newacct = driver.findElement(By.xpath("//a[text()='Create new account']"));
	    clickOnElement(newacct);

	    WebElement firstname = driver.findElement(By.name("firstname"));
	    userInput(firstname, "janu");
	    WebElement lastname= driver.findElement(By.name("lastname"));
	    userInput(lastname, "k");
	    
	   WebElement regemail = driver.findElement(By.name("reg_email__"));
	   userInput(regemail, "vijay1432@gmail.com");
		
		WebElement newpass = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		userInput(newpass, "59745545");
		
		WebElement day =driver.findElement(By.name("birthday_day"));
		Select s = new Select(day);
		boolean multiple =selectIsMuliple(day);
		System.out.println(multiple);
		s.selectByIndex(4);
		WebElement month = driver.findElement(By.id("month"));
		Select s1 = new Select(month);
		s1.selectByValue("3");
		WebElement year = driver.findElement(By.name("birthday_year"));
		Select s2 = new Select(year);
		s2.selectByVisibleText("1997");

	    WebElement gender = driver.findElement(By.name("sex"));
	    clickOnElement(gender);
	    
	    WebElement signup = driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));
	    clickOnElement(signup);
	     capture();
//	    TakesScreenshot t = (TakesScreenshot) driver;                                     
//		File v2 = t.getScreenshotAs(OutputType.FILE);
//		File f2 = new File("C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\fbvjvj.png");
//	    FileUtils.copyFile(v2, f2);

	  driver.findElement(By.xpath("//img[@class='_8idr img']")).click();  
	  String title2 = driver.getTitle();
	  System.out.println("current page title" + title2);
	    if (title1.equals(title2)) {
			System.out.println("currentpage and initial user launched is same");
		}
	    else {
	    	quit();
		}
	  
	    
	}
		}

