package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productspage {
	
	public WebDriver driver;

	public Productspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
		
	@FindBy(css=".inventory_item")
	List<WebElement> items;
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartButton;
	
	
	public String addItemtoCart()
	{
		int totalItems=items.size();
	    System.out.println("Total items = "+totalItems);
	    String itemName = null;
	
	if(totalItems>0)
	{
		items.get(2).findElement(By.tagName("button")).click();
		itemName=items.get(2).findElement(By.className("inventory_item_name")).getText();
		System.out.println("itemName items = "+itemName);
	}
	return itemName;
	}
	
	public void clickoncart()
	{
		cartButton.click();
	}

}
