package edu.westga.cs1302.lab2.tests.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;
import edu.westga.cs1302.lab2.view.BillView;

class TestBillViewGetText {

	@Test
	void testGetText() {
		Bill bill = new Bill();
		BillItem cheese = new BillItem("Cheese", 1.00);
		bill.addItem(cheese);
		BillView view = new BillView();
		assertEquals("ITEMS\r\n"
				+ "Cheese - 1.0\r\n"
				+ "\r\n"
				+ "SUBTOTAL - $1.0\r\n"
				+ "TAX - $0.1\r\n"
				+ "TIP - $0.2\r\n"
				+ "TOTAL - $1.3", view.getText(bill), "Checking that the text is returned exactly as expected.");
	}

}
