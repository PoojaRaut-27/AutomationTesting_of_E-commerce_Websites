package com.Testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyPlaceorder_ofUser {

	ChromeDriver driver;
	 @BeforeMethod()
	 public void BrowerLaunch() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
	}
	 @Test
	 public void VerifyPlace_Order_001() throws Exception {
		//Verify
			String ExpectedTitleHomepage="Automation Exercise";
			String ActualTitleHomepage=driver.getTitle();
			Assert.assertEquals(ActualTitleHomepage, ExpectedTitleHomepage);
			//. Add products to cart
			driver.findElement(By.xpath("//a[@href='/products']")).click();
			driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
			driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
			driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
			//Register user
			WebElement NewUserSignUp=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
			boolean Value=NewUserSignUp.isDisplayed();
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Pooja");
			driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("PoojaRaut127@gmail.com");
			driver.findElement(By.xpath("//button[text()='Signup']")).click();
			driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pooja27");
			WebElement Day=driver.findElement(By.xpath("//select[@id='days']"));
			Select se=new Select(Day);
			se.selectByValue("12");
			WebElement Month=driver.findElement(By.xpath("//select[@id='months']"));
			Select se1=new Select(Month);
			se1.selectByVisibleText("May");
			WebElement Year=driver.findElement(By.xpath("//select[@id='years']"));
			Select se2=new Select(Year);
			se2.selectByValue("1996");
			driver.findElement(By.xpath("//label[text()='Sign up for our newsletter!']")).click();
			driver.findElement(By.xpath("//label[text()='Receive special offers from our partners!']")).click();
			driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Pooja");
			driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Raut");
			driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Wipro");
			driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Yeola");
			driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Nashik");
		    WebElement country= driver.findElement(By.xpath("//select[@id='country']"));
		    Select s=new Select(country);
		    s.selectByValue("India");
		    driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharastra");
		    driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Mumbai");
		    driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("40001");
		    driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9685652314");
		    driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
		    //Verify
		    WebElement accountCreate=driver.findElement(By.xpath("//b[text()='Account Created!']"));
		    boolean verifyAccount=accountCreate.isDisplayed();
			driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
			//verify
			WebElement loggeduser=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
			boolean loginuser=loggeduser.isDisplayed();
			//Proceed To Checkout 
			driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
			driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
			
			 //Verify
		    WebElement address_details=driver.findElement(By.xpath("//h2[text()='Address Details']"));
		    boolean verifyAddress=address_details.isDisplayed();
			
		    //Verify
		    WebElement Revieworder=driver.findElement(By.xpath("//h2[text()='Review Your Order']"));
		    boolean Review=Revieworder.isDisplayed();
			
			driver.findElement(By.xpath("textarea[@class='form-control']")).sendKeys("ordered is add into cart");
			driver.findElement(By.xpath("//a[@href='/payment']")).click();
			
			driver.findElement(By.xpath("//button[@id='submit']")).click();
			//payment
			driver.findElement(By.xpath("//div[@class='col-md-12 form-group']")).click();
			driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("SBI_card");
			driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("431111111111111");
		    driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("345");
			driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("02");
			driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2021");
			//Verify
		    WebElement OrderPlaced=driver.findElement(By.xpath("//b[text()='Order Placed!']"));
		    boolean OrderPlacedvalue=OrderPlaced.isDisplayed();
			
			driver.findElement(By.xpath("//b[text()='Order Placed!']"));
			driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
			//Verify
			WebElement accountDelete=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
			boolean deleteAcc=accountDelete.isDisplayed();
			driver.findElement(By.xpath("//a[text()='Continue']")).click();
		 
		
	 }
	 @AfterMethod
		public void tearDown() {
			
			driver.quit();
		}
	
}
