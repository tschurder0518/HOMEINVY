package items;

public class Computer extends Electronic {
	// INTENT: Extend properties of Electronic class, create Computer objects and return extra 
	// properties for display.
	
	private String processor;
	private String memory;
	
	// Constructor
	public Computer(String name, String location, String purchaseYear, String condition, String brand, String model,
			String warranty, String processor, String memory) {
		super(name, location, purchaseYear, condition, brand, model, warranty);
		this.processor = processor;
		this.memory = memory;
	}

	// Getters
	public String getProcessor() {return processor;}
	public String getMemory() {return memory;}
	
	// Setters
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	@Override
	public String toString() {
		/* INTENT: Override Electronic toString(), calls that method and adds extra
		 * properties of Computer to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional Computer properties. All properties returned in a format ready
		 * to display neatly.
		 */
		return String.format("%s\n" +
							"SUBCATEGORY: Computer\n" +
							"PROCESSOR: %s\n" +
							"MEMORY: %s",
							super.toString(), getProcessor(), getMemory());
	}
}
