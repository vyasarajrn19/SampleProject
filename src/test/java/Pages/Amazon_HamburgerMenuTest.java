package src.test.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class Amazon_HamburgerMenuTest extends desiredCapabilities {

	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/gno_greeting_text_view")
	public static WebElement HelloSignIn;
	
	@FindBy(xpath = "//android.widget.EditText[@index='1']")
	public static WebElement MobileNumberOrEmail;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	public static WebElement Continue;
}
