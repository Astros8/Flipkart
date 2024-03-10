package genericPackge;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class BaseClass {
	protected WebDriver driver;

	// Open the browser and enter the url
	@BeforeClass

	public void openURL() throws IOException {

		String browser = property("browser");
		if (browser == "chrome") {
			driver = new ChromeDriver();
		} else if (browser == "firefox") {
			driver = new FirefoxDriver();
		} else if (browser == "IE") {
			driver = new InternetExplorerDriver();
		}
		String url = property("url");
		driver = new ChromeDriver();

		driver.get(url);

	}

	// Read url from property file
	public String property(String string) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/file.property");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(string);
	}

	// maximize the browser
	@BeforeMethod
	public void maximize() {
		driver.manage().window().maximize();
	}

	// implicit wait
	@BeforeMethod
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Switching Window
	public void windowSwitch() {
		String pWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String window : allWindow) {
			if (!(window.equals(pWindow))) {
				driver.switchTo().window(window);
			}
		}
	}

	// verifying the product
	public void assertion(String actual, String Expected, String string) {
		Assert.assertEquals(actual, Expected);
		

	}

	// close the browser
	@AfterClass
	public void close() {
		

		driver.quit();
	}

}
