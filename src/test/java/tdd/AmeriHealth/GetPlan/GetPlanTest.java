package tdd.AmeriHealth.GetPlan;

import org.testng.annotations.Test;
import tdd.AmeriHealth.base.BaseClass;

public class GetPlanTest extends BaseClass {

	@Test(enabled = false, groups = ("getPlan"))
	public void getPlanTest() {
		landingPage.validateLandingPageTitle("The only plan you need.");
		landingPage.clickShopForPlan();
		landingPage.validatememberPageTitle("Have a life event?");
		landingPage.clickapplyNow();

	}

	@Test(enabled = false, groups = ("getPlan"))
	public void getStartedTest() {
		landingPage.clickShopForPlan();
		landingPage.clickapplyNow();

	}

}
