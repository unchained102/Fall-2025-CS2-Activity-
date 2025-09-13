package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculator;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill the bill to be viewed
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public static String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = BillCalculator.calcSubtotal(bill.getItems().toArray(new BillItem[bill.getItems().size()]));
		double tax = BillCalculator.calcTax(bill.getItems().toArray(new BillItem[bill.getItems().size()]));
		double tip = BillCalculator.calcTip(bill.getItems().toArray(new BillItem[bill.getItems().size()]));
		double total = BillCalculator.calcTotal(bill.getItems().toArray(new BillItem[bill.getItems().size()]));
		for (BillItem item : bill.getItems()) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
		text += "TAX - $" + BillView.roundToNearestHundredth(tax) + System.lineSeparator();
		text += "TIP - $" + BillView.roundToNearestHundredth(tip) + System.lineSeparator();
		text += "TOTAL - $" + BillView.roundToNearestHundredth(total);
		
		return text;
	}
	
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
}
