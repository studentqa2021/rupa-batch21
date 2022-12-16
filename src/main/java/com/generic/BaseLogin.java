package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.driver.manager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	
	public void getLogin() {
		
		WebDriver driver =DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
	SeleniumWait.getImplicitWait(driver, 3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().to(Constants.URL);
		try {
			ScreenShot.getScreenShot(driver, "HomePage");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SeleniumPageFactory pf =new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver,pf.getSigninBtn().get(0),3);
		Highlighter.getColor(driver,pf.getSigninBtn().get(0),"red");
		pf.getSigninBtn().get(0).click();
		try {
			ScreenShot.getScreenShot(driver, "Login Page");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Highlighter.getColor(driver, pf.getEmail(),"red");
	    pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		Highlighter.getColor(driver, pf.getPassword(),"green");
        pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);
		Highlighter.getColor(driver, pf.getSecondSigninBtn(),"blue");
		pf.getSecondSigninBtn().click();
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
	}

}
