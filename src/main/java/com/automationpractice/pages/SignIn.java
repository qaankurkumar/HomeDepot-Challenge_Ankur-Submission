package com.automationpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.automationpractice.utils.WebPageActions;

public class SignIn extends WebPageActions {
	

	Logger log = LogManager.getLogger(SignIn.class.getSimpleName());
	
	public SignIn() {
		super(SignIn.class.getSimpleName());
	}

	public void enterEmailAddress(String value) throws Exception{
		enterValueInTextField("tbx_emailaddress", value);
	}
	
	public void clickOnCreateAnAccountBtn() throws Exception {
		clickOnElement("btn_createaccount");
	}
	
	
}
