package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Account {

	public static WebDriver driver;

	@FindBy(xpath = "//a[text()='Create new account']")
	private WebElement newacct;

	public Create_Account(WebDriver driver3) {

		this.driver = driver3;
		PageFactory.initElements(driver3, this);

	}

	public WebElement getNewacct() {
		return newacct;
	}
}
