package com.automationpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class HomePage extends WebPageActions {

	Logger log = LogManager.getLogger(HomePage.class.getSimpleName());
	
	public HomePage() {
		super(HomePage.class.getSimpleName());
	}

	public void launchWebsite() {
		launchUrl(URL);
		
	}

	public void hoverOverWomenTab() throws Exception {
		hoverToElement("btn_women");
	}

	public void clickOnSummerDressBtn() throws Exception {
		hoverToElementAndClick("btn_summerdress");
	}

}