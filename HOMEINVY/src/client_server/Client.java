package client_server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import items.Item;

public class Client {
	public static void main(String[] args) {
		/* INTENT: Allows multiple client connections to the server to run
		* application in multi-user, networked environment.
		* 
		* PRECONDITION 1: Server.java has been started and socket has been
		* created.
		* 
		* POSTCONDITION 1: Connect to Server via socket - currently set to
		* use localhost and port 9000.
		* POST 2: Object instance for Inventory created for the specific socket
		* connected.
		* POST 3: ArrayList theItems created containing contents of InventoryFile.txt
		* POST 4: Object instance for UserNavigation created for specific socket
		* connected.
		* POST 5: User Navigation started for this specific socket. 
		*/
	    try {
	    	// String for location of Inventory.txt
			String INVENTORY_FILE = "client_server/InventoryFile.txt";
			
			// ArrayList for all items created from the file
			ArrayList<Item> theItems = new ArrayList<Item>();
			
			// POST1: Connect via socket to Server
			new Socket("localhost", 9000);
			
			// POST2: Create new Inventory object to run Inventory read methods
			Inventory myInventory = new Inventory();
			// POST3: ArrayList theItems now has info from InventoryFile.txt
			theItems = myInventory.readInventory(INVENTORY_FILE);

			// POST4: Create new UserNavigation object and the user interface and logic
			UserNavigation myNavigation = new UserNavigation();
			// POST5: Run user navigation
			myNavigation.mainMenu(theItems, myInventory);
	     }
	    catch (InsufficientItemDataException e) {
	    	e.printStackTrace();
		}     
	     catch (IOException excep) {
	        excep.printStackTrace();
	     }     
	}
}

