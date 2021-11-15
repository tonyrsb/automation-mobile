package android_automation_mobile;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import android_automation_mobile.base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.LoginPage;

/**
 * Unit test for simple App.
 */
public class LoginTest extends base{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     * @throws InterruptedException 
     */
	
	public String email;
	private String noReset;
	
	public LoginTest() {
		GenerateRand myObj = new GenerateRand(); 
	    this.email = myObj.Generator();
	    this.noReset = "true";
	}
	
	@BeforeTest
	public void successRegis() throws IOException, InterruptedException{
		
		AndroidDriver<AndroidElement> driver = capabilities(this.noReset);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textViewLinkRegister")).click();
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextName")).sendKeys("piton");

    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextEmail")).sendKeys(this.email);
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextPassword")).sendKeys("1234");
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextConfirmPassword")).sendKeys("1234");

    	driver.findElement(By.id("com.loginmodule.learning:id/appCompatButtonRegister")).click();

    	String validation = driver.findElement(By.id("com.loginmodule.learning:id/snackbar_text")).getAttribute("text");
    	assertEquals("Registration Successful", validation);
		
	}
	
	@Test
    public void successLogin() throws IOException, InterruptedException{
		

    	AndroidDriver<AndroidElement> driver = capabilities(this.noReset);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextEmail")).sendKeys(this.email);
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextPassword")).sendKeys("1234");

    	driver.findElement(By.id("com.loginmodule.learning:id/appCompatButtonLogin")).click();
    	
    	String lable = driver.findElement(By.xpath("//android.widget.TextView[@text='Hello,']")).getAttribute("text");
    	assertEquals("Hello,", lable);
    	
    	String name = driver.findElement(By.xpath("//android.widget.TextView[@text='piton']")).getAttribute("text");
    	assertEquals("piton", name);
    	
    	String email = driver.findElement(By.id("com.loginmodule.learning:id/textViewEmail")).getAttribute("text");
    	assertEquals(this.email, email);
    	
    	String pass = driver.findElement(By.id("com.loginmodule.learning:id/textViewPassword")).getAttribute("text");
    	assertEquals("1234", pass);

    }
	
    @Test
    public void invalidFormatEmail() throws IOException, InterruptedException{
    	
    	AndroidDriver<AndroidElement> driver = capabilities(this.noReset);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextEmail")).sendKeys("223edsds");
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextPassword")).sendKeys("123456");

    	driver.findElement(By.id("com.loginmodule.learning:id/appCompatButtonLogin")).click();
    	

    	String validation = driver.findElement(By.xpath("//android.widget.TextView[@text='Enter Valid Email']")).getAttribute("text");
    	assertEquals("Enter Valid Email", validation);
    	

    }
    
    @Test
    public void invalidCredential() throws IOException, InterruptedException{
    	
    	AndroidDriver<AndroidElement> driver = capabilities(this.noReset);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextEmail")).sendKeys("piton@gmail.com");
    	
    	driver.findElement(By.id("com.loginmodule.learning:id/textInputEditTextPassword")).sendKeys("wer");

    	driver.findElement(By.id("com.loginmodule.learning:id/appCompatButtonLogin")).click();
    	

    	String validation = driver.findElement(By.id("com.loginmodule.learning:id/snackbar_text")).getAttribute("text");
    	assertEquals("Wrong Email or Password", validation);
    	

    }
    
    @AfterTest
    public void reset() throws IOException {
    	this.noReset = "false";
    	AndroidDriver<AndroidElement> driver = capabilities(this.noReset);
    	driver.quit();
    }
    
}
