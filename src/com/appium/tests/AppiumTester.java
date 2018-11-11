package com.appium.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;

public class AppiumTester extends BaseTest{

	@Test
	public void test() throws IOException, InterruptedException {
		System.out.println("Execution started....");
		Process process = Runtime.getRuntime().exec("adb shell am start -a android.settings.AIRPLANE_MODE_SETTINGS");
		process.waitFor();
		WebElement toggle = driver.findElementsByXPath("//android.widget.Switch").get(1);
		if (toggle.getText().equals("OFF")) {
			toggle.click();
		}
		Process p1 = Runtime.getRuntime().exec("adb shell settings get global airplane_mode_on");
		BufferedReader in = new BufferedReader(new InputStreamReader(p1.getInputStream()));
		String line = in.readLine();
		Assert.assertTrue(line.trim().equals("1"));
	}
}
