/*Nama : Reza Siregar
 * Nim :12S17012
 */
package w09s03p_library_case;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import w09s03p_library_case.Book1;
import w09s03p_library_case.BookCopy;
import w09s03p_library_case.BookStatus;
import w09s03p_library_case.transaction;
import w09s03p_library_case.member;

public class DbHandler {

	private Connection connection;
	private boolean connected;

	public DbHandler() {
		this.connected = false;
	}
	
	public boolean connect(String _host, String _dbName, String _username, String _password) {
		
		String connectionString = "jdbc:mariadb://" + _host + "/" + _dbName;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mariadb://localhost/library", "pbo", "pbo");
			this.connected = true;
		} catch (Exception _e) {
			System.out.println("Exception: " + _e.getMessage());
			this.connected = false;
		}
		return (this.connected);
	}

	public void disconnect() {
		if (this.connected) {
			try {
				this.connection.close();
			} catch (Exception _e) {
				System.out.println("Exception: " + _e.getMessage());
			}
		}
		this.connected = false;
	}

	public boolean isConnected() {
		return (this.connected);
	}

	public int saveBook(Book1 _book) {
		 int affected = 0;
		 if (this.connected) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String query =
				 "INSERT INTO book(isbn, title, edition, published_at, synopsis, rating) VALUES(" +
				"'" + _book.getIsbn() + "'," +
				"'" + _book.getTitle() + "'," +
				"'" + _book.getEdition() + "'," +
				"'" + dateFormat.format(_book.getPublishedAt()) + "'," +
				"'" + _book.getSynopsis() + "'," + 
				"'" + _book.getRating() + "'" +" )";
		 try {
			 // TODO: check whether the book exists already.
			 // TODO: check whether the authors are new.
		 
			 // insert the Book instance
			 Statement stmt = this.connection.createStatement();
			 affected = stmt.executeUpdate(query);
			 System.out.println("affected: " + affected);
		 } catch (Exception _e) {
			 System.out.println("Exception: " + _e.getMessage());
		 }
		}
		return (affected);
	}
	
	public int deleteBookWithIsbn(String _isbn) {
		int affected = 0;
		if (this.connected) {
			String query = "DELETE FROM book WHERE isbn='" + _isbn + "'";
			try {
				Statement stmt = this.connection.createStatement();
				affected = stmt.executeUpdate(query);
			} catch (Exception _e) {
				System.out.println("Exception: " + _e.getMessage());
			}
		}
		return (affected);
	}
	
	public Book1 getBookWithIsbn(String _isbn) {
		Book1 book = null;
		if (this.connected) {
			String query = "SELECT * FROM book WHERE isbn='" + _isbn + "'";
			try {
				Statement stmt = this.connection.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				if (resultSet.next()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					book = new Book1();
					book.setIsbn(resultSet.getString(1));
					book.setTitle(resultSet.getString(2));
					book.setPublishedAt(dateFormat.parse(resultSet.getString(3)));
					book.setSynopsis(resultSet.getString(4));
				}
			} catch (Exception _e) {
				System.out.println("Exception: " + _e.getMessage());
			}
		}
		return (book);
	}
	
	public BookCopy getBookCopyWithIsbn(String call_id) {
		BookCopy bookcopy = null;
		Book1 book = null;
		BookStatus bookstatus = null;
		if (this.connected) {
			String query = "SELECT * FROM bookcopy WHERE callid='" + call_id + "'";
			try {
				Statement stmt = this.connection.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				if (resultSet.next()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					bookcopy = new BookCopy();
					bookcopy.setCall_id(resultSet.getString(1));
					book.setIsbn(resultSet.getString(2));
					bookcopy.setLocation(resultSet.getString(3));
					bookstatus.setStatus(resultSet.getString(4));
					bookcopy.setBorrowable(resultSet.getString(5));
				}
			} catch (Exception _e) {
				System.out.println("Exception: " + _e.getMessage());
			}
		}
		return (bookcopy);
	}
	
	public int saveBookCopy(BookCopy _bookcopy, Book1 _book, BookStatus _bookstatus) {
		 int affected = 0;
		 if (this.connected) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String query =
				 "INSERT INTO book(call_id, book_isbn, location, status, borrowable) VALUES(" +
				"'" + _bookcopy.getCall_id() + "'," +
				"'" + _book.getIsbn() + "'," +
				"'" + _bookcopy.getLocation() + "'," +
				"'" + _bookstatus.getStatus() + "'," +
				"'" + _bookcopy.getBorrowable() + "'" + ")";
				
		 try {
			 // TODO: check whether the book exists already.
			 // TODO: check whether the authors are new.
		 
			 // insert the Book instance
			 Statement stmt = this.connection.createStatement();
			 affected = stmt.executeUpdate(query);
			 System.out.println("affected: " + affected);
		 } catch (Exception _e) {
			 System.out.println("Exception: " + _e.getMessage());
		 }
		}
		return (affected);
	}
	
	public BookStatus getBookStatusWithStatus(String _status) {
		BookStatus bookstatus = null;
		if (this.connected) {
			String query = "SELECT * FROM bookstatus WHERE status='" + _status + "'";
			try {
				Statement stmt = this.connection.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				if (resultSet.next()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					bookstatus = new BookStatus();
					bookstatus.setStatus(resultSet.getString(1));
					bookstatus.setLabel(resultSet.getString(2));
					bookstatus.setDescription(resultSet.getString(3));
				}
			} catch (Exception _e) {
				System.out.println("Exception: " + _e.getMessage());
			}
		}
		return (bookstatus);
	}
	
	public int saveBookStatus(BookStatus _bookstatus) {
		 int affected = 0;
		 if (this.connected) {
			 String query =
				 "INSERT INTO _bookstatus(status, label, description) VALUES(" +
				"'" + _bookstatus.getStatus() + "'," +
				"'" + _bookstatus.getLabel() + "'," +
				"'" + _bookstatus.getDescription() + "'" +")";
				
		 try {
			 // TODO: check whether the book exists already.
			 // TODO: check whether the authors are new.
		 
			 // insert the Book instance
			 Statement stmt = this.connection.createStatement();
			 affected = stmt.executeUpdate(query);
			 System.out.println("affected: " + affected);
		 } catch (Exception _e) {
			 System.out.println("Exception: " + _e.getMessage());
		 }
		}
		return (affected);
	}
	
	public int savetransaction(transaction trans) {
		 int affected = 0;
		 if (this.connected) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String query =
				 "INSERT INTO _trans(member_id, book_copy_call_id, borrowed_at, returned_at, fine) VALUES(" +
				"'" + trans.getMember_id() + "'," +
				"'" + trans.getBook_copy_call_id() + "'," +
				"'" + dateFormat.format(trans.getBorrowed_at()) + "'," +
				"'" + dateFormat.format(trans.getReturned_at()) + "'," +
				"'" + trans.getFine() + "'" + ")";
		 try {
			 // TODO: check whether the book exists already.
			 // TODO: check whether the authors are new.
		 
			 // insert the Book instance
			 Statement stmt = this.connection.createStatement();
			 affected = stmt.executeUpdate(query);
			 System.out.println("affected: " + affected);
		 } catch (Exception _e) {
			 System.out.println("Exception: " + _e.getMessage());
		 }
		}
		return (affected);
	}
	
	public transaction getTransactionWithTransaction(String Member_id) {
		transaction trans = null;
		if (this.connected) {
			String query = "SELECT * FROM transaction WHERE Member_id='" + Member_id + "'";
			try {
				Statement stmt = this.connection.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				if (resultSet.next()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					trans = new transaction();
					trans.setMember_id(resultSet.getString(1));
					trans.setBook_copy_call_id(resultSet.getString(2));
					trans.setBorrowed_at(dateFormat.parse(resultSet.getString(3)));
					trans.setReturned_at(dateFormat.parse(resultSet.getString(4)));
					trans.setFine(resultSet.getString(5));
				}
			} catch (Exception _e) {
				System.out.println("Exception: " + _e.getMessage());
			}
		}
		return (trans);
	}
	
	public int savemember(member member) {
		 int affected = 0;
		 if (this.connected) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String query =
				 "INSERT INTO member(id, full_name, date_of_birth, registered_at, suspended) VALUES(" +
				"'" + member.getId() + "'," +
				"'" + member.getFull_name() + "'," +
				"'" + dateFormat.format(member.getDate_of_birth()) + "'," +
				"'" + dateFormat.format(member.getRegistered_at()) + "'," +
				"'" + member.getSuspended() + "'" + ")";
		 try {
			 // TODO: check whether the book exists already.
			 // TODO: check whether the authors are new.
		 
			 // insert the Book instance
			 Statement stmt = this.connection.createStatement();
			 affected = stmt.executeUpdate(query);
			 System.out.println("affected: " + affected);
		 } catch (Exception _e) {
			 System.out.println("Exception: " + _e.getMessage());
		 }
		}
		return (affected);
	}
	
	public member getMemberWithId(String Id) {
		member member = null;
		if (this.connected) {
			String query = "SELECT * FROM Member WHERE id='" + Id + "'";
			try {
				Statement stmt = this.connection.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				if (resultSet.next()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					member = new member();
					member.setId(resultSet.getString(1));
					member.setFull_name(resultSet.getString(2));
					member.setDate_of_birth(dateFormat.parse(resultSet.getString(3)));
					member.setRegistered_at(dateFormat.parse(resultSet.getString(4)));
					//member.setSuspended(resultSet.getString(5));
				}
			} catch (Exception _e) {
				System.out.println("Exception: " + _e.getMessage());
			}
		}
		return (member);
	}
	
	
	
	
}
