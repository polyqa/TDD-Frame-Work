package tdd.AmeriHealth.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tdd.AmeriHealth.Common.CommonActions;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h2")
	WebElement landingPageTitle;

	@FindBy(css = "a.btn.btnHeroCTA.shop")
	WebElement shopForPlan;

	@FindBy(xpath = "h1")
	WebElement memberPageTitle;

	@FindBy(xpath = "(//a[@class='more'])[2]")
	WebElement applyNow;

	public void validateLandingPageTitle(String expectedTitle) {
		CommonActions.validate(landingPageTitle, expectedTitle);
	}

	public void clickShopForPlan() {
		CommonActions.clickElement(shopForPlan);
	}

	public void validatememberPageTitle(String expectedTitle) {
		CommonActions.validate(landingPageTitle, expectedTitle);
	}

	public void clickapplyNow() {
		CommonActions.clickElement(applyNow);
	}

}
