package com.generic;

import org.openqa.selenium.WebDriver;

import com.driver.manager.DriverManager;
import com.util.Constants;

public class CostcoAutomation {
	
	public static void productHandle(){
		
	WebDriver driver=DriverManager.getBrowser("chrome");
	driver.manage().window().maximize();
	driver.navigate().to(Constants.COSTCO_URL);
		
		 
		 
	 }
	
	public static void main(String[] args) {
		
		CostcoAutomation.productHandle();
		
	}
	
}


