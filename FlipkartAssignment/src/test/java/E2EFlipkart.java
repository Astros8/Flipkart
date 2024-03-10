import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericPackge.BaseClass;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ShoppingCart;




public class E2EFlipkart extends BaseClass {
	
	 ExtentReports extent; //specify the location of the report
	 ExtentTest test;  //what details should be populated in the report
		
		
		@BeforeTest
		public void startReport() {
			extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/FlipkartReport.html",true);
			extent.addSystemInfo("Host Name","LocalHost");
			extent.addSystemInfo("Environment","QA");
			extent.addSystemInfo("User Name","Rahul");
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		}

		@AfterMethod
		public void getResult(ITestResult result) {
			if(result.getStatus()==ITestResult.FAILURE) {
				test.log(LogStatus.FAIL ,result.getThrowable());
			}
			extent.endTest(test);
		}
		
		@AfterTest
		public void endreport() {
			extent.flush();
		}
	
	
	@Test
	public void test() throws IOException  {
		
		test=extent.startTest("E2EFlipkart");
		
		test.log(LogStatus.PASS, "Opening the browser");
		
		HomePage h=new HomePage(driver);
		h.title(driver);
		test.log(LogStatus.PASS,"Verifing the homepage loads successfully.");
		h.getSearchTextBox();
		test.log(LogStatus.PASS,"In the search bar, typing  laptop and press Enter.");
		
		// click on Laptop
		h.getLaptop();
		test.log(LogStatus.PASS,"Add the selected laptop to the shopping cart.");
		
		//switching window
		windowSwitch();
		
		
		h.getLaptopVerify();
		test.log(LogStatus.PASS,"Verifing the correct item is in the cart");
		
		
		//adding product to cart
		h.getAddToCart();
		test.log(LogStatus.PASS,"Adding the correct item is in the cart");
		
		// click on cart icon
		h.getCart();
		test.log(LogStatus.PASS, "Clicking on the Proceed to Checkout button");
		
		ShoppingCart s=new ShoppingCart(driver);
		s.getPlaceOrder();
		
		LoginPage l=new LoginPage(driver);
		test.log(LogStatus.PASS, "Loging to Flipkart with valid mobile number");
		
		//Entering the Login id
		l.getEnterUserId();
		
		//click on  continue button
		l.getContinueBtn();
		
		test.log(LogStatus.PASS, "Closing the browser");
		
		
		
	}
	

}
