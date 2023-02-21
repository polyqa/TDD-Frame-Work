package tdd.AmeriHealth.Objects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tdd.AmeriHealth.Common.CommonActions;

public class CareerPage {
	public CareerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h2")
	WebElement landingPageTitle;

	@FindBy(xpath = "//a[text()='Careers']")
	WebElement career;

	@FindBy(tagName = "h1")
	WebElement careerPageTitle;

	@FindBy(xpath = "(//a[@class='more'])[2]")
	WebElement seeCurrentJob;

	@FindBy(xpath = "//input[@id='keyword']")
	WebElement jobs;

	@FindBy(xpath = "(//span[@class='btn_text'])[2]")
	WebElement searchBtn;

	public void validateLandingPageTitle(String expectedTitle) {
		CommonActions.validate(landingPageTitle, expectedTitle);
	}

	public void clickCareerBtn(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(career));

		CommonActions.clickElement(career);
	}

	public void validateCareerPageTitle(String expectedTitle) {
		CommonActions.validate(landingPageTitle, expectedTitle);
	}

	public void clickSeeCurrentJob(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", seeCurrentJob);
	}

	public void inputJobKeyword(WebDriver driver) {
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			String ChildWindow = it.next();
			if (!currentWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				jobs.sendKeys("customer service");
			}

		}

	}

	public void clickSearchBtn() {
		CommonActions.clickElement(searchBtn);
	}

}
