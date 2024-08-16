package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Page {
  
	public static WebDriver driver = null;
	
  @Parameters({"browser","url","key","reportname","testname"})	
  @BeforeTest
  public void openBrowser(String browser,String url,String key,String reportname,String testname) 
  {
	  if(!Boolean.parseBoolean(key))
	  {
		  throw new SkipException("skip test "+testname);
	  }
	  else
	  {
		  // initialize report
		  utilities.GenerateReport.makeReport(reportname, testname);
		  
		  if(browser.equals("chrome"))
			{
				driver = new ChromeDriver(); // launch chrome
			}
			else if(browser.equals("edge"))
			{
				driver = new EdgeDriver();  // launch edge
			}
			else if(browser.equals("firefox"))
			{
				driver = new FirefoxDriver();  // launch firefox
			}
			driver.get(url); // get url to test
			
			 // add message in report
			utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel("browser "+browser+" url "+url +" opens ", ExtentColor.BLUE));
	    	
			PageFactory.initElements(driver, this); // for reading external xpath
			
			// implicit wait..
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.manage().window().maximize();
	  }
  }

  @AfterTest
  public void closeBrowser() 
  {
	  driver.quit();
	  utilities.GenerateReport.report.flush() ;
  }

}
