package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Enter Email/Mobile number']/ancestor::div/input")
	private WebElement enterUserId;
	
	public void getEnterUserId() {
		enterUserId.sendKeys("8210902936");
	}

	@FindBy(xpath="//span[text()='CONTINUE']")
	private WebElement continueBtn;
	
	public void getContinueBtn() {
		continueBtn.click();
	}
}
