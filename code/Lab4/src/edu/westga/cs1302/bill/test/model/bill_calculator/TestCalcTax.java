package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestCalcTax {

	@Test
	void testWhenFirstBillItemNull() {
		BillItem item1 = null;
		BillItem item2 = new BillItem("Cheese", 4.99);
		BillItem item3 = new BillItem("Bread", 3.99);
		BillItem[] items = {item1, item2, item3};
		
		assertThrows(IllegalArgumentException.class, ()-> {
			BillCalculator.calcTax(items);
		}, "Asserts that with first item null, IllegalArgumentException is thrown.");
	}
	
	@Test
	void testWhenMiddleBillItemNull() {
		BillItem item1 = new BillItem("Cheese", 4.99);
		BillItem item2 = null;
		BillItem item3 = new BillItem("Bread", 3.99);
		BillItem[] items = {item1, item2, item3};
		
		assertThrows(IllegalArgumentException.class, ()-> {
			BillCalculator.calcTax(items);
		}, "Asserts that with middle item null, IllegalArgumentException is thrown.");
	}
	
	@Test
	void testWhenLastBillItemNull() {
		BillItem item1 = new BillItem("Cheese", 4.99);
		BillItem item2 = new BillItem("Bread", 3.99);
		BillItem item3 = null;
		BillItem[] items = {item1, item2, item3};
		
		assertThrows(IllegalArgumentException.class, ()-> {
			BillCalculator.calcTax(items);
		}, "Asserts that with last item null, IllegalArgumentException is thrown.");
	}

	@Test
	void testWhenOneValidItem() {
		BillItem item1 = new BillItem("Cheese", 4.99);
		BillItem[] items = {item1};
		
		double tax = BillCalculator.calcTax(items);
		double expectedTax = item1.getAmount() * Bill.TAX_RATE;
		
		assertEquals(expectedTax, tax, 0.001, "Asserts that one item returns anticipated value.");
	}
	
	@Test
	void testWhenMultipleValidItems() {
		BillItem item1 = new BillItem("Cheese", 4.99);
		BillItem item2 = new BillItem("Bread", 3.99);
		BillItem item3 = new BillItem("Wine", 19.99);
		BillItem[] items = {item1, item2, item3};
		
		double expectedTax = (item1.getAmount() + item2.getAmount() + item3.getAmount()) * Bill.TAX_RATE;
		double tax = BillCalculator.calcTax(items);
		assertEquals(expectedTax, tax, 0.001, "Asserts that multiple items return anticipated value.");

	}
}
