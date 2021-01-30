package items;

public class PowerTool extends Tool {
	// INTENT: Extend properties of Tool class, create PowerTool objects and return extra 
	// properties for display.
	
	private String powerType;
	
	// Constructor
	public PowerTool(String name, String location, String purchaseYear, String condition, String brand, String powerType) {
		super(name, location, purchaseYear, condition, brand);
		this.powerType = powerType;
	}

	// Getter
	public String getPowerType() {return powerType;}

	// Setter
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}
	
	@Override
	public String toString() {
		/* INTENT: Override Tool toString(), calls that method and adds extra
		 * properties of Tool to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional PowerTool properties. All properties returned in a format ready
		 * to display neatly. Item, Tool and PowerTool properties returned.
		 */
		return String.format("%s\n" +
							"SUBCATEGORY: Power Tool\n" +
							"POWER TYPE: %s",
							super.toString(), getPowerType());
	}
	
}
