package items;

public class HardCopy extends Book {
	// INTENT: Extend properties of Book class, create HardCopy objects and return extra 
	// properties for display.
	
	private String bookshelf;
	
	// Constructor
	public HardCopy(String name, String location, String purchaseYear, String condition, String author,
				String genre, String series, String bookshelf) {
		super(name, location, purchaseYear, condition, author, genre, series);
		this.bookshelf = bookshelf;
	}

	// Getter
	public String getBookshelf() {return bookshelf;}

	// Setter
	public void setBookshelf(String bookshelf) {
		this.bookshelf = bookshelf;
	}
	
	@Override
	public String toString() {
		/* INTENT: Override Book toString(), calls that method and adds extra
		 * properties of HardCopy to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional HardCopy properties. All properties returned in a format ready
		 * to display neatly. Item, Book and HardCopy properties returned.
		 */
		return String.format("%s\n" +
							"SUBCATEGORY: Hard Copy\n" +
							"BOOKSHELF: %s",
							super.toString(), getBookshelf());
	}
}
