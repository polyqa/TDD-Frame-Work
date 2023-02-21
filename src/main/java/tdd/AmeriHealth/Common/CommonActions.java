package tdd.AmeriHealth.Common;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tdd.AmeriHealth.Reportings.Logs;

public class CommonActions {
	public static void clickElement(WebElement element) {
		try {
			element.click();
			Logs.log(element + "<---->has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log(element + "<---->has not been clicked");
			Assert.fail();
		}
	}

	public static void validate(WebElement element, String expected) {
		String actual = "";
		try {
			actual = element.getText();
			Logs.log("Validating --->actual :" + actual + "***Expected : " + expected);
		} catch (NoSuchElementException | NullPointerException e) {
			Logs.log(element + "<---->has not been clicked");
			Assert.fail();
		}
		Assert.assertEquals(actual, expected);
	}

	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			Logs.log(input + "<---->has been put into" + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Logs.log(element + "<---->has not been clicked, so couldn't put input");
			Assert.fail();
		}
	}

}
