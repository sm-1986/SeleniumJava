package amazontest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.Signinpage;
import amazon.base;
import amazon.homepage;
import amazon.loginpage;
import amazon.password;

@Test
public class amazonlogin extends base {
	
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}

	
@Test(dataProvider="getData")
	
	public void PageNavigation(String Username,String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		homepage hp=new homepage(driver);
		new loginpage(driver);
		Signinpage sign=new Signinpage(driver);
		password pwd=new password(driver);
		hp.searchdata();
		hp.signinmousehover();
		hp.signinbutton();
		sign.enteremail().sendKeys(Username);
		sign.continuenext();
		pwd.enterpassword().sendKeys(Password);
		pwd.continulogin();
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	}

	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		//0th row
		data[0][0]="test@gmail.com";
		data[0][1]="Test@123";
		
		//1st row
		data[1][0]="test123@gmail.com";
		data[1][1]="Test@111";
		
		return data;
		
	}
	

}
