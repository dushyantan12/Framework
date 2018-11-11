
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class AutomationDriver {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		TestNG testNg = new TestNG();
		List<String> testcases = new ArrayList<String>();
		testcases.add("com.appium.tests.Tester.class");
		//testcases.add("com.appium.tests.AppiumTester.class");
		testNg.setTestClasses(new Class[] {com.appium.tests.Tester.class});
		testNg.setThreadCount(1);
		testNg.setParallel(XmlSuite.ParallelMode.CLASSES);
		testNg.setPreserveOrder(true);
		testNg.run();
		
		//System.out.println("Result is : "+getSum("1bc123 55a g"));
	}
	
}
