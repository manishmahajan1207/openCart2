package com.openCart2.testCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart2.pageObjects.HomePage;
import com.openCart2.pageObjects.LoginPage;
import com.openCart2.pageObjects.MyAccountPage;
import com.openCart2.testBase.BaseClass;


public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		logger.info("*******Login test started**********");
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		hp.userLogin();
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Enter Username");
		lp.setUsername("mms@gmail.com");
		logger.info("Enter Password");
		lp.setPassword("manish");
		logger.info("Enter Login Button");
		lp.clickLogin();
		
		MyAccountPage mp = new MyAccountPage(driver);
		
		if(mp.isMyAccountPageExists()) {
			
			logger.info("TestCase Passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("TestCase Failed");
			Assert.assertTrue(false);
		}
		
		logger.info("*******Login test Finished**********");
		
	}
	

}
