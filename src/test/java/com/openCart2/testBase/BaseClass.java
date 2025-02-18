package com.openCart2.testBase;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public WebDriver driver;
	public static Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups = "Sanity")
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException  {
		PropertyConfigurator.configure("log4j.properties");
		logger = LogManager.getLogger(this.getClass());
		
		FileInputStream f = new FileInputStream("./configurations/config.properties");
		p = new Properties();
		p.load(f);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities dc = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				
				dc.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("MAC")) {
				
				dc.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")){
				
				dc.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching os found");
				return;
			}
			
			switch (br.toLowerCase()) {
			case "chrome" : dc.setBrowserName("chrome"); break;
			case "firefox" : dc.setBrowserName("firefox"); break;
			case "edge" : dc.setBrowserName("MicrosoftEdge"); break;

			default: System.out.println("No matching browser found");
				return;
			}
			
			driver = new RemoteWebDriver(new URL(" http://localhost:4444/wd/hub"),dc);
			
	}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		
			switch(br.toLowerCase()) {
		
			case "chrome" : driver = new ChromeDriver();break;
			case "firefox" : driver = new FirefoxDriver();break;
			case "edge" : driver = new EdgeDriver();break;
			default : System.out.println("Invalid Browser Name....."); return;
		
		    }
			
		}
	
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
	}
	
	public String randomAlphabets() {
		
		String randomString = RandomStringUtils.randomAlphabetic(6);
		return randomString;
		
	}
	
	public String randomNumerics() {
		String randomNumber = RandomStringUtils.randomNumeric(4);
		return randomNumber;
	}
	
	public String randomAlphaNumericStrings() {
		String randomString = RandomStringUtils.randomAlphabetic(6);
		String randomNumber = RandomStringUtils.randomNumeric(4);
		return randomString+"@"+randomNumber;
	}
	
	
	@AfterClass(groups = "Sanity")
	public void tearDown() {
		
		driver.quit();
	}

}
