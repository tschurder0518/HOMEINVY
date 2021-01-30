package items;

public abstract class Book extends Item {
	// INTENT: Extend properties of Item class and return extra properties for display.
	private String author;
	private String genre;
	private String series;
	
	// Constructor
	public Book(String name, String location, String purchaseYear, String condition, String author,
				String genre, String series) {
		super(name, location, purchaseYear, condition);
		this.author = author;
		this.genre = genre;
		this.series = series;
	}

	// Getters
	public String getAuthor() {return author;}
	public String getGenre() {return genre;}
	public String getSeries() {return series;}
	
	// Setters
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setSeries(String series) {
		this.series = series;
	}

	@Override
	public String toString() {
		/* INTENT: Override Item toString(), calls that method and adds extra
		 * properties of Tool to return for display.
		 * 
		 * POSTCONDITION 1: Parent is called and information there is added to
		 * additional Book properties. All properties returned in a format ready
		 * to display neatly.
		 */
		return String.format("CATEGORY: Book\n" +
							"%s\n" +
							"AUTHOR: %s\n" +
							"GENRE: %s\n" +
							"SERIES: %s",
							super.toString(), getAuthor(), getGenre(), getSeries());
	}

	
	
}
