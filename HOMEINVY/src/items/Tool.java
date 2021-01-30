package items;

public abstract class Tool extends Item {
	// INTENT: Extend properties of Item class and return extra properties for display.

	private String brand;
	
	// Constructor
	public Tool(String name, String location, String purchaseYear, String condition, String brand) {
		super(name, location, purchaseYear, condition);
		this.brand = brand;
	}
	
	// Getters
	public String getBrand() {return brand;}

	// Setters
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		/* INTENT: Override Item toString(), calls that method and adds extra
		 * properties of Tool to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional Tool properties. All properties returned in a format ready
		 * to display neatly.
		 */
		return String.format("CATEGORY: Tool\n" +
							"%s\n" +
							"BRAND: %s",
							super.toString(), getBrand());
	}
}
