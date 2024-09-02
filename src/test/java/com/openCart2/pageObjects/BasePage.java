package com.openCart2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver ldriver) {
		// TODO Auto-generated constructor stub
		this.driver = ldriver;
		PageFactory.initElements(ldriver,this);
	}

}
