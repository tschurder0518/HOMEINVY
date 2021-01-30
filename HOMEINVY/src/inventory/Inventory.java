package inventory;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;	
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class Inventory {

	// CONSTANT
	static String INVENTORY_FILE = "src/inventory/InventoryFile.csv";
	
	public static void readInventory(String INVENTORY_FILE) {
		// Create new Scanner object for the inventory file, read each line
		try(Scanner input = new Scanner(Paths.get(INVENTORY_FILE))) {
			
			// Check if there is another line of input in the file
			while (input.hasNextLine()) {
				String str = input.nextLine();		
				//System.out.println(str); // Line for testing ** REMOVE **
				parseData(str);
			}
			
		}
		
		catch(IOException e) {
			 System.out.println("File import exception.");
		}
		catch(NoSuchElementException e) {
			System.out.println("Missing an element exception");
		}	
	}
	
	private static void parseData(String str) {
		String category, name, location, purchaseYear, condition, att1, att2, att3, att4, att5;
		Scanner lineScanner = new Scanner(str);
		lineScanner.useDelimiter(",");
		while(lineScanner.hasNext()) {
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
			System.out.println("Category: " + category + "\nName: " + name + "\nLocation: " + location + 
								"\nPurchase Year: " + purchaseYear + "\nCondition: " + condition + "\nAtt1: " +
								att1 + "\nAtt2: " + att2 + "\nAtt3: " + att3 + "\nAtt4: " + att4 + "\nAtt5: " + att5);
			System.out.println("=============================================");
		}
		lineScanner.close();
	}
	
	
	
	
	
	 public static void main(String[] args) {
		 try {
			 readInventory(INVENTORY_FILE);
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }	

	 }

}