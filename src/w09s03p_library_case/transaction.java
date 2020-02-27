/*Nama : Reza Siregar
 * Nim :12S17012
 */
package w09s03p_library_case;

import java.util.Collection;
import java.util.Date;

public class transaction {
	private String member_id;
	private String book_copy_call_id;
	private Date borrowed_at;
	private Date returned_at;
	private int fine;
	
	public transaction() {
		// TODO Auto-generated constructor stub
	}
	
	public transaction(String _member_id, String _book_copy_call_id, Date _borrowed_at, Date _returned_at, int _fine) {
		this();
		setMember_id(_member_id);
		setBook_copy_call_id(_book_copy_call_id);
		setBorrowed_at(_borrowed_at);
		setReturned_at(_returned_at);
		setFine(_fine);
		
	}

	public String getMember_id() {
		return (this.member_id);
	}

	public void setMember_id(String _member_id) {
		member_id = _member_id;
	}

	public String getBook_copy_call_id() {
		return (this.book_copy_call_id);
	}

	public void setBook_copy_call_id(String _book_copy_call_id) {
		book_copy_call_id = _book_copy_call_id;
	}

	public Date getBorrowed_at() {
		return (this.borrowed_at);
	}

	public void setBorrowed_at(Date _borrowed_at) {
		borrowed_at = _borrowed_at;
	}

	public Date getReturned_at() {
		return (this.returned_at);
	}

	public void setReturned_at(Date _returned_at) {
		returned_at = _returned_at;
	}

	public int getFine() {
		return (this.fine);
	}

	public void setFine(int _fine) {
		fine = _fine;
	}

	public void setFine(String string) {
		// TODO Auto-generated method stub
		
	}

	
}
