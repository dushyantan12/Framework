package com.appium.setup;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.sourceforge.htmlunit.corejs.javascript.SecurityUtilities;

public class Utilities {

	private static Utilities utilities = null;
	public static Map<String, AppiumDriverLocalService> serviceMap = new ConcurrentHashMap<>();
	public static Map<String,AndroidDriver<RemoteWebElement>> driverMap = new ConcurrentHashMap<>();
	private static List<AndroidDriver<RemoteWebElement>> driverList = new ArrayList<>();
	private Utilities() {
		
	}
	public static Utilities getInstance() {
		if(utilities==null)
			utilities = new Utilities(); 
		return utilities;
	}
	
	protected List<Device> getDeviceDetails(File iniFile) throws InvalidFileFormatException, IOException {
		Ini ini = new Ini(iniFile);
		ini.load();
		Iterator<Section> s = ini.values().iterator();
		List<Section> sections = new ArrayList<>();
		while (s.hasNext()) {
			sections.add(s.next());
		}
		int size = sections.size();
		List<Device> deviceList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Device device = new Device();
			device.udid = ini.get(sections.get(i), "udid");
			device.packageName = ini.get(sections.get(i),"appPackage");
			device.appWaitActivity = ini.get(sections.get(i),"waitActivity");
		}
		return deviceList;
	}
	
	public List<String> getDeviceList() {
		List<String> listDevices = null;
	    try
	    {
	      listDevices = new ArrayList<String>();
	      Process process = Runtime.getRuntime().exec("adb devices");
	      BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	      String line = null;
	      
	      Pattern pattern = Pattern.compile("^([a-zA-Z0-9\\-:.]+)(\\s+)(device)");
	      while ((line = in.readLine()) != null) {
	        if (line.matches(pattern.pattern()))
	        {
	          Matcher matcher = pattern.matcher(line);
	          if (matcher.find()) {
	            listDevices.add(matcher.group(1).trim());
	          }
	        }
	      }
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    return listDevices;
	}
	
	
	
	public void startServerForAllSessions(List<Device> devices) throws Exception {
		List<String> connectedDevices = getDeviceList();
		for (Device device : devices) {
			if(!(connectedDevices.contains(device.udid)))
			{
				throw new Exception("Device "+device.udid+" is not connected to device");
			}
			
			AppiumDriverLocalService serv = SetupSession.getInstance().startSession(device.udid);
			serv.start();
			AndroidDriver<RemoteWebElement> driv =SetupSession.getInstance().getDriver(SetupSession.getInstance().getCapability(device.udid));
			driverList.add(driv);
			serviceMap.put(device.udid, serv);
			driverMap.put(device.udid, driv);
		}
	}
	
	protected class Device
	{
		public String udid = null;
		public String packageName = null;
		public String appWaitActivity = null;
		public String deviceName = null;
		
		private Device() {}
	}
	
	public void startExecution() throws Exception {
		Ini ini = new Ini(new File("C:\\Users\\sreddy6\\Desktop\\Framework\\AppiumFramework\\Resources\\Device.INI"));
		ini.load();
		List<Device> deviceList = new ArrayList<>();
		Set<String> sectionNames = ini.keySet();
		for (String sectionName : sectionNames) 
		{
			Device device = new Device();
			device.deviceName=sectionName;
			device.udid=ini.get(sectionName, "udid");
			device.packageName=ini.get(sectionName, "appPackage");
			device.appWaitActivity=ini.get(sectionName, "waitActivity");
			deviceList.add(device);
		}
		Runtime.getRuntime().exec(new String[] { "taskkill", "/F", "/IM", "node.exe" });
		this.startServerForAllSessions(deviceList);
		
		
	}

}

