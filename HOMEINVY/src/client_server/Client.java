package client_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import items.Item;


public class Client {
	public static void main(String[] args) {
		// 
	    try {
	    	// String for location of Inventory.txt
			String INVENTORY_FILE = "src/client_server/InventoryFile.txt";
			
			// ArrayList for all items created from the file
			ArrayList<Item> theItems = new ArrayList<Item>();
			
			new Socket("localhost", 9000);
			
			// Create new Inventory object to run Inventory read methods
			Inventory myInventory = new Inventory();
			theItems = myInventory.readInventory(INVENTORY_FILE);

			// Start the user interface and logic
			UserNavigation.mainMenu(theItems);
	     }
	    catch (InsufficientItemDataException e) {
	    	e.printStackTrace();
		}     
	     catch (IOException excep) {
	        excep.printStackTrace();
	     } 
	    
	}
}

