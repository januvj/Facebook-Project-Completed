package com.facebook_sdp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.pom.Fb_Sdp;
import Facebook_with_baseclass.Facebook_base;

public class FaceBook_Sdp extends Facebook_base{
 public static WebDriver driver;
	
		public static void main(String[] args) throws Exception {
			browserlaunch("chrome");

			String url = getUrl("https://www.facebook.com");
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String title = driver.getTitle();

			
			String title1 = "facebook";
			System.out.println(title);

			if (url.contains(title1)) {
				System.out.println("Correcturl");
			} else {
				System.out.println("not correct url");
			}
			
			Fb_Sdp sdp = new Fb_Sdp(driver);
			sdp.loginPage().getEmail();
			userInput(sdp.loginPage().getEmail(), "janu123@gmail");

			sdp.loginPage().getPass();
			userInput(sdp.loginPage().getPass(), "123458");

			sdp.loginPage().getLog();
			clickOnElement(sdp.loginPage().getLog());
			capture();

//			TakesScreenshot v = (TakesScreenshot) driver;                                     
//			File v1 = v.getScreenshotAs(OutputType.FILE);
//			File f1 = new File("C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\fbvj.png");
//		    FileUtils.copyFile(v1, f1);	

			driver.navigate().to(url);
			sleep();
			sdp.createNewAccount().getNewacct();
			
			clickOnElement(sdp.createNewAccount().getNewacct());


			sdp.form_Filing().getName();
			userInput(sdp.form_Filing().getName(), "janu");
			
			sdp.form_Filing().getLastname();
			userInput(sdp.form_Filing().getLastname(), "k");

			sdp.form_Filing().getRegemail();
			userInput(sdp.form_Filing().getRegemail(), "vijay1432@gmail.com");

			
			sdp.form_Filing().getNewpass();
			userInput(sdp.form_Filing().getNewpass(),"59745545");

			sdp.form_Filing().getday();
			Select s = new Select(sdp.form_Filing().getday());
			boolean multiple = selectIsMuliple(sdp.form_Filing().getday());
			System.out.println(multiple);
			s.selectByIndex(4);
			Select s1 = new Select(sdp.form_Filing().getMonth());
			s1.selectByValue("3");

			sdp.form_Filing().getYear();
			Select s2 = new Select(sdp.form_Filing().getYear());
			s2.selectByVisibleText("1997");

			sdp.form_Filing().getGender();
			clickOnElement(sdp.form_Filing().getGender());

			
			sdp.form_Filing().getSignup();
			clickOnElement(sdp.form_Filing().getSignup());
			capture();
//		    TakesScreenshot t = (TakesScreenshot) driver;                                     
//			File v2 = t.getScreenshotAs(OutputType.FILE);
//			File f2 = new File("C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\fbvjvj.png");
//		    FileUtils.copyFile(v2, f2);

			driver.findElement(By.xpath("//img[@class='_8idr img']")).click();
			String title2 = driver.getTitle();
			System.out.println("current page title" + title2);
			if (title1.equals(title2)) {
				System.out.println("currentpage and initial user launched is same");
			} else {
				quit();
			}

		}
	}

	
	
	
	
	
