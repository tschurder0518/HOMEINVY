package items;

public class Television extends Electronic {
	// INTENT: Extend properties of Electronic class, create Television objects and return extra 
	// properties for display.
	
	private String smart;
	private String size;
	
	// Constructor
	public Television(String name, String location, String purchaseYear, String condition, String brand, String model,
			String warranty, String smart, String size) {
		super(name, location, purchaseYear, condition, brand, model, warranty);
		this.smart = smart;
		this.size = size;
	}

	// Getters
	public String getSmart() {return smart;}
	public String getSize() {return size;}

	// Setters
	public void setSmart(String smart) {
		this.smart = smart;
	}
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		/* INTENT: Override Electronic toString(), calls that method and adds extra
		 * properties of Television to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional Television properties. All properties returned in a format ready
		 * to display neatly.
		 */
		return String.format("%s\n" +
							"SUBCATEGORY: Television\n" +
							"SMART: %s\n" +
							"SIZE: %s",
							super.toString(), getSmart(), getSize());
	}
}
