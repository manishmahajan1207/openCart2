package com.openCart2.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		
		String path = ".//testData//Opencart_LoginData.xlsx";
		
		ExcelUtility e = new ExcelUtility(path);
		int rowCount = e.getRowCount("sheet1");
		int cellCount = e.getCellCount("sheet1", 1);
		
		String loginData[][] = new String[rowCount][cellCount];
				
				for(int i = 1;i<=rowCount; i++) {
					for(int j = 0; j<cellCount; j++) {
						
						loginData[i-1][j] = e.getCellData("sheet1", i, j);
					}
					
				}
				
				return loginData;
		
		
	}

}
