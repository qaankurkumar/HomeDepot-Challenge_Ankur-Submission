package com.automationpractice.utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebBrowserActions {
	

	public static long PageLoadTime;
	static long DefaultWaitTime;
	static long ConditionalWaitTime;
	static long SleepWaitTime;
	static String Browser;
	static String Environment;
	public static String URL;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	static {
		initializeCommonProperties();
		initializeEnvironmentProperties();
	}
	
	public static void initializeBrowser(String browser) {

		if (!browser.isEmpty()) {
			Browser = browser;
		}
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\driver-exes\\chromedriver.exe");
			driver.set(new ChromeDriver());

		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\driver-exes\\geckodriver.exe");
			driver.set(new FirefoxDriver());

		} else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\driver-exes\\IEDriverServer.exe");
			driver.set(new InternetExplorerDriver());
		}

	}

	public static void initializeCommonProperties() {
		
		String configFolderPath = System.getProperty("user.dir") + "//src//main//resources//configs//";

		try {

			PageLoadTime = Long
					.parseLong(PropUtils.fetchProperty("Wait.PageLoad", configFolderPath + "common.properties"));
			DefaultWaitTime = Long
					.parseLong(PropUtils.fetchProperty("Wait.Implicit", configFolderPath + "common.properties"));
			ConditionalWaitTime = Long
					.parseLong(PropUtils.fetchProperty("Wait.Condition", configFolderPath + "common.properties"));
			SleepWaitTime = Long
					.parseLong(PropUtils.fetchProperty("Wait.Sleep", configFolderPath + "common.properties")) * 1000;
			Browser = PropUtils.fetchProperty("Web.Browser",
					configFolderPath + "common.properties");
			Environment = PropUtils.fetchProperty("Web.Environment",
					configFolderPath + "common.properties");
		} catch (Exception e) {
			System.err.println("Unable to initialize framework");
		}
	}

	public static void initializeEnvironmentProperties() {
		
		String environmentPropertiesPath = System.getProperty("user.dir") + "//src//main//resources//configs//"
				+ Environment + ".properties";
		try {
			URL = PropUtils.fetchProperty("web.url", environmentPropertiesPath);
		} catch (Exception e) {
			System.err.println("Unable to load environment [" + Environment + "] properties");
		}
	}

	public static void maximizeBrowser() {
		
		try {
			driver.get().manage().window().maximize();
		} catch (Exception e) {
			System.err.println("Failed to maximize window");
			e.printStackTrace();
		}
	}

	
	public static void closeAllBrowsers() {
		
		try {
			driver.get().quit();
		} catch (Exception e) {
			System.err.println("Failed to close all browsers");
			e.printStackTrace();
		}
	}

	public static void ScrollIntoView(WebElement element) {
		
		try {
			JavascriptExecutor jScriptObject = (JavascriptExecutor) driver.get();
			jScriptObject.executeScript("arguments[0].scrollIntoView()", element);
		} catch (Exception e) {
			System.out.println("Could not scroll into view of element");
			e.printStackTrace();

		}
	}
	
}
