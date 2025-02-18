package com.openCart2.testCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart2.pageObjects.HomePage;
import com.openCart2.pageObjects.RegistrationPage;
import com.openCart2.testBase.BaseClass;

public class TC_RegistratinTest_003 extends BaseClass {

	@Test(groups = {"Master","Sanity","Regression"}, priority = 1)
	public void registrationTest() {
		
		logger.info("***Registration Test Case Started*****");
		
		HomePage hp = new HomePage(driver);
		
		hp.myAccountClick();
		hp.registerUser();
		
		logger.info("*******Enter Registration details******");
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomAlphabets());
		rp.setLastName(randomAlphabets());
		rp.setEmail(randomAlphabets()+"@gmail.com");
		rp.setTelephone(randomNumerics());
		
		String pwd = randomAlphaNumericStrings();
		
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		rp.btnChkdPolicy();
		rp.btnContinue();
		
		logger.info("*****Validation Started*****");
		
		if(rp.getConfirmationMsg()==true) {
			
			logger.info("Testcase Passed");
			Assert.assertTrue(true);
			
		}else {
			
			logger.info("TestCase Failed");
			Assert.assertTrue(false);
		}
		
		logger.info("*******Registration TC finished*********");
		
	}
}
