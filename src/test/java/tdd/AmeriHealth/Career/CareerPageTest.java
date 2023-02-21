package tdd.AmeriHealth.Career;

import org.testng.Assert;
import org.testng.annotations.Test;
import tdd.AmeriHealth.Reportings.Logs;
import tdd.AmeriHealth.base.BaseClass;

public class CareerPageTest extends BaseClass {

	@Test(enabled = true)
	public void careerPageTest() throws InterruptedException {

		careerPage.validateLandingPageTitle("The only plan you need.");
		careerPage.clickCareerBtn(driver);
		careerPage.validateCareerPageTitle("Corporate culture");
		careerPage.clickSeeCurrentJob(driver);
		Thread.sleep(5000);
		careerPage.inputJobKeyword(driver);
		careerPage.clickSearchBtn();
	}

	@Test(enabled = false, priority = 0, groups = { "career","non-func" }, dependsOnMethods = "test2", ignoreMissingDependencies = true)
	public void test1() {
		Logs.log("Test1");
	}

	@Test(enabled = false, priority = 1, groups = { "career", "non-func" }, invocationCount = 2)
	public void test2() {
		Logs.log("Test2");
	}

	@Test(enabled = true, priority = 2, groups = { "career", "non-func" })
	public void failedTestScenarios() {
		Logs.log("Test3");
		Assert.fail();
	}

	@Test(enabled = true, priority = 3, groups = { "career","non-func" }, retryAnalyzer = tdd.AmeriHealth.Retry.RetryFailedTests.class)
	public void testRetry() {
		Logs.log("Retry Test");
		Assert.fail();
	}

}
