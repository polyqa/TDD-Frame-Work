package tdd.AmeriHealth.base;

import java.lang.reflect.Method;
import java.time.Duration;

import static tdd.AmeriHealth.Utils.IConstant.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import tdd.AmeriHealth.Objects.GetStartedPage;
import tdd.AmeriHealth.Objects.LandingPage;
import tdd.AmeriHealth.Reportings.ExtentReporting;
import tdd.AmeriHealth.Reportings.ExtentTestManager;
import tdd.AmeriHealth.Utils.Constant;
import tdd.AmeriHealth.Utils.ReadProperties;
import tdd.AmeriHealth.Objects.CareerPage;

public class BaseClass extends ExtentListener {
	protected WebDriver driver;
	ReadProperties envV= new ReadProperties();;
	protected LandingPage landingPage;
	protected GetStartedPage getStartedPage;
	protected CareerPage careerPage;
	ExtentReports extentReports;
	ExtentTest test;

	@BeforeSuite
	public void initExtentReport() {
		extentReports = ExtentTestManager.initialExtentReport();
	}

	@BeforeMethod
	public void startExtentReport(Method method) {
		test = ExtentReporting.createTest(method.getName());
	}

	@AfterSuite
	public void closeReport() {
		extentReports.flush();
	}

	@Parameters("browser")
	@BeforeMethod
	public void setUpDriver(String browser) {
		// System.setProperty("webdriver.chrome.driver", "
		// C:\\Users\\User\\eclipse-workspace\\tdd.AmeriHealth\\
		// C:\\Users\\User\\Downloads\\chromedriver_win32.exe") ;
		// driver = new ChromeDriver();
		// String browser = envV.getProperty(BROWSER);
		 String url = envV.getProperty(URL);
		 long pageLoadwait =envV.getNumProperty(PAGELOAD_WAIT);
		initDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadwait));
		initClasses(driver);

	}

	public void initClasses(WebDriver driver) {
		landingPage = new LandingPage(driver);
		getStartedPage = new GetStartedPage(driver);
		careerPage = new CareerPage(driver);
	}

	private void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		}

	}

	@AfterMethod
	public void getResult(ITestResult result, Method method) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, PASSED);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, FAILED);
			test.addScreenCaptureFromPath(captureScreenShot(driver, method.getName()));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, SKIPPED);
		}
	}

	@AfterMethod
	public void tearup() {
		driver.quit();
	}

	@SuppressWarnings("unused")
	private String getString(Constant constant) {
		return constant.name();
	}

}
