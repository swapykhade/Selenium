package Pkg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class leaveapply
{
	WebDriver driver;
	String BaseURL;
	WebDriverWait wait;
	Alert alert;
	
 /*	public void Validate(String Message) 
	{
		if (Message != null)
		{
			System.out.println("No Alert");
		
		} 
		else
		{
			System.out.println("Alert Message is Present");
				
		}
		
	}
	
  */
	/* public boolean isAlertPresent() 
  	{ 
  	    try 
  	    { 
  	        driver.switchTo().alert(); 
  	        String Text = alert.getText();
  	        System.out.println("The Text of Alert is :"+Text);
  	        alert.accept();
  	        return true; 
  	    }   // try 
  	    catch (NoAlertPresentException Ex) 
  	    { 
  	        return false; 
  	    }   // catch 
  	}   // isAlertPresent()
*/
	
	
	
@Test(priority = 0)
  public void LoginPage() 
  {
	  
	  System.out.println("In Login Page Function");
	  WebElement UsertName = driver.findElement(By.id("txt_LoginId"));
	  UsertName.sendKeys("etam101");
	  
	  WebElement Password  = driver.findElement(By.id("txt_Password"));
	  Password.sendKeys("Etam101@");
	  
	  WebElement LoginButton = driver.findElement(By.id("btn_Login"));
	  LoginButton.click();
	  
	 // WebDriverWait wait = new WebDriverWait(driver, 20);
      // wait.until(ExpectedConditions.alertIsPresent());
      
  }

@Test(priority = 1)
public void Leave()
{
	WebElement ELms = driver.findElement(By.id("eLMS"));
	ELms.click();
	
	WebElement ApplyLeaveLink = driver.findElement(By.linkText("Apply Leave / Tour"));
	ApplyLeaveLink.click();
	
	String PAGEtITLE2 = driver.getTitle();
	assertEquals(PAGEtITLE2, "NEW ETAM");
	System.out.println("Page is Correct");

}

@Test(priority=2)
public void ApplyLeave()
{

	//driver.navigate().to("");
	try {	
	
	driver.switchTo().frame("iFrmCenter");
	WebElement EmpId =  driver.findElement(By.id("txt_EmpID1")); ////*[@id="txt_EmpID1"]
//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iFrmCenter")));
	
	EmpId.click();
	//WebElement EmpId =  driver.findElement(By.name("txt_EmpID1")); ////*[@id="txt_EmpID1"]
	//EmpId.click();
	EmpId.sendKeys("101006791");
	EmpId.sendKeys(Keys.ENTER);
	
	WebElement Selection_DropDown_Lv_Nature = driver.findElement(By.id("DropDown_Lv_Nature"));
//	List <WebElement> myIput = driver.findElements((By) Selection_DropDown_Lv_Nature);
	wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(Selection_DropDown_Lv_Nature));
	Selection_DropDown_Lv_Nature.click();
	
	Select select = new Select(Selection_DropDown_Lv_Nature);
	
	List<WebElement> Options =  select.getOptions(); 
	
	for (WebElement e: Options)
	{
		System.out.println(e.getText());
	}
	

	//Select dropdown = new Select(Selection_DropDown_Lv_Nature);
	//dropdown.selectByIndex(1);
	

	
	}
	catch(NoSuchElementException e)
	{
		e.printStackTrace();
	}
	
}

  @BeforeTest
  public void beforeTest()
  {
	  driver = new FirefoxDriver();
	  BaseURL="http://192.168.0.34:5/wyselogin.aspx";
	  driver.get(BaseURL);
	  System.out.println("URL is Opened");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("Window is Maximized");
	  String Title= driver.getTitle();
	  assertEquals("Wyse Biometrics Systems", Title);
  }

  @AfterTest
  public void afterTest()
  {
	 // driver.findElement(By.linkText("Logout")).click();
	  //driver.close();
	  System.out.println("The Test Case Complited");
	  
  }

}
