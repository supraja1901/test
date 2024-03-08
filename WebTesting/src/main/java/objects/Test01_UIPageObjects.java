package objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class Test01_UIPageObjects extends Base {
	WebDriver driver;

	public Test01_UIPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//table[@id='sitemap']/tbody/tr/td/a")
	List<WebElement> LinkUrl;

	public List<WebElement> LinkUrl() {
		return LinkUrl;
	}
}
