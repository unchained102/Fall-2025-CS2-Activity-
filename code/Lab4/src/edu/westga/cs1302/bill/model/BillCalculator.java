package edu.westga.cs1302.bill.model;

/**
 * Contains static methods to calculate sub-total, tax, tip, and total of a bill.
 * 
 * @author everetttdewberry@gmail.com
 * @version 1.0
 */
public class BillCalculator {
	
	/**
	 * Calculates and returns the sub-total for an array of BillItems.
	 * 
	 * @param items the list of BillItems to be summed
	 * @return subTotal the sub-total of the bill
	 */
	public static double calcSubtotal(BillItem[] items) {
		for (int index = 0; index < items.length; index++) {
			if (items[index] == null) {
				throw new IllegalArgumentException("None of the BillItems in the array can be null.");
			}
		}
		double subTotal = 0;
		for (int index = 0; index < items.length; index++) {
			subTotal += items[index].getAmount();
		}
		
		return subTotal;
	}
}
