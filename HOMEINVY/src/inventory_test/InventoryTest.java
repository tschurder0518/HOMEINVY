package inventory_test;

import static org.junit.Assert.*;
import org.junit.Test;
import items.Item;
import items.PowerTool;
import items.HandTool;
import items.Television;
import items.Computer;
import items.SoftCopy;
import items.HardCopy;
import java.util.ArrayList;
import inventory.Inventory;

public class InventoryTest {

	@Test
	public void testPowerTool() {
		// Test creating PowerTool object
		PowerTool item = new PowerTool("Nail Gun", "Garage", "2012", "Poor", "DeWALT", "Battery");
		
		// Test getters
		assertEquals("Nail Gun", item.getName());
		assertEquals("Garage", item.getLocation());
		assertEquals("2012", item.getPurchaseYear());
		assertEquals("Poor", item.getCondition());
		assertEquals("DeWALT", item.getBrand());
		assertEquals("Battery", item.getPowerType());
		
		// Test setters
		item.setName("Pneumatic Nail Gun");
		assertEquals("Pneumatic Nail Gun", item.getName());
		item.setLocation("Shed");
		assertEquals("Shed", item.getLocation());
		item.setCondition("Good");
		assertEquals("Good", item.getCondition());
		item.setPurchaseYear("2021");
		assertEquals("2021", item.getPurchaseYear());
		item.setBrand("Milwaukee");
		assertEquals("Milwaukee", item.getBrand());
		item.setPowerType("Electric");
		assertEquals("Electric", item.getPowerType());
	}
	
	@Test
	public void testHandTool() {
		// Test creating HandTool object
		HandTool item2 = new HandTool("Wood Chopping Axe", "Shed", "2020", "Good", "Stanley", "8 Pound");
		
		// Test getters
		assertEquals("Wood Chopping Axe", item2.getName());
		assertEquals("Shed", item2.getLocation());
		assertEquals("2020", item2.getPurchaseYear());
		assertEquals("Good", item2.getCondition());
		assertEquals("Stanley", item2.getBrand());
		assertEquals("8 Pound", item2.getSize());
		
		// Test setters
		item2.setName("Large Wood Chopping Axe");
		assertEquals("Large Wood Chopping Axe", item2.getName());
		item2.setLocation("Garage");
		assertEquals("Garage", item2.getLocation());
		item2.setCondition("Moderate");
		assertEquals("Moderate", item2.getCondition());
		item2.setPurchaseYear("2021");
		assertEquals("2021", item2.getPurchaseYear());
		item2.setBrand("Estwing");
		assertEquals("Estwing", item2.getBrand());
		item2.setSize("12 Pound");
		assertEquals("12 Pound", item2.getSize());
	}
	
	@Test
	public void testComputer() {
		// Test creating Computer object
		Computer item3 = new Computer("Tess Laptop", "Mobile", "2018", "Good", "Lenovo", "Yoga 720", "No", "i5", "8 GB");
		
		// Test getters
		assertEquals("Tess Laptop", item3.getName());
		assertEquals("Mobile", item3.getLocation());
		assertEquals("2018", item3.getPurchaseYear());
		assertEquals("Good", item3.getCondition());
		assertEquals("Lenovo", item3.getBrand());
		assertEquals("Yoga 720", item3.getModel());
		assertEquals("No", item3.getWarranty());
		assertEquals("i5", item3.getProcessor());
		assertEquals("8 GB", item3.getMemory());
		
		// Test setters
		item3.setName("Tess New Laptop");
		assertEquals("Tess New Laptop", item3.getName());
		item3.setLocation("Study");
		assertEquals("Study", item3.getLocation());
		item3.setCondition("Excellent");
		assertEquals("Excellent", item3.getCondition());
		item3.setPurchaseYear("2021");
		assertEquals("2021", item3.getPurchaseYear());
		item3.setBrand("HP");
		assertEquals("HP", item3.getBrand());
		item3.setModel("Envy");
		assertEquals("Envy", item3.getModel());
		item3.setWarranty("Yes");
		assertEquals("Yes", item3.getWarranty());
		item3.setProcessor("i7");
		assertEquals("i7", item3.getProcessor());
		item3.setMemory("16 GB");
		assertEquals("16 GB", item3.getMemory());
	}
	
	@Test
	public void testTelevision() {
		// Test creating Television object
		Television item4 = new Television("Basement TV", "Basement", "2019", "Good", "Samsung", "QLED", "No", "Yes", "65 inch");
		
		// Test getters
		assertEquals("Basement TV", item4.getName());
		assertEquals("Basement", item4.getLocation());
		assertEquals("2019", item4.getPurchaseYear());
		assertEquals("Good", item4.getCondition());
		assertEquals("Samsung", item4.getBrand());
		assertEquals("QLED", item4.getModel());
		assertEquals("No", item4.getWarranty());
		assertEquals("Yes", item4.getSmart());
		assertEquals("65 inch", item4.getSize());
		
		// Test setters
		item4.setName("Basement New TV");
		assertEquals("Basement New TV", item4.getName());
		item4.setLocation("Basement Room 2");
		assertEquals("BasemInent Room 2", item4.getLocation());
		item4.setCondition("Excellent");
		assertEquals("Excellent", item4.getCondition());
		item4.setPurchaseYear("2021");
		assertEquals("2021", item4.getPurchaseYear());
		item4.setBrand("LG");
		assertEquals("LG", item4.getBrand());
		item4.setModel("4K");
		assertEquals("4K", item4.getModel());
		item4.setWarranty("Yes");
		assertEquals("Yes", item4.getWarranty());
		item4.setSmart("No");
		assertEquals("No", item4.getSmart());
		item4.setSize("45 Inch");
		assertEquals("45 Inch", item4.getSize());
	}
	
	@Test
	public void testHardCopy() {
		// Test creating HandCopy object
		HardCopy item5 = new HardCopy("Harry Potter and the Sorcerer's Stone", "Study", "2002", "Good", "JK Rowling", 
				"Fantasty Fiction Children", "Yes Harry Potter", "Left");
		
		// Test getters
		assertEquals("Harry Potter and the Sorcerer's Stone", item5.getName());
		assertEquals("Study", item5.getLocation());
		assertEquals("2002", item5.getPurchaseYear());
		assertEquals("Good", item5.getCondition());
		assertEquals("JK Rowling", item5.getAuthor());
		assertEquals("Fantasty Fiction Children", item5.getGenre());
		assertEquals("Yes Harry Potter", item5.getSeries());
		assertEquals("Left", item5.getBookshelf());
		
		// Test setters
		item5.setName("Harry Potter and the Sorcerer's Stone Picture Edition");
		assertEquals("Harry Potter and the Sorcerer's Stone Picture Edition", item5.getName());
		item5.setLocation("Kids room");
		assertEquals("Kids room", item5.getLocation());
		item5.setCondition("Moderate");
		assertEquals("Moderate", item5.getCondition());
		item5.setPurchaseYear("2021");
		assertEquals("2021", item5.getPurchaseYear());
		item5.setAuthor("J.K. Rowling");
		assertEquals("J.K. Rowling", item5.getAuthor());
		item5.setGenre("Fantasy Fiction Children Picture");
		assertEquals("Fantasy Fiction Children Picture", item5.getGenre());
		item5.setSeries("Yes Harry Potter Picture Series");
		assertEquals("Yes Harry Potter Picture Series", item5.getSeries());
		item5.setBookshelf("Nightstand");
		assertEquals("Nightstand", item5.getBookshelf());
	}
	
	@Test
	public void testSoftCopy() {
		// Test creating SoftCopy object
		SoftCopy item6 = new SoftCopy("The Cuckoo's Egg", "Mobile devices", "2019", "Good", "Clifford Stoll", 
				"Non-Fiction Technology Education", "No", "Yes", "No");
		
		// Test getters
		assertEquals("The Cuckoo's Egg", item6.getName());
		assertEquals("Mobile devices", item6.getLocation());
		assertEquals("2019", item6.getPurchaseYear());
		assertEquals("Good", item6.getCondition());
		assertEquals("Clifford Stoll", item6.getAuthor());
		assertEquals("Non-Fiction Technology Education", item6.getGenre());
		assertEquals("No", item6.getSeries());
		assertEquals("Yes", item6.getKindle());
		assertEquals("No", item6.getAudible());
		
		// Test setters
		item6.setName("The Cuckoo's Egg Audiobook");
		assertEquals("The Cuckoo's Egg Audiobook", item6.getName());
		item6.setLocation("iPod");
		assertEquals("iPod", item6.getLocation());
		item6.setCondition("Moderate");
		assertEquals("Moderate", item6.getCondition());
		item6.setPurchaseYear("2021");
		assertEquals("2021", item6.getPurchaseYear());
		item6.setAuthor("Clifford Stoll voice by Zach Hoffman");
		assertEquals("Clifford Stoll voice by Zach Hoffman", item6.getAuthor());
		item6.setGenre("Non-Fiction Technology Education Voice");
		assertEquals("Non-Fiction Technology Education Voice", item6.getGenre());
		item6.setSeries("Yes voice series by Zach Hoffman");
		assertEquals("Yes voice series by Zach Hoffman", item6.getSeries());
		item6.setKindle("No");
		assertEquals("No", item6.getKindle());
		item6.setAudible("Yes");
		assertEquals("Yes", item6.getAudible());
	}
	
	@Test
	public void testReadInventory() {
		// Testing reading of file, creation of array list of object from file contents, and correct information
		// in objects in the array list of objects by selecting 2 random objects to confirm information
		
		String INVENTORY_FILE = "src/inventory/InventoryFile.txt";
		ArrayList<Item> theItems = new ArrayList<Item>();
		
		 try {
			 theItems = Inventory.readInventory(INVENTORY_FILE);
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 
		 // Testing first item of object list
		 PowerTool itemTest1 = (PowerTool) theItems.get(0); // Downcasting type to PowerTool to test attributes
		 assertEquals("Paint Sprayer",itemTest1.getName());
		 assertEquals("Garage", itemTest1.getLocation());
		 assertEquals("2014", itemTest1.getPurchaseYear());
		 assertEquals("Moderate", itemTest1.getCondition());
		 assertEquals("DeWALT", itemTest1.getBrand());
		 assertEquals("Electric plug in", itemTest1.getPowerType());
		 
		 // Testing random another object from object list
		 SoftCopy itemTest2 = (SoftCopy) theItems.get(5); // Downcasting type to SoftCopy to test attributes
			assertEquals("The Cuckoo's Egg", itemTest2.getName());
			assertEquals("Mobile devices", itemTest2.getLocation());
			assertEquals("2019", itemTest2.getPurchaseYear());
			assertEquals("Good", itemTest2.getCondition());
			assertEquals("Clifford Stoll", itemTest2.getAuthor());
			assertEquals("Non-fiction Technology Education", itemTest2.getGenre());
			assertEquals("No", itemTest2.getSeries());
			assertEquals("Yes", itemTest2.getKindle());
			assertEquals("No", itemTest2.getAudible());
	}
}
