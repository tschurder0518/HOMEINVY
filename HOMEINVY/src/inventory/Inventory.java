package inventory;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import items.Item;
import items.PowerTool;
import items.HandTool;
import items.Television;
import items.Computer;
import items.SoftCopy;
import items.HardCopy;
import user_navigation.UserNavigation;
import java.util.stream.Collectors;

public class Inventory {
	/* INTENT: This class creates the inventory of items. It reads
	 * and parses a .txt file and uses the information to create Item 
	 * objects for each item in the inventory file. 
	 * 
	 * See main() for more information.
	 */

	// CONSTANT for file name
	static String INVENTORY_FILE = "src/inventory/InventoryFile.txt";
	
	// CONSTANT for all items created from the file
	public static ArrayList<Item> theItems = new ArrayList<Item>();
	
	public static ArrayList<Item> readInventory(String INVENTORY_FILE) throws IOException,
			InsufficientItemDataException {
		// Create new Scanner object for the inventory file, read each line
		// Post1 - read file contents
		try(Scanner input = new Scanner(Paths.get(INVENTORY_FILE))) {
			
			// Check if there is another line of input in the file
			while (input.hasNextLine()) {
				String str = input.nextLine();		
				parseData(str); // Method to split information by comma
			}	
		}
		
		// Catch exceptions from importing/reading the file
		catch(IOException e) {
			 System.out.println("File import exception.");
		}
		// Catch exception for missing elements, so blanks (lacking comma to separate items in line) in file
		catch(NoSuchElementException e) {
			throw new InsufficientItemDataException();															
		}
		return theItems;
	} // End readInventory() method
	
	private static ArrayList<Item> parseData(String str) throws InsufficientItemDataException {
		// Parse through information and create objects - Post2 and Post3
		String category, name, location, purchaseYear, condition, att1, att2, att3, att4, att5;
		Scanner lineScanner = new Scanner(str);
		lineScanner.useDelimiter(","); // Split line using , as delimiter to separate each attribute
		while(lineScanner.hasNext()) {
			// Grab each individual attribute on the line and assign to variable for adding to Item objects - Post2
			category = lineScanner.next();
			name = lineScanner.next();
			location = lineScanner.next();
			purchaseYear = lineScanner.next();
			condition = lineScanner.next();
			att1 = lineScanner.next();
			att2 = lineScanner.next();
			att3 = lineScanner.next();
			att4 = lineScanner.next();
			att5 = lineScanner.next();
			
			// Check value of category, based on value call constructor for that Item type to create item, then add
			// to ArrayList of items
			// Post3
			if (category.equals("Power Tool")) {
				Item item = new PowerTool(name, location, purchaseYear, condition, att1, att2);
				theItems.add(item);
			}
			else if (category.equals("Hand Tool")) {
				Item item = new HandTool(name, location, purchaseYear, condition, att1, att2);
				theItems.add(item);
			}
			else if (category.equals("Computer")) {
				Item item = new Computer(name, location, purchaseYear, condition, att1, att2, att3, att4, att5);
				theItems.add(item);
			}
			else if (category.equals("Television")) {
				Item item = new Television(name, location, purchaseYear, condition, att1, att2, att3, att4, att5);
				theItems.add(item);
			}
			else if (category.equals("Hard Copy")) {
				Item item = new HardCopy(name, location, purchaseYear, condition, att1, att2, att3, att4);
				theItems.add(item);
			}
			else if (category.equals("Soft Copy")) {
				Item item = new SoftCopy(name, location, purchaseYear, condition, att1, att2, att3, att4, att5);
				theItems.add(item);
			}
		} // End of while block
		lineScanner.close();
		return theItems;
	} // End of parseData() method
	
	public static ArrayList<Item> getTools(ArrayList<Item> theItems) {
		// Post4
		// Use stream and lamdbas to filter Items of HandTool and PowerTool (tool)
		// types and add to new ArrayList tools
		ArrayList<Item> tools = theItems
			.stream()
			.filter(b -> b instanceof HandTool || b instanceof PowerTool)
			.collect(Collectors.toCollection(ArrayList::new));
		
		return tools;
	} // End of getTools() method
	
	public static ArrayList<Item> getElectronics(ArrayList<Item> theItems) {
		// Post5
		// Use stream and lamdbas to filter Items of Computer and Television (electronic)
		// types and add to new ArrayList electronics
		ArrayList<Item> electronics = theItems
			.stream()
			.filter(b -> b instanceof Computer || b instanceof Television)
			.collect(Collectors.toCollection(ArrayList::new));	
		
		return electronics;
	} // End of getElectronics() method
	
	public static ArrayList<Item> getBooks(ArrayList<Item> theItems) {
		// Post6
		// Use stream and lamdbas to filter Items of HardCopy and SoftCopy (book)
		// types and add to new ArrayList books
		ArrayList<Item> books = theItems
				.stream()
				.filter(b -> b instanceof HardCopy || b instanceof SoftCopy)
				.collect(Collectors.toCollection(ArrayList::new));
		
		return books;
	} // End of getBooks() method
	
	public static void displayAll(ArrayList<Item> theItems) {
		// Post7
		System.out.println("      ***** Displaying " + theItems.size() + " items *****        ");
		// Create Stream object of ArrayList theItems
		// Iterate through each element of the Stream and print
		theItems
			.stream()
			.forEach(i -> System.out.println(i + "\n============================================="));
	} // End of displayAll() method
	
		
	 public static void main(String[] args) {
		/* Precondition 1: InventoryFile.txt contains the desired items to go into inventory.
		 * The formating is as in a CSV, each item is in a new line, each property for items is
		 * separated by a comma. Each line must contain 10 commas, including extra commas if
		 * item has fewer than 9 attributes.
		 * 
		 * Postcondition 1 (Import): Importing file using readInventory() method.
		 * Post2 (Parse Data): Contents of each line assigned to temporary variables for each item
		 * in file.
		 * Post3 (Create objects): Each line of information in file is used to create objects, which
		 * are then added to ArrayList.
		 * Post4 (Get Tools): Search for items of type PowerTool or HandTool and add to new ArrayList
		 * to be displayed.
		 * Post5 (Get Electronics): Search for items of type Computer and Television and add to new
		 * ArrayList to be displayed.
		 * Post6 (Get Books): Search for items of type HardCopy and SoftCopy and add to new ArrayList
		 * to be displayed.
		 * Post7 (Display): The items are displayed on the console.
		 */		
		 
		 // Create inventory from file
		 try {
			 theItems = readInventory(INVENTORY_FILE);
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 
		// Provide user navigation to select what to do with inventory
		UserNavigation.mainMenu(theItems);

	 }
}