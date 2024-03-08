package DealsDrayTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.Test01_UIPageObjects;
import resources.Base;

public class test01_UITest extends Base {

	@Test(dataProvider = "devicesAndResolutions")
	public void UITest(String device, int width, int height) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Test01_UIPageObjects uipo = new Test01_UIPageObjects(driver);

		driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		for (int i = 0; i < 5; i++) {
			WebElement element = wait.until(ExpectedConditions.visibilityOfAllElements(uipo.LinkUrls())).get(i);
			String ExpectedUrl = wait.until(ExpectedConditions.visibilityOf(element)).getText();
			wait.until(ExpectedConditions.visibilityOf(element)).click();

//			validation
			Assert.assertEquals(driver.getCurrentUrl(), ExpectedUrl);

			String ScreenshotPathPostUserDir = "/screenshots/" + device + "/" + width + "x" + height + "/";
			TakeScreenshot(ScreenshotPathPostUserDir);

			System.out.println("Screenshot taken for " + device + " > " + width + "x" + height);
			driver.navigate().back();
		}
	}

}
