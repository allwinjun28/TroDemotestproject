package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutoverview {
	
	public WebDriver driver;

	public Checkoutoverview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	@FindBy(css="#finish")
	WebElement finishButton;
	
	
	public void clickNextPageButton()
	{
		finishButton.click();
	}

}
