package com.library.app.library.app;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	App app = new App();
 
    	System.out.println("Version 1.0 of library!");
        System.out.println("Welcome to the Library Amazing!");
        System.out.println("Books available:");
        
        int i = 1;
        for (Book book : app.getBooks()) {
        	System.out.println(i + ".");
        	System.out.println("Title:  " + book.getTitle());
        	System.out.println("Author: " + book.getAuthor());
        	System.out.println("ISBN:   " + book.getIsbn());
        	i++;
        }
        
    }
    
    public ArrayList<Book> getBooks() {
    	
    	ArrayList<Book> books = new ArrayList<>();
    	
    	books.add(new Book("Dune", "Frank Herbert", "978-0593099322"));
    	books.add(new Book("1984", "George Orwell", " 978-0451524935"));
    	books.add(new Book("The Great Gatsby", " F. Scott Fitzgerald", "978-0743273565"));
    	books.add(new Book("Moby Dick", "Herman Melville", "978-1503280786"));
    	books.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
    	books.add(new Book("A Game of Thrones", "George R. R. Martin", "978-0553106626"));
    	
    	return books;
    }
}
