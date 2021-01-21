package com.automationpractice.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class AddedToCart extends WebPageActions{
	
	Logger log = LogManager.getLogger(AddedToCart.class.getSimpleName());
	
	public AddedToCart() {
		super(AddedToCart.class.getSimpleName());
	}
	
	public void clickOnContinueShoppingBtn() throws Exception {
		clickOnElement("btn_ctnshopping");
	}

}
