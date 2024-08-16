package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class NewUser extends Hook
{
  @Test
  public void usertest() throws Exception 
  {
	  utilities.GenerateReport.test =   utilities.GenerateReport.report.createTest("usertest");
	  
	  Actions a = new Actions(driver);
	  a.moveToElement(signin).perform();
	  
	  starthere.click();
	  
	  uid2.sendKeys("9810926239");
	  
	  utilities.GenerateReport.test.log(Status.PASS, MarkupHelper.createLabel("Entered mobile number ", ExtentColor.BLUE));

	  utilities.ScreenShot2.takeScreenshot("usertest");
	  ctnbtn2.click();
  }
}
