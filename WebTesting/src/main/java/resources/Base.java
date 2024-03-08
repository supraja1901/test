package resources;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {

	protected WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		// Initialize WebDriver based on the specified browser
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			break;
		default:
			throw new IllegalArgumentException("Invalid browser specified");
		}

	}

	@AfterMethod
	public void QuitDriver() {
		driver.quit();
	}

	@DataProvider(name = "devicesAndResolutions")
	public Object[][] getDevicesAndResolutions() {
		return new Object[][] { { "Desktop", 1920, 1080 }, { "Desktop", 1366, 768 }, { "Desktop", 1536, 864 },
				{ "Mobile", 360, 640 }, { "Mobile", 414, 896 }, { "Mobile", 375, 667 } };

	}

	public void TakeScreenshot(String FolderPathPostUserDir) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		String folderPath = System.getProperty("user.dir") + FolderPathPostUserDir;
		File folder = new File(folderPath);
		folder.mkdirs();
		String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
		File destination = new File(folder, "Screenshot-" + timestamp + ".png");
		screenshotFile.renameTo(destination);

	}

}
