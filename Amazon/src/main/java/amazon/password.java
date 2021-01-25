package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class password {

	public WebDriver driver;

	By password=By.name("password");
	By loginbutton=By.id("signInSubmit");
	
	public password(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement enterpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement continulogin()
	{
		driver.findElement(loginbutton).click();
		return driver.findElement(loginbutton);
	}
}
