package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signinpage {
	
	public WebDriver driver;

	By email=By.name("email");
	By continuebutton=By.xpath("//input[@id='continue']");
	
	public Signinpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement enteremail()
	{
		return driver.findElement(email);
	}
	
	public WebElement continuenext()
	{
		driver.findElement(continuebutton).click();
		return driver.findElement(continuebutton);
	}
}
