
package edu.westga.cs1302.lab1.view;

import java.util.ArrayList;
import edu.westga.cs1302.lab1.model.BillItem;

/** Contains a method to display the Bill including item names and prices, and totals.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class DisplayBill {
	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param items The list of BillItems retrieved via getBillItems in the Bill Class.
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText(ArrayList<BillItem> items) {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (BillItem item : items) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
			subTotal += item.getAmount();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
		double tax = subTotal * 0.1;
		double tip = subTotal * 0.2;
		text += "TAX - $" + tax + System.lineSeparator();
		text += "TIP - $" + tip + System.lineSeparator();
		text += "TOTAL - $" + (subTotal + tip + tax);
		
		return text;
	}
}
