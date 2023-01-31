package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Fb_Sdp {

	public static WebDriver driver;
	private LoginPage l;
	private Create_Account c;
	private Form_Filing f;

	public Fb_Sdp(WebDriver driver2) {

		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	    
	}

	public LoginPage loginPage() {

		if (l == null) {
			l = new LoginPage(driver);

		}

		return l;
	}

	public Create_Account createNewAccount() {

		if (c == null) {
			c = new Create_Account(driver);
		}

		return c;

	}

	public Form_Filing form_Filing() {

		if (f == null) {
			f = new Form_Filing(driver);

		}
		return f;

	}
}
