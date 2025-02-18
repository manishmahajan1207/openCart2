package com.openCart2.testCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart2.pageObjects.HomePage;
import com.openCart2.pageObjects.LoginPage;
import com.openCart2.pageObjects.MyAccountPage;
import com.openCart2.testBase.BaseClass;
import com.openCart2.utilities.DataProviders;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = ("LoginData") , dataProviderClass = DataProviders.class) //timeOut = 30)to fail test if it does not execute in perticular time
	public void loginDDT(String user,String pwd,String res) {
		
		logger.info("*******Login DDT_test started**********");
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		hp.userLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean accPage = mp.isMyAccountPageExists();
		
//		if(mp.isMyAccountPageExists()) {
//					
//					logger.info("TestCase Passed");
//					Assert.assertTrue(true);
//					mp.clickLogout();
//				}
//				else {
//					logger.info("TestCase Failed");
//					Assert.assertTrue(false);
//				}
				
				
				
		//for valid Scenarios		
		if(res.equalsIgnoreCase("valid")) {
			
			if(accPage==true) {
				
				mp.clickLogout();
				Assert.assertTrue(true);
				
			}else {
				Assert.assertTrue(false);
			}
			
		}
		//for invalid scenarios
		if(res.equalsIgnoreCase("invalid")) {
			
			if(accPage==true) {
				mp.clickLogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		
		logger.info("*******Login DDT_test Finished**********");
	}

}
