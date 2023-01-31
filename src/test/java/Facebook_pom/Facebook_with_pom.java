package Facebook_pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Resuablemethods.Facebook_Base;
import com.pom.Create_Account;
import com.pom.Form_Filing;
import com.pom.LoginPage;

public class Facebook_with_pom extends Facebook_Base {

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
		LoginPage l = new LoginPage(driver);
		l.getEmail();
		userInput(l.getEmail(), "janu123@gmail");

		l.getPass();
		userInput(l.getPass(), "123458");

		l.getLog();
		clickOnElement(l.getLog());
		capture();

//		TakesScreenshot v = (TakesScreenshot) driver;                                     
//		File v1 = v.getScreenshotAs(OutputType.FILE);
//		File f1 = new File("C:\\Users\\Vijay\\eclipse-workspace\\selenium_class10am\\screenshot\\fbvj.png");
//	    FileUtils.copyFile(v1, f1);	

		driver.navigate().to(url);
		sleep();
		Create_Account c = new Create_Account(driver);
		c.getNewacct();
		
		clickOnElement(c.getNewacct());

		Form_Filing f = new Form_Filing(driver);

		f.getName();
		userInput(f.getName(), "janu");
		
		f.getLastname();
		userInput(f.getLastname(), "k");

		f.getRegemail();
		userInput(f.getRegemail(), "vijay1432@gmail.com");

		
		f.getNewpass();
		userInput(f.getNewpass(),"59745545");

		f.getday();
		Select s = new Select(f.getday());
		boolean multiple = selectIsMuliple(f.getday());
		System.out.println(multiple);
		s.selectByIndex(4);
		Select s1 = new Select(f.getMonth());
		s1.selectByValue("3");

		f.getYear();
		Select s2 = new Select(f.getYear());
		s2.selectByVisibleText("1997");

		f.getGender();
		clickOnElement(f.getGender());

		
		f.getSignup();
		clickOnElement(f.getSignup());
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
		} else {
			quit();
		}

	}
}
