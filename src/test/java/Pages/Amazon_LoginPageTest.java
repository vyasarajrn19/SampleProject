package src.test.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import src.test.java.Driver.DesiredCapabilities;

public class Amazon_LoginPageTest extends DesiredCapabilities{

	
	@FindBy(id = "gw-sign-in-button")
	public static WebElement SignIn;
			
	@FindBy(xpath = "//android.widget.EditText[@text='Amazon password']")
	public static WebElement Password;
	
	@FindBy(xpath = "//android.widget.Button[@text='Login']")
	public static WebElement Login;
}
