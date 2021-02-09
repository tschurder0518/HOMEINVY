package reports;

import items.Item;

public class Reports<T> {
	public static <T extends Item> void printMaintenanceNeeded(T t) {
		// INTENT: Allow to print, no matter what type of item, if the condition of the item is "Poor"
		// Postcondition1: Print specific message only for items who have a condition that equals "Poor"
		
		// Post1
		if (t.getCondition().equals("Poor")) {
			System.out.println("The item " + t.getName().toUpperCase() + " needs maintenance or to be replaced.");
		}
	}
	
	public static <T extends Item> void printAllMaintenanceStatus(T t) {
		// INTENT: Allow to print condition of all items, no matter what type of item, adding message if it 
		// needs maintenance or repair
		// Postcondition1: Print item name and condition
		// Post2: Add additional message that the item needs maintenance or repair if the condition equals "Poor"
		
		// Post1
		if (t.getCondition().equals("Poor")) {
			System.out.println(t.getName().toUpperCase() + ": " + t.getCondition() + " --> NEEDS MAINTENANCE OR REPAIR");
		}
		// Post2
		else {
			System.out.println(t.getName().toUpperCase() + ": " + t.getCondition());
		}
	}
}
