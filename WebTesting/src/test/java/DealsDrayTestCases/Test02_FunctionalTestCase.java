package DealsDrayTestCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import objects.Test02_FunctionalTestPageObjects;
import resources.Base;

public class Test02_FunctionalTestCase extends Base {

	@Test
	public void FunctionalTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String LoginCredential = "prexo.mis@dealsdray.com";
		Test02_FunctionalTestPageObjects ftpo = new Test02_FunctionalTestPageObjects(driver);
		driver.manage().window().maximize();
		driver.get(" https://demo.dealsdray.com/");

		wait.until(ExpectedConditions.elementToBeClickable(ftpo.userName())).sendKeys(LoginCredential);
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.passWord())).sendKeys(LoginCredential);
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.Login())).click();
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.Order())).click();
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.Orders())).click();
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.AddBulkOrders())).click();
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.Import())).click();

		driver.switchTo().alert().getText().contentEquals("Please Select File");
		driver.switchTo().alert().accept();

		wait.until(ExpectedConditions.elementToBeClickable(ftpo.ChooseFile()))
				.sendKeys(System.getProperty("user.dir") + "/Resources/demo-data.xlsx");
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.Import())).click();
		wait.until(ExpectedConditions.elementToBeClickable(ftpo.ValidateData())).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().getText().contentEquals("Please Check Errors");
		driver.switchTo().alert().accept();
		TakeScreenshot("/screenshots/FunctionalTest/");

	}
}
