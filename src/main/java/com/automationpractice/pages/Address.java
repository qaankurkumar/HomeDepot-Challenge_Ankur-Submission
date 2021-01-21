package com.automationpractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class Address extends WebPageActions{

	Logger log = LogManager.getLogger(Address.class.getSimpleName());
	
	public Address() {
		super(Address.class.getSimpleName());
	}
	
	public void clickOnProceedToCheckout() throws Exception {
		clickOnElement("btn_proceedtocheckout");
	}
	
	
}
