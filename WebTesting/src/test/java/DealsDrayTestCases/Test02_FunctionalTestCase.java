package DealsDrayTestCases;

import org.testng.annotations.Test;

import objects.Test02_FunctionalTestPageObjects;
import resources.Base;

public class Test02_FunctionalTestCase extends Base {

	@Test
	public void FunctionalTest() throws InterruptedException {

		String LoginCredential = "prexo.mis@dealsdray.com";
		Test02_FunctionalTestPageObjects ftpo = new Test02_FunctionalTestPageObjects(driver);
		driver.manage().window().maximize();
		driver.get(" https://demo.dealsdray.com/");
		ftpo.userName().sendKeys(LoginCredential);
		ftpo.passWord().sendKeys(LoginCredential);
		ftpo.Login().click();
		Thread.sleep(1000);
		ftpo.Order().click();
		ftpo.Orders().click();
		Thread.sleep(500);
		ftpo.AddBulkOrders().click();
		Thread.sleep(2000);
		ftpo.Import().click();
		driver.switchTo().alert().getText().contentEquals("Please Select File");
		driver.switchTo().alert().accept();
		ftpo.ChooseFile().sendKeys(System.getProperty("user.dir") + "/Resources/demo-data.xlsx");
		ftpo.Import().click();
		ftpo.ValidateData().click();
		Thread.sleep(2000);
		driver.switchTo().alert().getText().contentEquals("Please Check Errors");
		driver.switchTo().alert().accept();
		TakeScreenshot("/screenshots/FunctionalTest/");

	}
}
