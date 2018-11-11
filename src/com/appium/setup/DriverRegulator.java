package com.appium.setup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverRegulator {

	public static Map<String, String> tcDeviceMap = new ConcurrentHashMap<>();
	
	public static List<String> getTestCases() {
		List<String> testcases = new ArrayList<>();
		testcases.add("com.appium.tests.Tester");
		testcases.add("com.appium.tests.AppiumTester");
		return testcases;
	}
	
	
}
