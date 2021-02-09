package user_navigation;

import java.util.ArrayList;
import java.util.Scanner;
import inventory.Inventory;
import items.Item;
import reports.Reports;

public class UserNavigation {
	/* INTENT: Provide menus output to user to navigate through the program and perform
	 * specific actions on the data in inventory based on user selections.
	 * 
	 * Precondition 1: Inventory must have been successfully imported from file and added
	 * to ArrayList to successfully perform actions in the various methods of this class.
	 * 
	 * Postcondition 1 (Display main menu): Display the main menu options to the user.
	 * Post2 (Prompt for input): Prompt user for input to select an option in main menu.
	 * Post3 (Act on input): Perform action based on user input. Proceed to another menu,
	 * exit, or provide error if no correct entry selected.
	 * Post4 (Display sub menu): Display sub-menu View Items to the user.
	 * Post5 (Act on input from sub menus): Perform action based on user input in sub menu.
	 * Post6 (Pass data to be parsed): Pass data to be narrowed down for viewing to the
	 * Inventory class.
	 * Post7 (Pass data to be displayed): Pass data to be displayed on the console to the
	 * Inventory class.
	 * Post8 (Display sub menu): Display sub-menu Reports to the user.
	 * Post9 (Display poor maintenance status): Display all items that need repair or 
	 * maintenance to the console.
	 * Post10 (Display maintenance status of all items): Display the condition of all items,
	 * including special note if status is "Poor".
	 */
	
	public static void mainMenu(ArrayList<Item> theItems) {
		// Post1
		ArrayList<Item> viewItems = new ArrayList<Item>();
		System.out.println("=============================================");
		System.out.println("       HOMEINVY: Your Home Inventory         ");
		System.out.println("=============================================");
		System.out.println("                 MAIN MENU                   ");
		System.out.println("=============================================");
		// Post2
		System.out.println("1. View items\n" +
						   "2. Search for an item\n" +
						   "3. Add an item\n" +
						   "4. Remove an item\n" + 
						   "5. View reports\n" +
						   "6. Exit\n");
		System.out.print("Please enter your selection: ");
		Scanner reader = new Scanner(System.in);
		// Post3
		// Switch to see what input is provided by users, route to correct method based on selection
		// Send error message to console with invalid selection
		switch (reader.next() ) {
			case "1":
				// Send to View items submenu in method viewItemsMenu
				viewItems = viewItemsMenu(theItems);
				reader.close();
				break;
			case "2":
				System.out.println("Search for an item selected. Menu item not implemented yet.\n");
				break;
			case "3":
				System.out.println("Add an item selected. Menu item not implemented yet.\n");
				break;
			case "4":
				System.out.println("Remove an item selected. Menu item not implemented yet.\n");
				break;
			case "5":
				viewReportsMenu(theItems); // Post8 Go to method to display reports sub menu
				break;
			case "6":
				System.out.println("Thanks for using HOMEINVY! Program execution complete.");
				System.exit(0); // Gracefully exit program with normal termination code (0)
			default:
				System.err.println("Invalid option\n"); // Display error to console when invalid entry
		}
		reader.close();
	}
	
	
	public static ArrayList<Item> viewItemsMenu(ArrayList<Item> theItems) {
		// Post4
		// Display submenu for view items and take input from  user on what items to display
		ArrayList<Item> selectedItems = new ArrayList<Item>();
		System.out.println("=============================================");
		System.out.println("                 VIEW ITEMS                  ");
		System.out.println("=============================================");
		System.out.println("1. View all items in inventory\n" +
						   "2. View all tools\n" +
						   "3. View all electronics\n" +
						   "4. View all books\n" + 
						   "5. Exit to main menu\n" +
						   "6. Exit\n");
		System.out.print("Please enter your selection: ");
		Scanner reader = new Scanner(System.in);
		// Switch to see what input is provided by users, route to correct method based on selection
		// Send error message to console with invalid selection
		switch (reader.next() ) {
			case "1":
				// Display all items in the inventory
				System.out.println("     ***** ALL ITEMS IN INVENTORY *****      ");
				Inventory.displayAll(theItems); // Post7
				reader.close();
				return theItems;
			case "2":
				// Display only tools in the inventory
				System.out.println("     ***** ALL TOOLS IN INVENTORY *****       ");
				selectedItems = Inventory.getTools(theItems); // Post6
				break;
			case "3":
				// Display only electronics in inventory
				System.out.println("  ***** ALL ELECTRONICS IN INVENTORY *****    ");
				selectedItems = Inventory.getElectronics(theItems); // Post6
				break;
			case "4":
				// Display only books in inventory
				System.out.println("     ***** ALL BOOKS IN INVENTORY *****        ");
				selectedItems = Inventory.getBooks(theItems); // Post6
				break;
			case "5":
				// Exit back to main menu
				mainMenu(theItems);
			case "6":
				System.out.println("Thanks for using HOMEINVY! Program execution complete.");
				System.exit(0); // Gracefully exit program with normal termination code (0)
			default:
				System.err.println("Invalid option\n");
		}		
		reader.close();

		Inventory.displayAll(selectedItems); // Post 7, pass updated items to be displayed to display method
		return selectedItems;
	}
	
	public static void viewReportsMenu(ArrayList<Item> theItems) {
		// Post 8
		// Display Reports sub menu
		System.out.println("=============================================");
		System.out.println("                  REPORTS                    ");
		System.out.println("=============================================");
		System.out.println("1. View items needing replacement or repair\n" +
						   "2. View maintenance status for all items\n" +
						   "3. Exit to main menu\n" +
						   "4. Exit\n");
		System.out.print("Please enter your selection: ");
		Scanner reader = new Scanner(System.in);
		// Switch to see what input is provided by users, route to correct method based on selection
		// Send error message to console with invalid selection
		switch (reader.next() ) {
			case "1":
				// Display only items needing replacement or repair -- condition == "Poor"
				System.out.println("=============================================");
				System.out.println("***** ITEMS NEEDING REPAIR/REPLACEMENT ***** ");
				System.out.println("=============================================");
				for (Item elem: theItems) {
					Reports.printMaintenanceNeeded(elem);
				}
				reader.close();
				break;
			case "2":
				// Display the condition of all items in the inventory
				System.out.println("=============================================");
				System.out.println("***** MAINTENANCE STATUS FOR ALL ITEMS ***** ");
				System.out.println("=============================================");
				for (Item elem: theItems) {
					Reports.printAllMaintenanceStatus(elem);
				}
				reader.close();
				break;
			case "3":
				// Exit back to main menu
				mainMenu(theItems);
			case "4":
				System.out.println("Thanks for using HOMEINVY! Program execution complete.");
				System.exit(0); // Gracefully exit program with normal termination code (0)
			default:
				System.err.println("Invalid option\n");
		}		
	}
}