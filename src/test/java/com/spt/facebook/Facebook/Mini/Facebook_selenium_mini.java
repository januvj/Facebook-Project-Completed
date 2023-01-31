package com.spt.facebook.Facebook.Mini;


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

public class Facebook_selenium_mini {

	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\newchrome\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.facebook.com";
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		
		String title1 ="facebook";
        System.out.println(title);
        
        if (url.contains(title1)) {
			System.out.println("Correcturl");
		}
        else {
      System.out.println("not correct url");		
	}
	
	WebElement email =driver.findElement(By.name("email"));
    email.sendKeys("janu123@gmail");

	WebElement pass =driver.findElement(By.id("pass"));
	pass.sendKeys("123458");
	
	WebElement log = driver.findElement(By.name("login"));
	log.click();
	TakesScreenshot v = (TakesScreenshot) driver;                                     
	File v1 = v.getScreenshotAs(OutputType.FILE);
	File f1 = new File("C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\fbvj.png");
    FileUtils.copyFile(v1, f1);	
    driver.navigate().to(url);
    WebElement newacct = driver.findElement(By.xpath("//a[text()='Create New Account']"));
    newacct.click();

    WebElement firstname = driver.findElement(By.name("firstname"));
    firstname.sendKeys("janu");
    WebElement lastname= driver.findElement(By.name("lastname"));
    lastname.sendKeys("k");
    
   WebElement regemail = driver.findElement(By.name("reg_email__"));
   regemail.sendKeys("vijay1432@gmail.com");
	
	WebElement newpass = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
	newpass.sendKeys("59745545");
	WebElement day =driver.findElement(By.name("birthday_day"));
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
    
    WebElement signup = driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));
    signup.click();
    
    TakesScreenshot t = (TakesScreenshot) driver;                                     
	File v2 = v.getScreenshotAs(OutputType.FILE);
	File f2 = new File("C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\fbvjvj.png");
    FileUtils.copyFile(v2, f2);
    
  driver.findElement(By.xpath("//img[@class='_8idr img']")).click();  
  String title2 = driver.getTitle();
  System.out.println("current page title" + title2);
    if (title1.equals(title2)) {
		System.out.println("currentpage and initial user launched is same");
	}
    else {
		driver.quit();
	}
    driver.close();
    
}
	}







