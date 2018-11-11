package com.appium.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class Tester extends BaseTest{

	//@Test
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
	
	@Test
	public void test2() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.startActivity(new Activity("com.google.android.apps.messaging", ".ui.ConversationListActivity"));
		driver.findElement(By.id("com.google.android.apps.messaging:id/start_new_conversation_button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.messaging:id/recipient_text_view"))).sendKeys("8978543653");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.messaging:id/contact_picker_create_group"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.messaging:id/compose_message_text"))).sendKeys("Hai");
		driver.hideKeyboard();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.apps.messaging:id/send_message_button_container"))).click();
		driver.navigate().back();
		String name = driver.findElementsById("com.google.android.apps.messaging:id/conversation_name").get(0).getText();
		Assert.assertEquals("Teju", name);
	}
	
	//@Test(priority=0)
	public void testHomeScreen() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("com.bigbasket.mobileapp:id/text_your_location"))));
		Assert.assertTrue(driver.findElement(By.id("com.bigbasket.mobileapp:id/text_your_location")).getText().equals("Your Location"));
		Assert.assertTrue(driver.findElement(By.id("imgInRow")).getAttribute("enabled").equals("true"));
		Assert.assertTrue(driver.findElement(By.id("com.bigbasket.mobileapp:id/daimajia_slider_image")).getAttribute("enabled").equals("true"));
		Assert.assertEquals(driver.findElements(By.id("com.bigbasket.mobileapp:id/bbBottomNavItemText")).size(),5);
	}
	
	//@Test(priority=1)
	public void testCategories() {
		//wait.until(c->c.findElements(By.xpath("//*[@id='bbBottomNavItemText']")).forEach(c->c.getText().equals("Categories")));
		driver.findElements(By.id("com.bigbasket.mobileapp:id/bbBottomNavItemText")).get(1).click();
		Assert.assertTrue(driver.findElement(By.id("com.bigbasket.mobileapp:id/shopByCategory")).getText().equals("SHOP BY CATEGORY"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Fruits & Vegetables']")).click();
		Assert.assertEquals(driver.findElementsById("com.bigbasket.mobileapp:id/linearLayout").size(), 8);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Fruits & Vegetables']")).click();
	}
	
	//@Test
	public void testSearch() throws InterruptedException, IOException {
//		driver.findElements(By.id("com.bigbasket.mobileapp:id/bbBottomNavItemText")).get(2).click();
//		Assert.assertTrue(driver.findElement(By.id("com.bigbasket.mobileapp:id/txtTermHeader")).isEnabled());
//		driver.findElement(By.id("com.bigbasket.mobileapp:id/homePageSearchBox")).click();
//		Runtime.getRuntime().exec("adb shell input text fresh\\ bread");
//		//driver.findElement(By.id("com.bigbasket.mobileapp:id/homePageSearchBox")).sendKeys("bread");
//		driver.pressKeyCode(AndroidKeyCode.ENTER);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.bigbasket.mobileapp:id/txtProductCount")));
//		//driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.bigbasket.mobileapp:id/txtProductCount\")"))
//		boolean istrue = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.bigbasket.mobileapp:id/txtProductCount\")").isEnabled();
//		Assert.assertTrue(istrue);
//		List<?> result = driver.findElements(By.id("com.bigbasket.mobileapp:id/txtProductDesc"));
//		for (Object object : result) {
//			Assert.assertTrue(((AndroidElement)object).getText().toLowerCase().contains("bread"));
//		}
//		driver.findElements(By.id("com.bigbasket.mobileapp:id/bbBottomNavItemText")).get(2).click();
//		try {
//			driver.hideKeyboard();
//		} catch (Exception e) {
//			System.out.println("Keyboard not found");
//		}
//		Assert.assertTrue(driver.findElements(By.id("com.bigbasket.mobileapp:id/txtTerm")).get(0).getText().equals("bread"));
//		Assert.assertTrue(driver.findElement(By.id("com.bigbasket.mobileapp:id/imgSearchTermAction")).isEnabled());
//		driver.findElement(By.id("com.bigbasket.mobileapp:id/imgSearchTermAction")).click();
//		Assert.assertFalse(driver.findElement(By.id("com.bigbasket.mobileapp:id/txtTerm")).getText().equals("bread"));
		TouchAction t = new TouchAction(driver);
		Dimension d = driver.manage().window().getSize();
		int height = d.height;
		int width = d.width;
		//t.press(el)
		Location loc = new Location(256.333, 256.333, 256.333);
		driver.setLocation(loc);
		//Thread.sleep(60000);
	}
}
