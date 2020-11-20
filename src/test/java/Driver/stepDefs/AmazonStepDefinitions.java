package Driver.stepDefs;

/**
 * 
 *	Author : Vyasaraj
 */
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import ObjectRepository.Amazon_CartPage_OR;
import ObjectRepository.Amazon_HamburgerMenu_OR;
import ObjectRepository.Amazon_HomePage_OR;
import ObjectRepository.Amazon_LoginPage_OR;
import ObjectRepository.Amazon_OR;
import ObjectRepository.Amazon_ProductPage_OR;
import ObjectRepository.Amazon_SearchResultPage_OR;
import PageObjects.CommonMethodsFunctions;
import Utility.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import src.test.java.Driver.DesiredCapabilities;

public class AmazonStepDefinitions extends DesiredCapabilities{

	
	PropertyData data = new PropertyData();
	CommonMethodsFunctions CF = new CommonMethodsFunctions();
	
	public static String ProductName = null;
	
	/**
	 * Launching the APP under test - First step of Test Cases Execution
	 * @throws Throwable
	 */
	@Given("Launch the Amazon app$")
	public void launch_the_Amazon_app() throws Throwable {

		Log.info("Launching the Application based on the Capabilities from the Driver file");
		Log.info("Platform Name here is: " + driver.getCapabilities().getCapability("platformName"));
		

	}
	/**
	 * Action - Click 
	 * @param Button
	 * @throws Throwable
	 */
	
	@When("^User clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String Button) throws Throwable {
		
		if(Button.equals("Start shopping")) {
			try {
				Log.info("Waiting for the Element" + Amazon_HomePageTest.SkipSignIn);
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.SkipSignIn));
				Log.info("Click the Element " + Amazon_HomePageTest.SkipSignIn);
				Amazon_HomePageTest.SkipSignIn.click();
				Log.info("Waiting for the Element" + Amazon_HomePageTest.HamburgerMenu);
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.HamburgerMenu));
			}
			catch(Exception E) {
				Log.info("Expected Element is not Presnet");
				Log.info("Skip Sign in not Displayed Hence moving to HomePage");
				
			}

		}
		else if (Button.equals("hamburger")) {
		Log.info("Waiting for the Element" + Amazon_HomePageTest.HamburgerMenu.toString());
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.HamburgerMenu));
		Log.info("Click the Element " + Amazon_HomePageTest.HamburgerMenu.toString());
		Amazon_HomePageTest.HamburgerMenu.click();
		Log.info("Waiting for the Element" + Amazon_HamburgerMenuTest.HelloSignIn.toString());
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenuTest.HelloSignIn));
		
		}
		else if (Button.equals("Amazon")) {
		Log.info("Waiting for the Element" + Amazon_HomePageTest.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.AmazonLogo));
		Log.info("Click the Element " + Amazon_HomePageTest.AmazonLogo);
		Amazon_HomePageTest.AmazonLogo.click();
		Log.info("Waiting for the Element" + Amazon_HomePageTest.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.AmazonLogo));
			
		}
		else if (Button.equals("Proceed to Buy")) {
		Log.info("Waiting for the Element" + Amazon_CartPageTest.ProceedToBuy);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPageTest.ProceedToBuy));
		Log.info("Click the Element " + Amazon_CartPageTest.ProceedToBuy);
		Amazon_CartPageTest.ProceedToBuy.click();
		try {
			Log.info("Waiting for the Element" + Amazon_CartPageTest.AddMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPageTest.AddMobileNumber));
			Log.info("Enter your Mobile Number to procced  Order");
		}
		catch(Exception E) {
			Log.info("Expected Element is not Presnet");
			
		}
			
		}
	}
	/**
	 * Assertion for Home Page
	 * @param Page
	 */
	
	@And("^Verify \"([^\"]*)\" is displayed$")
	public void verify_page_is_displayed(String Page) {
		
		if(Page.equals("Home page")) {
		Log.info("Waiting for the Element" + Amazon_HomePageTest.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.AmazonLogo));
		Log.info("Verify the presence of the " + Amazon_HomePageTest.AmazonLogo + "in current Page");
		Assert.assertTrue(Amazon_HomePageTest.AmazonLogo.isDisplayed());
	
		}
	}
	
	/**
	 * Login to the Amazon App
	 * @throws InterruptedException
	 */
	@And("^Login to amazon app$")
	public void login_to_amazon_app() throws InterruptedException {
		
		Log.info("Waiting for the Element" + Amazon_HamburgerMenuTest.HelloSignIn);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenuTest.HelloSignIn));
		
		Log.info("Get the Current Orientation of the Device");
		ScreenOrientation CurrentScreen = driver.getOrientation();
		Log.info("The Oreintation of Current Page is : "+ CurrentScreen );
		
		Log.info("Rotate the Current Orientation to LANDSCAPE" );
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Log.info("Rotate the Current Orientation to PORTRAIT" );
		driver.rotate(ScreenOrientation.PORTRAIT);	
		Log.info("Click the Element " + Amazon_HamburgerMenuTest.HelloSignIn);
		Amazon_HamburgerMenuTest.HelloSignIn.click();
		Log.info("Waiting for the Element" + Amazon_HamburgerMenuTest.MobileNumberOrEmail);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenuTest.MobileNumberOrEmail));
		Log.info("Click the Element " + Amazon_HamburgerMenuTest.MobileNumberOrEmail);
		Amazon_HamburgerMenuTest.MobileNumberOrEmail.click();
		Log.info("Clear the text Field before entering any value");
		Amazon_HamburgerMenuTest.MobileNumberOrEmail.clear();
		Log.info("Enter the text " + data.email + "to the text Field");
		Amazon_HamburgerMenuTest.MobileNumberOrEmail.sendKeys(data.email);
		Log.info("Waiting for the Element" + Amazon_HamburgerMenuTest.Continue);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenuTest.Continue));
		Log.info("Click the Element " + Amazon_HamburgerMenuTest.Continue);
		Amazon_HamburgerMenuTest.Continue.click();
		Log.info("Waiting for the Element" + Amazon_LoginPageTest.Password);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_LoginPageTest.Password));
		Log.info("Click the Element " + Amazon_LoginPageTest.Password);
		Amazon_LoginPageTest.Password.click();
		Log.info("Enter the text " + data.password + "to the text Field");
		Amazon_LoginPageTest.Password.sendKeys(data.password);
		Log.info("Waiting for the Element" + Amazon_LoginPageTest.Login);
		wait.until(ExpectedConditions.visibilityOf(Amazon_LoginPageTest.Login));
		Log.info("Click the Element " + Amazon_LoginPageTest.Login);
		Amazon_LoginPageTest.Login.click();
		Log.info("Waiting for the Element" + Amazon_HomePageTest.AmazonLogo);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HomePageTest.AmazonLogo));
	}
	/**
	 * Assertion for Available Text
	 * @param Text
	 */
	
	@And("^Validate text \"([^\"]*)\" is displayed$")
	public void validate_text_displayed(String Text) {
		if(Text.endsWith("Amazon Logo")) {
		Log.info("Waiting for the Element" + Amazon_HomePageTest.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.AmazonLogo));
		Log.info("Verify the presence of the " + Amazon_HomePageTest.AmazonLogo + "in current Page");
		Assert.assertTrue(Amazon_HomePageTest.AmazonLogo.isDisplayed());
		
		}
	}
	
	/**
	 * Assertion for Available Menu	
	 * @param Options
	 */
	@And("^Validate \"([^\"]*)\" is displayed$")
	public void validate_options_menu(String Options) {
		if(Options.equals("Search Bar")) {
		Log.info("Waiting for the Element" + Amazon_SearchResultPageTest.HomeSearch);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPageTest.HomeSearch));
		Log.info("Verify the presence of the " + Amazon_SearchResultPageTest.HomeSearch + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPageTest.HomeSearch.isDisplayed());
		}
		else if (Options.equals("65-inch TV")) {
		Log.info("Waiting for the Element" + Amazon_SearchResultPageTest.ResultsCount);	
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPageTest.ResultsCount));
		Log.info("Verify the presence of the " + Amazon_SearchResultPageTest.ResultsCount + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPageTest.ResultsCount.isDisplayed());
		}
	}
	/**
	 * Verification of Suggestions Page
	 */
	@SuppressWarnings("static-access")
	@And("^Verify the Suggestion on the Home Page$")
	public void verify_the_suggestion_page() {
		Log.info("Swipe the Current Card with the Given Co-Ordinates");
		CF.swipeHorizontal(driver);
	}
	
	@And("^Choose the current location$")
	public void choose_the_current_location() {
		
		Log.info("Waiting for the Element" + Amazon_HomePageTest.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.AmazonLogo));
		Log.info("Click the Element " + Amazon_HomePageTest.AmazonLogo);
		Amazon_HomePageTest.AmazonLogo.click();
		Log.info("Waiting for the Element" + Amazon_HomePageTest.Devliver);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.Devliver));
		Log.info("Click the Element " + Amazon_HomePageTest.Devliver);
		Amazon_HomePageTest.Devliver.click();
		Log.info("Waiting for the Element" + Amazon_HomePageTest.useCurrentLocation);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.useCurrentLocation));
		Log.info("Click the Element " + Amazon_HomePageTest.useCurrentLocation);
		Amazon_HomePageTest.useCurrentLocation.click();
		Log.info("Waiting for the Element" + Amazon_ProductPageTest.AllowPermission);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPageTest.AllowPermission));
		Log.info("Click the Element " + Amazon_ProductPageTest.AllowPermission);
		Amazon_ProductPageTest.AllowPermission.click();
	}
	
	/**
	 * Searching for the Product Based on the User Input
	 * @param Product
	 */
	@And("^Search for the product \"([^\"]*)\"$")
	public void search_for_product(String Product) {
		if(Product.equals("65-inch TV")) {
		Log.info("Waiting for the Element" + Amazon_ProductPageTest.AllowPermission);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPageTest.HomeSearch));
		Log.info("Verify the presence of the " + Amazon_SearchResultPageTest.HomeSearch + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPageTest.HomeSearch.isDisplayed());
		Log.info("Click the Element " + Amazon_SearchResultPageTest.HomeSearch);
		Amazon_SearchResultPageTest.HomeSearch.click();
			try {
				Log.info("Click the Element " + Amazon_CartPageTest.ClearSearch);
				Amazon_CartPageTest.ClearSearch.click();

			}
			catch(Exception E) {
				Log.info("Expected scenarios is not Presnet");
				
				
			}
	
		Log.info("Enter the text " + data.Product + " to the text Field");
		Amazon_SearchResultPageTest.HomeSearch.sendKeys(data.Product);
		Log.info("Waiting for the Element" + Amazon_SearchResultPageTest.SearchDropDown);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPageTest.SearchDropDown));
		Log.info("Click the Element " + Amazon_SearchResultPageTest.SearchDropDown);
		Amazon_SearchResultPageTest.SearchDropDown.click();
		Log.info("Waiting for the Element" + Amazon_SearchResultPageTest.ResultsCount);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPageTest.ResultsCount));
		
		}
	}
	/**
	 * Selecting the Product from the List
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@And("^User selects the product from the list$")
	public void user_selects_the_list() throws MalformedURLException, InterruptedException {
		
		/**
		 * Scrolling to validate the list of Products
		 */
		Log.info("Scrolling to the Requested Element by Text");
		CF.scrollToText(data.Brand, driver);
		
		Log.info("Waiting for the Element" + Amazon_ProductPageTest.RandomResult);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPageTest.RandomResult));
		Log.info("Verify the presence of the " + Amazon_ProductPageTest.RandomResult + "in current Page");
		Assert.assertTrue(Amazon_ProductPageTest.RandomResult.isDisplayed());
		Log.info("Waiting for the Element" + Amazon_ProductPageTest.Inches);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPageTest.Inches));
		Log.info("Verify the presence of the " + Amazon_ProductPageTest.Inches + "in current Page");
		Assert.assertTrue(Amazon_ProductPageTest.Inches.isDisplayed());		
	}
	
	@And("^Verify product details are displayed$")
	public void verify_product_details() {

		Log.info("Waiting for the Element" + Amazon_ProductPageTest.ProdcutName);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPageTest.ProdcutName));
		Log.info("Get the Details of ChoosenProduct");
		ProductName = Amazon_ProductPageTest.ProdcutName.getText();
		Log.info("The Selected Product is : " + ProductName);
		Log.info("Verify the Choosen Product is same as TV or not");
		Assert.assertTrue("The suggestions are not having expected Product", ProductName.contains(data.tv));
	}
	
	@And("^User chooses the product$")
	public void user_chooses_product() {
		Log.info("Waiting for the Element" + Amazon_ProductPageTest.RandomResult);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPageTest.RandomResult));
		Log.info("Click the Element " + Amazon_ProductPageTest.RandomResult);
		Amazon_ProductPageTest.RandomResult.click();
		Log.info("Waiting for the Element" + Amazon_ProductPageTest.Name);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPageTest.Name));
	}
	
	@And("^User Verifies the details of the selected Product$")
	public void user_verifies_the_details() throws MalformedURLException, InterruptedException {
		
		Log.info("Get the Name of ChoosenProduct");
		String ProductDetailsPage = Amazon_ProductPageTest.ProdcutName.getText();
		Log.info("Verify the Choosen Product is same as TV or not");
		Assert.assertEquals(ProductDetailsPage, ProductName);
		Log.info("The Name of the Choosen Prodcut is :"+ProductDetailsPage);
		Log.info("Get the Price of ChoosenProduct");
		String ProductPrice = Amazon_ProductPageTest.Price.getText();
		Log.info("The Price of the Choosen Prodcut is: "+ProductPrice);
		

	}
	@And("^User Add's the product to the Cart$")
	public void user_adds_the_product_to_cart() throws MalformedURLException, InterruptedException {
		Log.info("Add the Procut to Cart by Scrolling to Add Cart Section");
		CF.scrollToText("Add to Cart", driver);
		Log.info("Waiting for the Element" + Amazon_ProductPageTest.AddedToCart);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPageTest.AddedToCart));
		Log.info("Verify the presence of the " + Amazon_ProductPageTest.AddedToCart + "in current Page");
		Assert.assertTrue(Amazon_ProductPageTest.AddedToCart.isDisplayed());
	}
	
	@And("^Navigate to the Cart menu$")
	public void navigate_to_the_cart_menu() {
		Log.info("Waiting for the Element" + Amazon_HomePageTest.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePageTest.AmazonLogo));
		Log.info("Click the Element " + Amazon_HomePageTest.AmazonLogo);
		Amazon_HomePageTest.AmazonLogo.click();
		Log.info("Waiting for the Element" + Amazon_CartPageTest.CartMenu);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPageTest.CartMenu));
		Log.info("Click the Element " + Amazon_CartPageTest.CartMenu);
		Amazon_CartPageTest.CartMenu.click();
		Log.info("Waiting for the Element" + Amazon_CartPageTest.ProceedToBuy);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPageTest.ProceedToBuy));
	}
	
	@And("^Verify the Product in Cart$")
	public void verify_Cart() {
		Log.info("Waiting for the Element" + Amazon_CartPageTest.SubTotal);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPageTest.SubTotal));
		String ProductCartPage = Amazon_ProductPageTest.ProdcutName.getText();
		Log.info("Verify the Expected Element is displayd on Current Page");
		Assert.assertTrue(Amazon_ProductPageTest.ProdcutName.isDisplayed());
		Log.info("Verify the Product is TV or not");
		Assert.assertTrue("The product is not present in the Cart", ProductCartPage.contains(data.tv));
	}
	
	/**
	 * Final Step on Test Case Execution : Terminating the App from the User Session
	 * @throws Throwable
	 */
	@Then("^User closes the app$")
	public void user_closes_the_app() throws Throwable {
		Log.warn("Closing the App");
		driver.closeApp();
		
	}
}
	
