package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutcomplete {
	public WebDriver driver;

	public Checkoutcomplete(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
		
	@FindBy(css=".complete-header")
	WebElement Confirmationmessage;
	
	public String confirmmessagetext()
	{
		String confirmationmessageincheckout;
		confirmationmessageincheckout=Confirmationmessage.getText();
		return confirmationmessageincheckout;
		
	}
}
