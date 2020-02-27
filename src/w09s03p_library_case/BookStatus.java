/*Nama : Reza Siregar
 * Nim :12S17012
 */
package w09s03p_library_case;

import java.util.Collection;

public class BookStatus {
	private String status;
	private String label;
	private String description;
	private String setStatus;
	private String setLabel;
	private String setDescription;
	
	public BookStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public BookStatus(String _status, String _label, String _description) {
		this();
		setStatus = _status;
		setLabel = _label;
		setDescription = _description;
	}


	public String getStatus() {
		return (this.status);
	}


	public void setStatus(String _status) {
		status = _status;
	}


	public String getLabel() {
		return (this.label);
	}


	public void setLabel(String _label) {
		label = _label;
	}


	public String getDescription() {
		return (this.description);
	}


	public void setDescription(String _description) {
		description = _description;
	};
	
	
	
	
}
