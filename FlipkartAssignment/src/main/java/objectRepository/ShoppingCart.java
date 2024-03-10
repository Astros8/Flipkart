package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericPackge.BaseClass;

public class ShoppingCart extends BaseClass {
	
	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrder;
	
	public void getPlaceOrder() {
		placeOrder.click();
	}

}
