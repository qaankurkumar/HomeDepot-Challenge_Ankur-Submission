package com.automationpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class ContinueShopping extends WebPageActions {

	Logger log = LogManager.getLogger(ContinueShopping.class.getSimpleName());
	
	public ContinueShopping() {
		super(ContinueShopping.class.getSimpleName());
	}
	
	public void hoverOverToCartBtn() throws Exception {
		hoverToElement("lbl_cart");
	}
	
	public void clickOnCheckOut() throws Exception {
		hoverToElementAndClick("btn_checkout");
	}
	
	
	
	
	
	
}
