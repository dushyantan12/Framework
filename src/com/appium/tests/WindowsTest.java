package com.appium.tests;

import org.testng.annotations.Test;

public class WindowsTest {

	@Test
	public void test() {
		//ExcelReader reader = new ExcelReader("C:\\Users\\sreddy6\\Desktop\\Framework\\AppiumFramework\\Resources\\Test.xlsx");
				//reader.ReadExcel("test", "TestCase");
//				AppiumDriverLocalService service =  SetupSession.getInstance().startSession("Windows PC");
//				service.start();
//				DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
//				desiredCapabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
//				desiredCapabilities.setCapability("platformName", "Windows");
//				desiredCapabilities.setCapability("deviceName", "Windows PC");
//				WindowsDriver<RemoteWebElement> winDriver = new WindowsDriver<>(service.getUrl(),desiredCapabilities);
//				System.out.println("automation name : "+winDriver.getAutomationName());
//				winDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				winDriver.findElementByName("Nine").click();
//				winDriver.findElementByName("Multiply by").click();
//				winDriver.findElementByName("Nine").click();
//				winDriver.findElementByName("Equals").click();
//				int result = Integer.parseInt(winDriver.findElementByAccessibilityId("CalculatorResults").getText().replace("Display is ", "").trim());
//				Assert.assertEquals(81, result);
//				File screenshot = ((TakesScreenshot)winDriver).getScreenshotAs(OutputType.FILE).getAbsoluteFile();
//				FileUtils.moveFile(screenshot, new File("C:\\Users\\sreddy6\\Desktop\\Framework\\AppiumFramework\\screenshots\\main.png"));
				//service.stop();
				//Runtime.getRuntime().exec(new String[] { "taskkill", "/F", "/IM", "node.exe" });
	}
}
