/*Nama : Reza Siregar
 * Nim :12S17012
 */
package w09s03p_library_case;

//required classes
import java.util.Collection;
import java.util.Date;

//class definition
public class member {
	//instance attributes
	private String id;
	private String full_name;
	private Date date_of_birth;
	private Date registered_at;
	private int suspended;
	
	
	public member() {
		// TODO Auto-generated constructor stub
	}
	
	
	public member(String _id, String _fullname, Date _dateofbirth, Date _registeredat, int _suspended) {
		this();
		setId(_id);
		setFull_name(_fullname);
		setDate_of_birth(_dateofbirth);
		setRegistered_at(_registeredat);
		setSuspended(_suspended);
	}


	public String getId() {
		return (this.id);
	}


	public void setId(String _id) {
		id = _id;
	}


	public String getFull_name() {
		return (this.full_name);
	}


	public void setFull_name(String _fullname) {
		full_name = _fullname;
	}


	public Date getDate_of_birth() {
		return (this.date_of_birth);
	}


	public void setDate_of_birth(Date _dateofbirth) {
		date_of_birth = _dateofbirth;
	}


	public Date getRegistered_at() {
		return (this.registered_at);
	}


	public void setRegistered_at(Date _registeredat) {
		registered_at = _registeredat;
	}

	

	public int getSuspended() {
		return suspended;
	}


	public void setSuspended(int _suspended) {
		suspended = _suspended;
	}


	public void setSuspended(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
