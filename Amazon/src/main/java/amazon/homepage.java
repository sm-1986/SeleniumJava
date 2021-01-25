package amazon;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@Test
public class homepage extends base {
	
	public WebDriver driver;
	
	By searchfield=By.id("twotabsearchtextbox");
	By searchbutton=By.cssSelector("div.nav-search-submit nav-sprite");
	By signinhover=By.cssSelector("a#nav-link-accountList");
	By signinbutton=By.cssSelector("a.nav-action-button");
	
	
	public homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	}
	
	public WebElement signinmousehover()
	{
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(signinhover)).build().perform();
		return driver.findElement(signinhover);
	}
	
	public loginpage signinbutton()
	{
		driver.findElement(signinbutton).click();
        loginpage lp=new loginpage(driver);
        return lp;
	}
	
	@Test
	public void searchdata()
	{
		Actions a=new Actions(driver); //Initializing Actions class
		WebElement search=driver.findElement(searchfield);
		a.moveToElement(search); //move to searchfield
		search.click();
		driver.findElement(searchfield).sendKeys("Story Books for kids");
		a.build().perform();
		driver.findElement(searchbutton).click();
	}
}


