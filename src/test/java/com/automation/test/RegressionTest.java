package com.automation.test;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationpractice.pages.AddToCart;
import com.automationpractice.pages.AddedToCart;
import com.automationpractice.pages.Address;
import com.automationpractice.pages.ContinueShopping;
import com.automationpractice.pages.Information;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.Payment;
import com.automationpractice.pages.CheckOut;
import com.automationpractice.pages.Shipping;
import com.automationpractice.pages.SignIn;
import com.automationpractice.pages.WomenDress;
import com.automationpractice.utils.WebBrowserActions;

public class RegressionTest {
	

	@Parameters("Browser")
	@BeforeTest(alwaysRun = true)
	public void initBrowser(String browser) {
		WebBrowserActions.initializeBrowser(browser);
		WebBrowserActions.maximizeBrowser();
		System.out.println("Test Execution Started on browser[" + "" + "] at : " + new Date());
	}
	
	@Test
	public void ShoppingCartTest() throws Exception {
		HomePage hp = new HomePage();
		hp.launchWebsite();
		hp.hoverOverWomenTab();
		hp.clickOnSummerDressBtn();
		
		WomenDress dress = new WomenDress();
		dress.mouseOverToPrintedSummerDress();
		dress.clickOnQuickView();
		
		AddToCart addToCart = new AddToCart();
		String orderedQty = addToCart.fetchQty("value");
		String orderedDressName = addToCart.fetchDressName();
		addToCart.selectFromDropDown("S");
		addToCart.clickOnAddToCart();
		
		AddedToCart addedToCart = new AddedToCart();
		addedToCart.clickOnContinueShoppingBtn();
	
		ContinueShopping shoppingPage = new ContinueShopping();
		shoppingPage.hoverOverToCartBtn();
		shoppingPage.clickOnCheckOut();
		
		CheckOut proceedToCheckout = new CheckOut();
		proceedToCheckout.clickOnProceedToCheckout();
		
		SignIn signIn = new SignIn();
		signIn.enterEmailAddress("Ankur" + RandomStringUtils.randomAlphanumeric(2)+"@gmail.com");
		signIn.clickOnCreateAnAccountBtn();
		
		Information info = new Information();
		info.enterFirstName("Ankur");
		info.enterLastName("Kumar");
		info.enterPassword("QAnkur");
		info.enterAddress("123 best Driver");
		info.enterCity("Toronto");
		info.selectStateFromDropDownMenu("Alabama");
		info.enterPostalCode("84198");
		info.enterMobilePhone("1234567891");
		info.enterAddressAlias("Hello");
		info.clickOnRegisterBtn();
		
		Address address = new Address();
		address.clickOnProceedToCheckout();
		
		Shipping shipping = new Shipping();
		shipping.clickOnRadioButton();
		shipping.clickOnProceedToCheckout();
		
		Payment payment = new Payment();
		payment.fetchDressName(orderedDressName);
		payment.fetchQtyNumber(orderedQty);
		
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		WebBrowserActions.closeAllBrowsers();
		System.out.println("Test Execution Finished on: " + new Date());

	}
	
}
