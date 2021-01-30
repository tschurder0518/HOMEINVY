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

public class Inventory {

	// CONSTANT for file name
	static String INVENTORY_FILE = "src/inventory/InventoryFile.txt";
	
	public static ArrayList<Item> theItems = new ArrayList<Item>();
	
	public static ArrayList readInventory(String INVENTORY_FILE) throws IOException,
			InsufficientItemDataException {
		// Create new Scanner object for the inventory file, read each line
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
	}
	
	private static ArrayList parseData(String str) throws InsufficientItemDataException {
		String category, name, location, purchaseYear, condition, att1, att2, att3, att4, att5;
		Scanner lineScanner = new Scanner(str);
		lineScanner.useDelimiter(","); // Split line using , as delimiter to separate each attribute
		while(lineScanner.hasNext()) {
			// Grab each individual attribute on the line and assign to variable for adding to Item objects
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
	
	
	
	
	
	 public static void main(String[] args) {
		 
		 try {
			 theItems = readInventory(INVENTORY_FILE);
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 
		 
		System.out.println("***** Displaying " + theItems.size() + " items *****");
		// Iterate through each element of Item type
		// Determine the instance of each element and print based on that info
		for (Item elem: theItems) {
			System.out.println("=============================================");
			if (elem != null) {
				System.out.println(elem);
			}
		} // End of for loop	
	 }

}