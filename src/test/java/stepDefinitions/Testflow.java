package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import objectRepository.Cartpage;
import objectRepository.Checkoutcomplete;
import objectRepository.Checkoutoverview;
import objectRepository.Checkoutpage;
import objectRepository.Loginpage;
import objectRepository.Productspage;
import resources.Base;

public class Testflow extends Base{
	String itemAddedtoCart;
	String itemNameInCart;
	String expectedCheckoutConfirmmessage="THANK YOU FOR YOUR ORDER";
	Cartpage cartpage;
	Checkoutpage checkoutpage;
	Checkoutoverview checkoutoverview;
	Checkoutcomplete checkoutcomplete;
	
	@Before
	public void openDriver()
	{
		driver=initializeDriver();
	}

	@Given("I launch the website")
	public void i_launch_the_website() {
		driver.get("https://www.saucedemo.com/");
	}
	@When("I login as a standard user {string}")
	public void i_login_as_a_standard_user(String username) {
		Loginpage loginpage=new Loginpage(driver);
		String usernmeVal=username;
		String password="secret_sauce";
		loginpage.enterUsername(usernmeVal);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
	}

	@When("I  browse and add items to cart")
	public void i_browse_and_add_items_to_cart() {
Productspage productspage=new Productspage(driver);
		
		itemAddedtoCart=productspage.addItemtoCart();
		productspage.clickoncart();
	}

	@When("I validate if item is added to cart")
	public void i_validate_if_item_is_added_to_cart() {
		 cartpage=new Cartpage(driver);
		itemNameInCart=cartpage.cartItemDetails();
		
		Assert.assertEquals(itemAddedtoCart, itemNameInCart);
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		cartpage.clickOnCheckout();

	}

	@When("I enter the user information")
	public void i_enter_the_user_information() {
		 checkoutpage=new Checkoutpage(driver);
		checkoutpage.enterfirstname();
		checkoutpage.enterlastname();
		checkoutpage.entercode();
		checkoutpage.clickNextPage();
	}

	@When("I proceed to finish the checkout")
	public void i_proceed_to_finish_the_checkout() {
		 checkoutoverview=new Checkoutoverview(driver);
			checkoutoverview.clickNextPageButton();
	}

	@Then("Validate the confirmation message")
	public void validate_the_confirmation_message() throws InterruptedException, IOException {
		 checkoutcomplete=new Checkoutcomplete(driver);
			Thread.sleep(5000);
			takeScreenShot(driver);
			String actualexpectedCheckoutConfirmmessage=checkoutcomplete.confirmmessagetext();
			Assert.assertEquals(expectedCheckoutConfirmmessage, actualexpectedCheckoutConfirmmessage);			
			closeBrowser();
	}


}
