package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form_Filing {

	public static WebDriver driver;

	@FindBy(name = "firstname")
	private WebElement name;

	@FindBy(name = "lastname")
	private WebElement lastname;

	@FindBy(name = "reg_email__")
	private WebElement regemail;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement newpass;

	@FindBy(name = "birthday_day")
	private WebElement day;

	@FindBy(id = "month")
	private WebElement month;

	@FindBy(name = "birthday_year")
	private WebElement year;

	@FindBy(name = "sex")
	private WebElement gender;

	@FindBy(xpath = "(//button[text()='Sign Up'])[1]")
	private WebElement signup;

	public Form_Filing(WebDriver driver4) {
		this.driver = driver4;
		PageFactory.initElements(driver4, this);

	}

	public WebElement getName() {
		return name;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getRegemail() {
		return regemail;
	}

	public WebElement getNewpass() {
		return newpass;
	}

	public WebElement getday() {
		return day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getSignup() {
		return signup;
	}

}
