package edu.westga.cs1302.lab2.tests.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestAddItem {

	@Test
	void testWhenItemIsNull() {
		Bill bill = new Bill();
		assertThrows(IllegalArgumentException.class, () -> {
				bill.addItem(null);
		});
	}
	
	@Test
	void testWhenItemIsValid() {
		Bill bill = new Bill();
		BillItem item = new BillItem("Cheese", 1.00);
		
		bill.addItem(item);
		
		for (BillItem testItem: bill.getItems()) {
			assertEquals(testItem.getName(), "Cheese");
			assertEquals(testItem.getAmount(), 1.00, 0.001);
		}
	}

}
