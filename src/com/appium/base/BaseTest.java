package com.appium.base;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import com.appium.setup.SetupSession;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public AndroidDriver<RemoteWebElement> driver = null;
	
	@BeforeClass
	public void beforeClass() throws IOException 
	{
		SetupSession.getInstance().startSession("47b608f8");
		SetupSession.getInstance().startService();
		driver = SetupSession.getInstance().getDriver(SetupSession.getInstance().getCapability("47b608f8"));
	}	
	
	
	
	@AfterClass
	public void AfterClass() throws IOException 
	{
		SetupSession.getInstance().stopService();
		
		System.out.println("After class ended");
	}
}
