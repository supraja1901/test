package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class Test02_FunctionalTestPageObjects extends Base {
	WebDriver driver;

	public Test02_FunctionalTestPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passWord;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Login;

	@FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root has-submenu compactNavItem')]")
	WebElement Order;

	@FindBy(xpath = "//a[@href='/mis/orders']")
	WebElement Orders;

	@FindBy(xpath = "//button[normalize-space()='Add Bulk Orders']")
	WebElement AddBulkOrders;

	@FindBy(xpath = "//input[@type='file']")
	WebElement ChooseFile;

	@FindBy(xpath = "//button[normalize-space()='Import']")
	WebElement Import;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Validate Data']")
	WebElement ValidateData;

	public WebElement ValidateData() {
		return ValidateData;
	}

	public WebElement Import() {
		return Import;
	}

	public WebElement ChooseFile() {
		return ChooseFile;
	}

	public WebElement AddBulkOrders() {
		return AddBulkOrders;
	}

	public WebElement Order() {
		return Order;
	}

	public WebElement Orders() {
		return Orders;
	}

	public WebElement Login() {
		return Login;
	}

	public WebElement passWord() {
		return passWord;
	}

	public WebElement userName() {
		return userName;
	}
}
