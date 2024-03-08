package DealsDrayTestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.Test01_UIPageObjects;
import resources.Base;

public class test01_UITest extends Base {

	@Test(dataProvider = "devicesAndResolutions")
	public void UITest(String device, int width, int height) throws IOException, InterruptedException {

		Test01_UIPageObjects uipo = new Test01_UIPageObjects(driver);

		driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		for (int i = 0; i < 5; i++) {
			WebElement element = uipo.LinkUrl().get(i);
			String ExpectedUrl = element.getText();
			element.click();

			Thread.sleep(1000);

//				validation
			Assert.assertEquals(driver.getCurrentUrl(), ExpectedUrl);

			String ScreenshotPathPostUserDir = "/screenshots/" + device + "/" + width + "x" + height + "/";
			TakeScreenshot(ScreenshotPathPostUserDir);

			System.out.println("Screenshot taken for " + device + " > " + width + "x" + height);
			driver.navigate().back();
		}
	}

}
