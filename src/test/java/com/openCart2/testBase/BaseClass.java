package com.openCart2.testBase;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public void setup() {
		PropertyConfigurator.configure("log4j.properties");
		logger = LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

}
