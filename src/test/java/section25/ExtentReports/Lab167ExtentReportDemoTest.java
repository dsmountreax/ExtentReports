package section25.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Lab167ExtentReportDemoTest {
	
	ExtentReports extent;
	
	@BeforeTest
	private void config() {
		
		// ExtentReports, ExtentSparkReporter
		String path=System.getProperty("user.dir")+"\\reports\\index.html"; // obtiene la direccion del proyecto del usuario
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Enrique Oreiro");
	}

	@Test
	private void initialDemo() {
		ExtentTest test=extent.createTest("167 Initial Demo");
		String url="https://rahulshettyacademy.com";
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\chromedriver89\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result does not match");
		extent.flush();

	}
}
