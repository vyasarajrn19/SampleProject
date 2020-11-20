package src.test.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import src.test.java.Driver.DesiredCapabilities;

public class Amazon_HamburgerMenuTest extends DesiredCapabilities {

	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/gno_greeting_text_view")
	public static WebElement HelloSignIn;
	
	@FindBy(xpath = "//android.widget.EditText[@index='1']")
	public static WebElement MobileNumberOrEmail;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	public static WebElement Continue;
}
