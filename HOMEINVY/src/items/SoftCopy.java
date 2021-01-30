package items;

public class SoftCopy extends Book {
	// INTENT: Extend properties of Book class, create SoftCopy objects and return extra 
	// properties for display.
	
	private String kindle;
	private String audible;
	
	// Constructor
	public SoftCopy(String name, String location, String purchaseYear, String condition, String author,
				String genre, String series, String kindle, String audible) {
		super(name, location, purchaseYear, condition, author, genre, series);
		this.kindle = kindle;
		this.audible = audible;
	}

	// Getters
	public String getKindle() {return kindle;}
	public String getAudible() {return audible;}
	
	// Setters
	public void setKindle(String kindle) {
		this.kindle = kindle;
	}
	public void setAudible(String audible) {
		this.audible = audible;
	}
	
	@Override
	public String toString() {
		/* INTENT: Override Book toString(), calls that method and adds extra
		 * properties of SoftCopy to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional SoftCopy properties. All properties returned in a format ready
		 * to display neatly. Item, Book and SoftCopy properties returned.
		 */
		return String.format("%s\n" +
							"SUBCATEGORY: Soft Copy\n" +
							"KINDLE: %s\n" +
							"AUDIBLE: %s",
							super.toString(), getKindle(), getAudible());
	}
}
