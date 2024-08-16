package testcases;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class ShopTest //extends Hook
{
  @Test(dataProvider = "dp",dependsOnGroups={"logincheck"})
  public void productsearch(String product) 
  {
	  
	  utilities.GenerateReport.test =   utilities.GenerateReport.report.createTest("productsearch");
	  
	  Hook.productsearchbox.clear();
	  Hook.productsearchbox.sendKeys(product);
	  
	  utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel(" Searching for "+product, ExtentColor.BLUE));

	  
	  Actions a = new Actions(Hook.driver);
	  a.sendKeys(Keys.ENTER).perform();
	  
	Iterator <WebElement> it1 =   Hook.productname.iterator();
	Iterator <WebElement> it2 =   Hook.productlink.iterator();
	
	while(it1.hasNext() && it2.hasNext())
	{
	WebElement podname = 	it1.next();
	WebElement podlink = it2.next();
	
	//System.out.println("");
	utilities.GenerateReport.test.log(Status.PASS, MarkupHelper.createLabel(" Product Results "+podname.getText(), ExtentColor.GREEN));

	}
  }

  @DataProvider
  public String[][] dp() throws Exception 
  {
      return utilities.MakeConnectionPOI.getData("AmazonLogin", "Sheet2");
  }
}
