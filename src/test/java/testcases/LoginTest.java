package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class LoginTest extends Hook
{
  @Test(priority = 1,groups= {"logincheck"})
  public void useridTest() 
  {
	 // utilities.GenerateReport.makeReport("LoginTest", "useridTest");
	  utilities.GenerateReport.test =   utilities.GenerateReport.report.createTest("useridTest");	 
	  signin.click();
	     try {
	    uid1.sendKeys("paragguide@yahoo.co.in");	 
	     }
	     catch(Exception e)
	     {
	    uid2.sendKeys("paragguide@yahoo.co.in");	 // correct uid
	     }
	     
	     try
	     {
	    	 ctnbtn1.click();
	     }
	     catch(Exception ee)
	     {
	    	 ctnbtn2.click();
	     }
	     
	     try {
	    String error1 =	 err1.getText();
	    if(err1.isDisplayed())
	    {
	utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel(error1+" displayed", ExtentColor.RED));
	 Assert.fail("Correct uid but showing error");   	    	
	    }
	    else
	    {
	 utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel(" userid is valid ", ExtentColor.GREEN));

	    }
	     }
	     catch(Exception e)
	     {
	    String error1 = err2.getText()	; 
	    if(err2.isDisplayed())
	    {
	utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel(error1+" displayed", ExtentColor.RED));
	 Assert.fail("Correct uid but showing error");   	    	
	    }
	    else
	    {
	 utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel(" userid is valid ", ExtentColor.GREEN));

	    }
	     }
  }
  
  @Test(priority = 2,dependsOnMethods = "useridTest",groups= {"logincheck"})
  public void passwordTest()
  {
	//  utilities.GenerateReport.makeReport("LoginTest", "passwordTest");
	  utilities.GenerateReport.test =  utilities.GenerateReport.report.createTest("passwordTest");
		 try {
	  pwd.sendKeys("RMinfotech12#&&");
	  submit.click();
		 }
		 catch(Exception p)
		 {
			 p.printStackTrace();
		 }
	  try {
		String passwderr =   pwderr.getText();
		 if(pwderr.isDisplayed())
		    {
		utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel(passwderr+" displayed", ExtentColor.RED));
		 Assert.fail("Correct pwd but showing error");   	    	
		    }
		
	     }
	  catch(Exception e)
	  {
		  // pass - loged in no error message..
utilities.GenerateReport.test.log(Status.INFO, MarkupHelper.createLabel(" Logged in ", ExtentColor.GREEN));
			
	  }
  }
}
