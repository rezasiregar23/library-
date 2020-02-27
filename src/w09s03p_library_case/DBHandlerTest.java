/*Nama : Reza Siregar
 * Nim :12S17012
 */
package w09s03p_library_case;


import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;
import w09s03p_library_case.Book1;
import w09s03p_library_case.BookCopy;
import w09s03p_library_case.db.DbHandler;
import w09s03p_library_case.BookStatus;
import w09s03p_library_case.transaction;
import w09s03p_library_case.member;

class DbHandlerTest {

	@Test
	void testEstablishingConnection() {
		DbHandler handler = new DbHandler();
			boolean connected = handler.connect("localhost", "library", "pbo", "pbo");
		assertTrue(connected);
		handler.disconnect();
		assertFalse(handler.isConnected());
	}
	
	@Test
	 void testInsertBook() {
		DbHandler handler = new DbHandler();
		boolean connected =
			handler.connect("localhost", "library", "pbo", "pbo");
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 Date publishedDate = dateFormat.parse("2008-07-29");
			 
			 Book1 book = new Book1();
			 book.setIsbn("9780470128725");
			 book.setTitle("Operating System Concepts");
			 book.setEdition(8);
			 book.addAuthor("Abraham Silberschatz");
			 book.setPublishedAt(publishedDate);
			 book.setSynopsis("a book about operating system");
			 book.setRating(2.3);
			 
			 
			 int affected = handler.saveBook(book);

			 assertEquals(1, affected);
		 } catch (Exception _e) {
		 fail(_e.getMessage());
		 } finally {
		 handler.disconnect();
		 }
	}
	
	@Test
	 void testGetBookWithIsbn() {
		DbHandler handler = new DbHandler();
		boolean connected =
				handler.connect("localhost", "library", "pbo", "pbo");
		try {
			Book1 book = handler.getBookWithIsbn("9780470128725");
		 
			assertNotNull(book);
		}
		catch (Exception _e) {
		 fail(_e.getMessage());
		}finally {
		 handler.disconnect();
		}
	}
	
	@Test
	void testDeleteBookWithIsbn() {
		DbHandler handler = new DbHandler();
		boolean connected =
			handler.connect("localhost", "library", "pbo", "pbo");
			
		try {
			String isbn = "9780470128725";
			int affected = handler.deleteBookWithIsbn(isbn);
		 
			assertNull(handler.getBookWithIsbn(isbn));
		} catch (Exception _e) {
		 fail(_e.getMessage());
		} finally {
		 handler.disconnect();
		}
	}
	
	@Test
	 void testInsertBookStatus() {
		DbHandler handler = new DbHandler();
		boolean connected =
			handler.connect("localhost", "library", "pbo", "pbo");
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 Date publishedDate = dateFormat.parse("2008-07-29");
			 
			 BookStatus bookstatus = new BookStatus();
			 bookstatus.setStatus("tersedia");
			 bookstatus.setLabel("os");
			 bookstatus.setDescription("Buku ini sangat lengkap");
			
			 
			 BookStatus _bookstatus = null;
			int affected = handler.saveBookStatus(_bookstatus);

			 assertEquals(1, affected);
		 } catch (Exception _e) {
		 fail(_e.getMessage());
		 } finally {
		 handler.disconnect();
		 }
	}
	
	@Test
	 void testInsertBookCopy() {
		DbHandler handler = new DbHandler();
		boolean connected =
			handler.connect("localhost", "library", "pbo", "pbo");
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 Date publishedDate = dateFormat.parse("2008-07-29");
			 
			 BookCopy bookcopy = new BookCopy();
			 bookcopy.setCall_id("6589372");
			 bookcopy.setLocation("4a");
			 bookcopy.setStatus("tersedia");
			 bookcopy.setBorrowable("1");
			 
			 
			 int affected = handler.saveBookCopy(bookcopy, null, null);

			 assertEquals(1, affected);
		 } catch (Exception _e) {
		 fail(_e.getMessage());
		 } finally {
		 handler.disconnect();
		 }
	}
	
	@Test
	 void testtransaction() {
		DbHandler handler = new DbHandler();
		boolean connected =
			handler.connect("localhost", "library", "pbo", "pbo");
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 Date borrowedDate = dateFormat.parse("2008-07-29");
			 Date returnedDate = dateFormat.parse("2008-07-30");
			 transaction trans = new transaction();
			 trans.setMember_id("2798912");
			 trans.setBook_copy_call_id("728028");
			 trans.setBorrowed_at(borrowedDate);
			 trans.setReturned_at(returnedDate);
			 trans.setFine("2000");
			
			
			 int affected = handler.savetransaction(trans);

			 assertEquals(1, affected);
		 } catch (Exception _e) {
		 fail(_e.getMessage());
		 } finally {
		 handler.disconnect();
		 }
	}
	
	@Test
	 void testMember() {
		DbHandler handler = new DbHandler();
		boolean connected =
			handler.connect("localhost", "library", "pbo", "pbo");
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 Date date_of_birthDate = dateFormat.parse("2008-07-29");
			 Date registered_atDate = dateFormat.parse("2008-07-30");
			 member member = new member();
			 member.setId("2798912");
			 member.setFull_name("Ernike Nelsi Manurung");
			 member.setDate_of_birth(date_of_birthDate);
			 member.setRegistered_at(registered_atDate);
			 member.setSuspended("1");
			
			
			 int affected = handler.savemember(member);

			 assertEquals(1, affected);
		 } catch (Exception _e) {
		 fail(_e.getMessage());
		 } finally {
		 handler.disconnect();
		 }
	}
}

