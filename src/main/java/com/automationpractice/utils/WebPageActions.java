package com.automationpractice.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageActions extends WebBrowserActions {

	static Logger log = LogManager.getLogger(WebPageActions.class);
	
	static String pageName = "";
	
	public WebPageActions(String PageName) {
		pageName = PageName;
	}

	public static void waitForPageToLoad(long seconds) {
		
		try {
			driver.get().manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println("Unable to load Page");
			e.printStackTrace();
		}
	}

	public static void waitForElementsImplicitly(long seconds) {
		
		try {
			driver.get().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error("Unable to wait for element");
			e.printStackTrace();
		}
	}

	public static void waitUntilElementVisible(long seconds, WebElement element) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log.error("Element not visible on webPage: " + e.getMessage());
		}
	}

	public static void waitABit() {
		
		try {
			Thread.sleep(SleepWaitTime);
		} catch (Exception e) {
			System.err.println("Unable to wait");
			e.printStackTrace();
		}
	}

	public static void jsHighlighter(WebElement element) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		try {
			js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
			Thread.sleep(300);
			js.executeScript("arguments[0].setAttribute('style', 'border: none;');", element);
			Thread.sleep(300);
		} catch (Exception e) {
			System.err.println("Failed to highlight the page");
			e.printStackTrace();
		}
	}

	public static void launchUrl(String url) {
		
		try {
			driver.get().get(url);
			waitForPageToLoad(4);
			log.info("URL:" + " " + url + " " + "is launched succesfully");
		} catch (Exception e) {
			 log.error("Unable to launch URL[" + url + "]"); 
			e.printStackTrace();
		}
	}

	public static void waitUntilElementLocated(String xpath, long seconds) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			log.error("Element not found on webPage: " + e.getMessage());
			
		}

	}

	public static WebElement findElementOnWebPage(String propName) throws Exception {

		WebElement element = null;
		String propXpath = "";
		try {

			propXpath = PropUtils.fetchProperty(pageName + "." + propName, PropUtils.pathForOR);
			waitUntilElementLocated(propXpath, ConditionalWaitTime);
			element = driver.get().findElement(By.xpath(propXpath));
			waitUntilElementVisible(ConditionalWaitTime, element);
			ScrollIntoView(element);
			jsHighlighter(element);

		} catch (Exception e) {
			log.error("Element with Xpath[" + propXpath + "] not found");
			return null;
		}
		return element;
	}

	public static List<WebElement> findElementsOnWebPage(String propName, String value) throws Exception {

		List<WebElement> list = null;
		String propXpath = "";
		try {
			propXpath = PropUtils.fetchProperty(pageName + "." + propName, PropUtils.pathForOR);
			waitUntilElementLocated(propXpath, ConditionalWaitTime);
			list = driver.get().findElements(By.xpath(propXpath));
			return list;
			
		} catch (Exception e) {
			log.error("Element with Xpath[" + propXpath + "] not found");
		}
		return list;
	}

	public void switchToFrame() {
		driver.get().switchTo().frame(0);
	}
	
	public static void clickOnElement(String propName) throws Exception {

		try {
			WebElement element = findElementOnWebPage(propName);
			waitABit();
			element.click();
			log.info("Clicked element[" + propName + "]");
			
		} catch (Exception e) {
			log.error("Unable to click element[" + propName + "]");
			e.printStackTrace();
		}
	}

	public static void enterValueInTextField(String propName, String value) throws Exception {
		
		try {
			WebElement element = findElementOnWebPage(propName);
			element.click();
			element.clear();
			element.sendKeys(value);
			waitABit();
			log.info("Entered Value[" + value + "] in Textbox[" + propName + "]");
			
		} catch (Exception e) {
			log.error("Unable to enter value[" + value + "] in textbox[" + propName + "]");
			e.printStackTrace();
		}
	}

		
	public static WebElement verifyRadioButton(String propName) {
		
		WebElement element = null;
		try {
				element = findElementOnWebPage(propName);
				waitABit();
				log.info("Clicked element[" + propName + "]");
				 
			} catch (Exception e) {
				System.err.println("Unable to click element[" + propName + "]");
				e.printStackTrace();
			}
		return element;
		}

	public static String getTextForElement(String propName) throws Exception {
		
		String text = "";
		try {
			WebElement element = findElementOnWebPage(propName);
			waitUntilElementVisible(ConditionalWaitTime, element);
			text = element.getText();
			log.info("Fetched text[" + text + "] of element[" + propName + "]");
			 
		} catch (Exception e) {
			log.error("Unable to get text of element[" + propName + "]");
		}
		return text;
	}
	
	public static void hoverToElement(String propName) throws Exception {
		
		try {
			WebElement element = findElementOnWebPage(propName);
			Actions act = new Actions(driver.get());
			waitABit();
			act.moveToElement(element).build().perform();
			log.info("Hovered to element[" + propName + "]");
		}catch (Exception e) {
			log.error("Unable to move to element[" + propName + "] ");
		}
	}
	
	public void selectSize(String propName,String size) throws Exception {
		try {
		WebElement ele = findElementOnWebPage(propName);
		Select ddl = new Select(ele);
		ddl.selectByVisibleText(size);
		} catch(Exception e) {
			log.error("Unable to select size [" + propName + "]");
		}
	}
	
	public static void hoverToElementAndClick(String propName) throws Exception {
		
		try {
			WebElement element = findElementOnWebPage(propName);
			Actions act = new Actions(driver.get());
			act.moveToElement(element).click().build().perform();
			log.info("Hovered to element[" + propName + "]");
		}catch (Exception e) {
			System.out.println("Unable to move to element[" + propName + "] ");
			log.error("Unable to move to element[" + propName + "] ");
		}
	}
		
	public static void clickRadioButton(String propName) throws Exception {
		
		waitABit();
		WebElement element = findElementOnWebPage(propName);
		element.click();
		try {
			if (element.getAttribute("class").contains("checked")) {
				log.info("The checkbox has been selected");
			} else {
				log.error("The checkbox has not been selected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static String GetAttibuteForElement(String propName, String attribute) throws Exception {
		String attrValue = "";
		try {
			WebElement element = findElementOnWebPage(propName);
			attrValue = element.getAttribute(attribute);
		} catch (Exception e) {
			System.out.println("Unable to return attribute[" + attribute + "]");
			e.printStackTrace();
		}

		return attrValue;

	}
	
}
	

	
	
