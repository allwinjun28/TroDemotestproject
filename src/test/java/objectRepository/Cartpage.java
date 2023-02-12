package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	public WebDriver driver;

	public Cartpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
		
	@FindBy(css=".inventory_item_name")
	WebElement cartitemname;
	
	@FindBy(css="#checkout")
	WebElement checkoutButton;
	
	public String cartItemDetails()
	{
		String cartItemname=cartitemname.getText();
		return cartItemname;
	}
	
	public void clickOnCheckout()
	{
		checkoutButton.click();
	}
}
