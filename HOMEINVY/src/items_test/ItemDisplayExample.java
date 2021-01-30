package items_test;

import items.Item;
import items.PowerTool;
import items.HandTool;
import items.Television;
import items.Computer;
import items.SoftCopy;
import items.HardCopy;
import java.util.ArrayList;

public class ItemDisplayExample {
	/* INTENT: Test functionality of the program to this point, demonstrating
	 * creation of all object types.
	 * 
	 * PRECONDITION: Classes for Book, Computer, Electronic, HandTool,
	 * HardCopy, Item, PowerTool, SoftCopy, Television, and Tool have been
	 * created.
	 * 
	 * POSTCONDITION 1: theItems is an ArrayList populated with various
	 * different items of different types.
	 * 
	 * POSTCONDITION 2: All items added to theItems is displayed to the 
	 * console.
	 */
	
	public static ArrayList<Item> theItems = new ArrayList<Item>();
	
	public static void displayAllItems() {		
		// Create Item of each concrete type
		Item item1 = new PowerTool("Paint Sprayer", "Garage", "2014", "Moderate", "DeWALT", "Electric plug in");
		theItems.add(item1); // Post 1
		Item item2 = new HandTool("Wood Chopping Axe", "Shed", "2021", "Good", "Stanley", "8 Pound");
		theItems.add(item2); // Post 1
		Item item3 = new Television("Basement TV", "Basement", "2019", "Good", "Samsumg", "QLED", "No", "Yes", "65 inch");
		theItems.add(item3); // Post 1
		Item item4 = new Computer("Tess Laptop", "Mobile", "2018", "Good", "Lenovo", "Yoga 720", "No", "i5", "8 GB");
		theItems.add(item4); // Post 1
		Item item5 = new HardCopy("Harry Potter and the Sorcerer's Stone", "Study", "2002", "Good", "JK Rowling", 
								"Fantasty, Fiction, Children", "Yes, Harry Potter", "Left");
		theItems.add(item5); // Post 1
		Item item6 = new SoftCopy("The Cuckoo's Egg", "Mobile devices", "2019", "Good", "Clifford Stoll", 
				"Non-Fiction, Technology, Education", "No", "Yes", "No");
		theItems.add(item6); // Post 1
		
		// Post 2
		// Iterate through each item of ArrayList and display information for each item based on item type
		String text1 = "";
		System.out.println("***** Should display " + theItems.size() + " items *****");
		// Iterate through each element of Item type
		// Determine the instance of each element and print based on that info
		for (Item elem: theItems) {
			System.out.println("=============================================");
			if (elem != null) {
				System.out.println(elem);
			}
		} // End of for loop	
	} // End of displayAllItems method
	
	
	public static void main(String[] args) {
		System.out.println("***** ALL ITEMS IN INVENTORY *****");
		displayAllItems();
				
	}
}
