package com.automationpractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class Shipping extends WebPageActions {


	public Shipping() {
		super(Shipping.class.getSimpleName());
	}
	
	public void clickOnRadioButton() throws Exception {
		clickRadioButton("btn_termsofservice");
	}
	
	public void clickOnProceedToCheckout() throws Exception {
		clickOnElement("btn_proceedtocheckout");
	}
	
}
