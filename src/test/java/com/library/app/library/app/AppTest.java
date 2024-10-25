package com.library.app.library.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	Map<String, String> testUsers;
	
	App app = new App();
	
	
	@BeforeEach
	void setUp() {
		app.usersMap();
	}
	
    /**
     * Rigorous Test :-)
     */
    @Test
    public void booksExist() {
        assertNotNull(app.getBooks(), "Tests if method getBooks returns anything");
    }
    
    @Test
    public void dataIsSameSize() {
    	ArrayList<Book> booksTest = new ArrayList<>();
    	
    	booksTest.add(new Book("Dune", "Frank Herbert", "978-0593099322"));
    	booksTest.add(new Book("1984", "George Orwell", " 978-0451524935"));
    	booksTest.add(new Book("The Great Gatsby", " F. Scott Fitzgerald", "978-0743273565"));
    	booksTest.add(new Book("Moby Dick", "Herman Melville", "978-1503280786"));
    	booksTest.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
    	booksTest.add(new Book("A Game of Thrones", "George R. R. Martin", "978-0553106626"));
    	
    	ArrayList<Book> gotBooks = app.getBooks();
    	
    	assertTrue(gotBooks.size() == booksTest.size(), "Tests if the size of the two data sets are the same size");
    }
    
    @Test
    public void entryIsIdentical() {
    	ArrayList<Book> booksTest = new ArrayList<>();
    	
    	booksTest.add(new Book("Dune", "Frank Herbert", "978-0593099322"));
    	booksTest.add(new Book("1984", "George Orwell", " 978-0451524935"));
    	booksTest.add(new Book("The Great Gatsby", " F. Scott Fitzgerald", "978-0743273565"));
    	booksTest.add(new Book("Moby Dick", "Herman Melville", "978-1503280786"));
    	booksTest.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
    	booksTest.add(new Book("A Game of Thrones", "George R. R. Martin", "978-0553106626"));
    	
    	ArrayList<Book> gotBooks = app.getBooks();
    	
    	assertTrue(gotBooks.get(1).getTitle() == booksTest.get(1).getTitle(), "Tests if an entry is the same in both data sets");
    }
    
    @Test
    public void testAuthenticateValid() {
    	assertTrue(app.authenticate("hermes", "password123"), "Test if authenticate returns true when login is succesfull");
    }
    @Test
    public void testAuthenticateInvalid() {
    	assertFalse(app.authenticate("kalle", "password1234"), "Test if authenticate returns false when login fails");
    }
}
