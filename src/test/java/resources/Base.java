package resources;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;		

	
	public static WebDriver initializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}
	public void takeScreenShot(WebDriver driver) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateVal=df.format(date);
		String Path=System.getProperty("user.dir")+"\\Screenshots\\screen"+dateVal+".png";
		System.out.println(Path);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(Path);
		FileUtils.copyFile(SrcFile, DestFile);
	}
		

}
