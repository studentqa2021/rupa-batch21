package com.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalLoginPractice {
	
	
	
	public static void getFinalLogin() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.navigate().to("https://magento.softwaretestingboard.com/");
	//click sign in button
	driver.findElement(By.xpath("(//*[@class='authorization-link']/a)[1]")).click();
	//put email
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sarowerny@gmail.com");
	//out password
	driver.findElement(By.xpath("//*[@title='Password']")).sendKeys("Student123$");
	//click 2nd sign in
	driver.findElement(By.xpath("//*[@class='action login primary']")).click();
	
	//validate = welcome sarower =xpath ==> is displayed = true = passed
	
	
	if(driver.findElement(By.xpath("(//*[contains(text(),'Welcome')])[1]")).isDisplayed()) {//true
		
		System.out.println("Test passed");
	}else {// not true
		System.out.println("Test failed");
	}
	// never tell test passed ==> but always told when test fail
	Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'Welcome')])[1]")).isDisplayed());
	
	SoftAssert sf = new SoftAssert();
	sf.assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'Welcome')])[1]")).isDisplayed());
	sf.assertAll();
	
	

}

	

	public static void main(String[] args) {
		getFinalLogin();
		
	}
	
}
