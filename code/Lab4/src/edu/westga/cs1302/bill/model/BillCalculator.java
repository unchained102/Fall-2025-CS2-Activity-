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
	 * @param items the array of BillItems
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
	
	/**
	 * Calculates and returns the tax for an array of BillItems.
	 * 
	 * @param items the array of BillItems
	 * @return tax the tax cost of the bill
	 */
	public static double calcTax(BillItem[] items) {
		for (int index = 0; index < items.length; index++) {
			if (items[index] == null) {
				throw new IllegalArgumentException("None of the BillItems in the array can be null.");
			}
		}
		
		double subTotal = BillCalculator.calcSubtotal(items);
		double tax = subTotal * Bill.TAX_RATE;
		return tax;
	}
}
