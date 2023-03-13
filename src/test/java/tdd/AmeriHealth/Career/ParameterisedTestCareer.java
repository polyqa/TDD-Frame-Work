package tdd.AmeriHealth.Career;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tdd.AmeriHealth.Utils.AutoData;
import tdd.AmeriHealth.base.BaseClass;

public class ParameterisedTestCareer extends BaseClass {

	@Parameters({ "expectedPageTitle", "careerPageTitle" })
	@Test(enabled = true, groups = "career")
	public void careerPageTest(String expectedPageTitle, String careerPageTitle) throws InterruptedException {
		careerPage.validateLandingPageTitle(expectedPageTitle);
		careerPage.clickCareerBtn(driver);
		careerPage.validateCareerPageTitle(careerPageTitle);
		careerPage.clickSeeCurrentJob(driver);
		Thread.sleep(5000);
		careerPage.inputJobKeyword(driver);
		careerPage.clickSearchBtn();
	}

	@Parameters({ "expectedPageTitle", "careerPageTitle" })
	@Test(enabled = false, groups = "career")
	public void creat_careerPageTest_AutoData(String expectedPageTitle, String careerPageTitle) throws InterruptedException {
		AutoData autoData = new AutoData(expectedPageTitle, careerPageTitle);
		careerPage.validateLandingPageTitle(expectedPageTitle);
		careerPage.clickCareerBtn(driver);
		careerPage.validateCareerPageTitle(careerPageTitle);
		careerPage.clickSeeCurrentJob(driver);
		Thread.sleep(5000);
		careerPage.inputJobKeyword(driver);
		careerPage.clickSearchBtn();
	}

}
