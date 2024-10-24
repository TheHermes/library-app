package com.library.app.library.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private boolean isLoggedIn = false;
    private Map<String, String> users;

    public static void main(String[] args) {
        App app = new App();
        
        app.usersMap(); 

        System.out.println("Version 2.0 of library!");
        System.out.println("Welcome to the Library!");

        app.login();
      
        if (app.isLoggedIn) {
            System.out.println("Books available:");
            int i = 1;
            for (Book book : app.getBooks()) {
                System.out.println(i + ".");
                System.out.println("Title:  " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN:   " + book.getIsbn());
                i++;
            }
        } else {
            System.out.println("You must log in to view the library.");
        }
    }


    private void usersMap() {
        users = new HashMap<>();
        users.put("victor", "password123");
        users.put("hermes", "password123");
    }

    public ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Dune", "Frank Herbert", "978-0593099322"));
        books.add(new Book("1984", "George Orwell", "978-0451524935"));
        books.add(new Book("The Great Gatsby", " F. Scott Fitzgerald", "978-0743273565"));
        books.add(new Book("Moby Dick", "Herman Melville", "978-1503280786"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
        books.add(new Book("A Game of Thrones", "George R. R. Martin", "978-0553106626"));

        return books;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int max_attempts = 3;  

        while (attempts < max_attempts) {
            System.out.println("Enter username: ");
            String username = scanner.nextLine();

            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            if (authenticate(username, password)) {
                System.out.println("Login successful! Welcome, " + username + ".");
                isLoggedIn = true;
                break; 
            } else {
                attempts++;
                System.out.println("Login failed. Incorrect username or password.");
                if (attempts < max_attempts) {
                    System.out.println("Try again (" + (max_attempts - attempts) + " attempts left).");
                } else {
                    System.out.println("You are banned! Closing program");
                }
            }
        }

        scanner.close();
    }

    
    private boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

