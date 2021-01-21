package com.automationpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class WomenDress extends WebPageActions {
	
	Logger log = LogManager.getLogger(WomenDress.class.getSimpleName());
	
	public WomenDress() {
		super(WomenDress.class.getSimpleName());
	}
	
	
	public void mouseOverToPrintedSummerDress() throws Exception {
		hoverToElement("btn_printedsummerdress");
	}
	
	public void clickOnQuickView() throws Exception {
		clickOnElement("btn_quickview");
	}

}
