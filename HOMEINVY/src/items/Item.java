package items;

public abstract class Item {
	// INTENT: Provide properties for items in a home, such as a tool, book
	// or electronic device. Act as parent class for multiple sub-classes.
	
	private String name;
	private String location;
	private String purchaseYear;
	private String condition;

	
	// Constructor
	public Item(String name, String location, String purchaseYear, String condition) {
		this.name = name;
		this.location = location;
		this.purchaseYear = purchaseYear;
		this.condition = condition;
	}
	
	// Getters
	public String getName() {return name;}
	public String getLocation() {return location;}
	public String getPurchaseYear() {return purchaseYear;}
	public String getCondition() {return condition;}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setPurchaseYear(String purchaseYear) {
		this.purchaseYear = purchaseYear;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		/* INTENT: Return String representation of Item for displaying all item properties.
		 * 
		 * POSTCONDITION 1: All properties returned in a format ready
		 * to display neatly.
		 */
		return String.format("NAME: %s\n"
						   + "LOCATION: %s\n"
						   + "PURCHASE YEAR: %s\n"
						   + "CONDITION: %s",
						   name, location, purchaseYear, condition);
	}
}