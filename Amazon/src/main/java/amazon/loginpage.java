package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {
	
	public WebDriver driver;
	
	By signinbutton=By.cssSelector("a.nav-action-button");

	
	public loginpage(WebDriver driver)
    {
		this.driver=driver;
	}
	
	public WebElement signinbutton()
	{
		return driver.findElement(signinbutton);
	}
	

}
