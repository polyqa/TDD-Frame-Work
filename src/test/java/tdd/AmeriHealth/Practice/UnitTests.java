package tdd.AmeriHealth.Practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import org.testng.annotations.Test;

import tdd.AmeriHealth.Utils.AutoData;

public class UnitTests {

	@Test(enabled = false)
	public void unitTestAutoDataNull() {
		AutoData data = new AutoData("name", null);
		System.out.println(data.getLandingPageTitle());
	}

	@Test(enabled = false)
	public void unitTestAutoDataZeroLenght() {
		AutoData data = new AutoData("can", "");
		System.out.println(data.getLandingPageTitle());
	}

	@Test(enabled = false)
	public void system_getPropertyTest() {
		System.out.println(System.getProperty("java.home"));
	}

	@Test(enabled = true)
	public void folderOps() {
		File folder = new File("screenShot");
		System.out.println(folder.getAbsolutePath());
		System.out.println(folder.mkdirs());
	}

	@Test
	public void timeUnitTest() {
		Date date = new Date();
		System.out.println(date);
		Instant time = Instant.now();
		System.out.println(time);

		System.out.println(LocalDateTime.now().plusYears(1).plusMonths(1));

		System.out.println("Test1_" + time + ".png");
		SimpleDateFormat date_format = new SimpleDateFormat("MM:dd:YYYY_HH:mm:ss");
		System.out.println(date_format.format(date));
	}
}
