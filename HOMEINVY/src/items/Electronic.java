package items;

public abstract class Electronic extends Item {
	// INTENT: Extend properties of Item class and return extra properties for display.
	private String brand;
	private String model;
	private String warranty;
	
	// Constructor
	public Electronic(String name, String location, String purchaseYear, String condition, String brand, String model,
						String warranty) {
		super(name, location, purchaseYear, condition);
		this.brand = brand;
		this.model = model;
		this.warranty = warranty;
	}

	// Getters
	public String getBrand() {return brand;}
	public String getModel() {return model;}
	public String getWarranty() {return warranty;}
	
	// Setters
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		/* INTENT: Override Item toString(), calls that method and adds extra
		 * properties of Tool to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional Electronic properties. All properties returned in a format ready
		 * to display neatly.
		 */
		return String.format("CATEGORY: Electronic\n" +
							"%s\n" +
							"BRAND: %s\n" +
							"MODEL: %s\n" +
							"WARRANTY: %s",
							super.toString(), getBrand(), getModel(), getWarranty());
	}
}
