
package edu.westga.cs1302.lab1.view;

import edu.westga.cs1302.lab1.model.BillItem;
import edu.westga.cs1302.lab1.model.Bill;

/** Contains a method to display the Bill including item names and prices, and totals.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class DisplayBill {
	public static final double TIP_PERCENTAGE = 0.2;
	public static final double TAX_PERCENTAGE = 0.1;

	/** Return a String containing the list of bill items, sub-total, tax, tip, and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill The bill in question.
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (BillItem item : bill.getBillItems()) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
			subTotal += item.getAmount();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
		double tax = subTotal * TAX_PERCENTAGE;
		double tip = subTotal * TIP_PERCENTAGE;
		text += "TAX - $" + tax + System.lineSeparator();
		text += "TIP - $" + tip + System.lineSeparator();
		text += "TOTAL - $" + (subTotal + tip + tax);
		
		return text;
		
	}
}
