package com.automationpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.automationpractice.utils.WebPageActions;

public class Payment extends WebPageActions {
	
Logger log = LogManager.getLogger(Payment.class.getSimpleName());
	
	public Payment() {
		super(Payment.class.getSimpleName());
	}

	public void fetchDressName(String orderedDressName) throws Exception {
		String dressName = getTextForElement("lbl_name");
		Assert.assertEquals(orderedDressName, dressName);
		log.info("Assert Passed: The dress name is same as ordered");
	}
	
	public void fetchQtyNumber(String orderedQty) throws Exception {
		String qtyNumber = getTextForElement("lbl_qty");
		Assert.assertEquals(orderedQty,qtyNumber);
		log.info("Assert Passed: The dress quantity is same as ordered");
	}
	
	
	
	
	

}
