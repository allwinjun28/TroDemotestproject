package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {

	public WebDriver driver;

	public Checkoutpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	
	@FindBy(css="#first-name")
	WebElement firstname;
	
	@FindBy(css="#last-name")
	WebElement lastname;
	
	
	@FindBy(css="#postal-code")
	WebElement code;
	@FindBy(css="#continue")
	WebElement continueButton;
	
	public void enterfirstname()
	{
		firstname.sendKeys("firstname");
	}
	public void enterlastname()
	{
		lastname.sendKeys("lastname");
	}
	public void entercode()
	{
		code.sendKeys("1234");
	}
	public void clickNextPage()
	{
		continueButton.click();
	}
	
	
}
