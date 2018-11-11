package com.test.perfecto;import java.util.Arrays;


public class PageFactory {

	private static HomePage localHomePage = null;
	
	public static HomePage homePage = (localHomePage==null)?(localHomePage = new HomePage()):localHomePage;
	
}
