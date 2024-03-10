package objectRepository;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import genericPackge.BaseClass;

public class HomePage extends BaseClass {

	String actTitle;
	String exTitle;
	String laptopName;
	String l;

	// verify title
	public void title(WebDriver driver) {
		actTitle = driver.getTitle();
		exTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
//	 assertion(actTitle, exTitle,"Verifying the homepage loads successfully.");

	}

	// search text box
	@FindBy(name = "q")
	private WebElement searchTextBox;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getSearchTextBox() {
		searchTextBox.sendKeys("laptop" + Keys.ENTER);

	}

	@FindBy(xpath = "//div[text()='Lenovo IdeaPad 1 AMD Athlon Dual Core 7120U - (8 GB/512 GB SSD/Windows 11 Home) 15AMN7 Thin and Light ...']")
	private WebElement laptop;

	public void getLaptop() {
		l = laptop.getText();

		String[] l1 = l.split("...");
		laptopName = String.valueOf(l1);
		laptop.click();
	}

	@FindBy(xpath = "//span[@class='B_NuCI']")
	private WebElement laptopVerify;

	public void getLaptopVerify() throws IOException {
		String s = laptopVerify.getText();
		String[] s1 = s.split("Laptop");
		String s2 = String.valueOf(s1[0]).concat("...");

		assertion(l, s2, "Verifing the correct item is in the cart.");
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;

	public void getAddToCart() {
		addToCart.click();

	}

	// click on cart icon
	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement cart;

	public void getCart() {
		cart.click();
	}

}
