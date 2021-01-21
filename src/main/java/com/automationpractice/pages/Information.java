package com.automationpractice.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.automationpractice.utils.WebPageActions;

public class Information extends WebPageActions {
	
	Logger log = LogManager.getLogger(Information.class.getSimpleName());
	
	public Information() {
		super(Information.class.getSimpleName());
	}

	public void enterFirstName(String value) throws Exception {
		enterValueInTextField("tbx_firstname", value);
	}
	
	public void enterLastName(String value) throws Exception {
		enterValueInTextField("tbx_lastname", value);
	}
	
	public void enterPassword(String value) throws Exception {
		enterValueInTextField("tbx_password", value);
	}
	
	public void enterAddress(String value) throws Exception {
		enterValueInTextField("tbx_address", value);
	}
	
	public void enterCity(String value) throws Exception {
		enterValueInTextField("tbx_city", value);
	}
	
	public void selectStateFromDropDownMenu(String value) throws Exception {
		clickOnElement("tbx_state");
		List<WebElement> list = findElementsOnWebPage("tbx_statelist", value);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase(value)) {
				list.get(i).click();
				break;
			}
		}
	}
	
	public void enterPostalCode(String value) throws Exception {
		enterValueInTextField("tbx_postalcode", value);
	}
	
	public void enterMobilePhone(String value) throws Exception {
		enterValueInTextField("tbx_mobilenumber", value);
	}
	
	public void enterAddressAlias(String value) throws Exception {
		enterValueInTextField("tbx_alias", value);
	}
	
	public void clickOnRegisterBtn() throws Exception {
		clickOnElement("btn_register");
	}
}
