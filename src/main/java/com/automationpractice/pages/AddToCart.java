package com.automationpractice.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.automationpractice.utils.WebPageActions;

public class AddToCart extends WebPageActions {
	
	Logger log = LogManager.getLogger(AddToCart.class.getSimpleName());
	
	public AddToCart() {
		super(AddToCart.class.getSimpleName());
	}
	
	public String fetchQty(String value) throws Exception {
		switchToFrame();
		String orderQty = GetAttibuteForElement("lbl_qty", value);
		return orderQty;
	}
	
	public String fetchDressName() throws Exception {
		String dressName = getTextForElement("lbl_dressname");
		return dressName;
	}
	
	public void clickOnSize() throws Exception {
		clickOnElement("clk_size");
	}
	
	public String selectFromDropDown(String value) throws Exception {
		selectSize("ddl_size", value);
		return value;
	}	
	
	public void clickOnAddToCart() throws Exception {
		clickOnElement("clk_addtocart");
	}
	
	
	
	
}
