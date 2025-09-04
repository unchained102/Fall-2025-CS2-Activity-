package edu.westga.cs1302.lab2.tests.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.BillItem;

class TestBillItemConstructor {

	@Test
	void testWhenNameIsNull() {
		assertThrows(IllegalArgumentException.class, ()-> {
			 new BillItem(null, 1.00);
		});
	}
	
	@Test
	void testWhenAmountIsZero() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new BillItem("Wine", 0);
		});
	}
	
	@Test
	void testWhenAmountIsLessThanZero() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new BillItem("Wine", -1);
		});
	}
	
	@Test
	void testWhenBothParamsValid() {
		BillItem item = new BillItem("Wine", 1.00);
		assertEquals("Wine", item.getName(), "Checking that name returned as expected.");
		assertEquals(1.00, item.getAmount(), 0.001, "Checking that amount returned as expected.");

	}

}
