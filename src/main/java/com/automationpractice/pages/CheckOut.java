package com.automationpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class CheckOut extends WebPageActions {

	Logger log = LogManager.getLogger(CheckOut.class.getSimpleName());
	
	public CheckOut() {
		super(CheckOut.class.getSimpleName());
	}
	
	public void clickOnProceedToCheckout() throws Exception {
		clickOnElement("btn_proceedtocheckout");
	}
	
}
