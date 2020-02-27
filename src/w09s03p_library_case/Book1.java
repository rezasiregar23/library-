/*Nama : Reza Siregar
 * Nim :12S17012
 */
package w09s03p_library_case;

//required classes
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// class definition
public class Book1 {
	// class attributes
	public static final double MIN_RATING = 1.0;
	public static final double MAX_RATING = 5.0;

	// instance attributes
	private String isbn;
	private String title;
	private int edition;
	/* see https://docs.oracle.com/javase/7/docs/api/java/util/Set.html */
	private Set<String> authors;
	private Date publishedAt;
	private String synopsis;
	private double rating;
	private int rating_counter;
 
	public Book1() {
		this.authors=new HashSet<String>();
		this.rating = 0.0;
		this.rating_counter = 0;
	}

	public Book1(String _isbn, String _title, Collection<String> _authors,
		Date _publishedAt, String _synopsis, double _rating, int _edition) {
		this();
		setIsbn(_isbn);
		setTitle(_title);
		setAuthors(_authors);
		setSynopsis(_synopsis);
		setPublishedAt(_publishedAt);
		setSynopsis(_synopsis);
		setRating(_rating);
		setEdition(_edition);
	}

	// class method
	public static boolean validateIsbn13(String _isbn) {
		// TO DO: apply a validation ISBN technique.
		return (true);
	}
	
	// instance methods
	public String getIsbn() {
		return (this.isbn);
	}
	
	public void setIsbn(String _isbn) {
		if (validateIsbn13(_isbn)) {
			this.isbn = _isbn;
		}
	}
	
	public String getTitle() {
		return (this.title);
	}
	
	public void setTitle(String _title) {
		this.title = _title;
	}
	
	public int getEdition() {
		return (this.edition);
	}
	
	public void setEdition(int _edition) {
		this.edition = _edition;
	}
	
	public Collection<String> getAuthors() {
		return (this.authors);
	}
	
	public void setAuthors(Collection<String> _authors) {
		this.authors.addAll(_authors);
	}
	
	public void addAuthor(String _author) {
		this.authors.add(_author);
	}
	
	public Date getPublishedAt() {
		return (this.publishedAt);
	}
	
	public void setPublishedAt(Date _publishedAt) {
		this.publishedAt = _publishedAt;
	}
	
	public String getSynopsis() {
		return (this.synopsis);
	}
	
	public void setSynopsis(String _synopsis) {
		this.synopsis = _synopsis;
	}
	
	public double getRating() {
		return (this.rating);
	}
	
	public void setRating(Double _rating) {
		this.rating = _rating;
	}
	
	public void rate(double _rating) {
		if (MIN_RATING >= _rating && _rating <= MAX_RATING) {
			double newRating = this.rating * this.rating_counter;
			
			this.rating_counter++;
			newRating = (newRating + _rating) / this.rating_counter;
		}
	}
}


 