/*Nama : Reza Siregar
 * Nim :12S17012
 */
package w09s03p_library_case;

//required classes
import java.util.Collection;

//class definition
public class BookCopy {
	//instance attributes
	
	private String call_id;
	//private String book_isbn  ;
	private String location;
	private String status;
	private int suspended;
	
	public BookCopy() {
		// TODO Auto-generated constructor stub
	}
	
	public BookCopy(String _call_id, String _location, String _status, int _suspended) {
		this();
		setCall_id(_call_id);
		setLocation(_location);
		setStatus(_status);
		setSuspended(_suspended);
	}

	public void setCall_id(String _call_id) {
		// TODO Auto-generated method stub
		call_id = _call_id;
	}

	public String getCall_id() {
		return (this.call_id);
	}

	public String getLocation() {
		return (this.location);
	}

	public void setLocation(String _location) {
		location = _location;
	}

	public String getStatus() {
		return (this.status);
	}

	public void setStatus(String _status) {
		status = _status;
	}

	public int getSuspended() {
		return (this.suspended);
	}

	public void setSuspended(int _suspended) {
		suspended = _suspended;
	}
	
	public static void main(String[] args) {
		//object instatiation
		Book1 book = new Book1 ();
		
		book.getIsbn();
	}

	public void setBorrowable(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public String getBorrowable() {
		// TODO Auto-generated method stub
		return null;
	}
}