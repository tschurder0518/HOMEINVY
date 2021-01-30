package items;

public class HandTool extends Tool{
	// INTENT: Extend properties of Tool class, create HandTool objects and return extra 
	// properties for display.
	
	private String size;
	
	// Constructor
	public HandTool(String name, String location, String purchaseYear, String condition, String brand, String size) {
		super(name, location, purchaseYear, condition, brand);
		this.size = size;
	}

	// Getter
	public String getSize() {return size;}

	// Setter
	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		/* INTENT: Override Tool toString(), calls that method and adds extra
		 * properties of Tool to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional HandTool properties. All properties returned in a format ready
		 * to display neatly. Item, Tool and HandTool properties returned.
		 */
		return String.format("%s\n" +
							"SUBCATEGORY: Hand Tool\n" +
							"SIZE: %s",
							super.toString(), getSize());
	}
}
