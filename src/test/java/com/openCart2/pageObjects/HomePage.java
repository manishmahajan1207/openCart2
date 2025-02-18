package com.openCart2.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement registerButton;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	
	public void myAccountClick() {
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		//myAccount.click();
	}
	
	public void registerUser() {
		
		registerButton.click();
	}
	
	public void  userLogin() {
		
		lnkLogin.click();
	}
	
	

}
