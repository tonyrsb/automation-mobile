package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	public LoginPage (AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id = "com.loginmodule.learning:id/textInputEditTextEmail")
	public WebElement email;
	
	@AndroidFindBy(id = "com.loginmodule.learning:id/textInputEditTextPassword")
	public WebElement password;
	
	@AndroidFindBy(id = "com.loginmodule.learning:id/appCompatButtonLogin")
	public WebElement loginBtn;
	
	@AndroidFindBy(id = "com.loginmodule.learning:id/textViewLinkRegister")
	public WebElement registerBtn;
	
	@AndroidFindBy(id = "//android.widget.TextView[@text='Enter Valid Email']")
	public WebElement validEmailMessage;
	
}
