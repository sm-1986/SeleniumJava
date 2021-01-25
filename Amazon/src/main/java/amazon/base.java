package amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class base {
	
	public WebDriver driver;
	public Properties prop;
    public WebDriver initializeDriver() throws IOException
    {
	
          prop= new Properties();
          FileInputStream fis=new FileInputStream("C:\\Users\\swach\\eclipse-workspace\\Amazon\\src\\main\\java\\amazon\\Data.properties");
          prop.load(fis);
          String browserName=prop.getProperty("browser");
          System.out.println(browserName);

          if(browserName.equals("chrome"))
          {
	           System.setProperty("webdriver.chrome.driver", "C:\\Users\\swach\\eclipse-workspace\\Amazon\\src\\main\\Driver\\chromedriver.exe");
	           ChromeOptions options =new ChromeOptions();
	      	   if(browserName.contains("headless"))
	      	   {
	      	        options.addArguments("headless");
	      	   }
	           driver= new ChromeDriver(options);
	      }
          else if (browserName.equals("firefox"))
          {
        	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\swach\\eclipse-workspace\\Amazon\\src\\main\\Driver\\geckodriver.exe"); 
        	  FirefoxOptions options =new FirefoxOptions();
        	  if(browserName.contains("headless"))
	      	   {
	      	        options.addArguments("headless");
	      	   }
	       	  driver= new FirefoxDriver();	
        	  
          }
          else if (browserName.equals("IE"))
          {
        	  System.setProperty("webdriver.ie.driver", "C:\\Users\\swach\\eclipse-workspace\\Amazon\\src\\main\\Driver\\IEDriverServer.exe"); 
        	  driver=new InternetExplorerDriver ();	
          }

          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          return driver;
          
    }  
          
    @Test
    public String getScreenShot(String testCaseName,WebDriver driver) throws IOException
    {
          	TakesScreenshot ts=(TakesScreenshot) driver;
          	File source=ts.getScreenshotAs(OutputType.FILE);
          	String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
          	FileUtils.copyFile(source,new File(destinationFile));
          	return destinationFile;
    }
   
}


