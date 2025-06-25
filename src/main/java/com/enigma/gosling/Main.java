package com.enigma.gosling;

import com.enigma.gosling.service.InventoryServiceImpl;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static InventoryService inventoryService = new InventoryServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    boolean run  = true;
        while (run) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        addNewBook();
                        break;
                    case 2:
                        searchBook();
                        break;
                    case 3:
                        updateExistingBook();
                        break;
                    case 4:
                        deleteBook();
                        break;
                    case 5:
                        displayAllBooks();
                        break;
                    case 0:
                        run = false;
                        System.out.println("Thank you for using Enigma Library System!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (run) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static int getIntInput(String inputPrompt) {
        while (true) {
            System.out.print(inputPrompt);
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== ENIGMA LIBRARY INVENTORY SYSTEM =====");
        System.out.println("1. Add New Book");
        System.out.println("2. Search Book");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Display All Books");
        System.out.println("0. Exit");
        System.out.println("=======================================");
    }

    private static void addNewBook() throws Exception {
        System.out.println("\n----- ADD NEW BOOK -----");
        System.out.println("Select book type:");
        System.out.println("1. Novel");
        System.out.println("2. Magazine");
        int bookType = getIntInput("Enter book type: ");

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();
        int yearPublished = getIntInput("Enter Year Published: ");

        if (bookType == 1) {
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            inventoryService.addBook(new Novel(id, title, publisher, yearPublished, author));
        } else if (bookType == 2) {
            System.out.print("Enter Period Type (e.g., Weekly, Monthly): ");
            String periodType = scanner.nextLine();
            inventoryService.addBook(new Magazine(id, title, publisher, yearPublished, periodType));
        } else {
            System.out.println("Invalid book type.");
            return;
        }
        System.out.println("Book added successfully!");
     }

    private static void displayAllBooks() {
        System.out.println("\n----- ALL BOOKS -----");
        List<Book> books = inventoryService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in inventory.");
        } else {
            for (Book book : books) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle());
            }
        }
    }

    private static void searchBook() {
        System.out.println("\n----- SEARCH BOOK -----");
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        List<Book> books = inventoryService.findBooksByTitle(title);

        if (books.isEmpty()) {
            System.out.println("No books found with that title.");
        } else {
            System.out.println("Found books:");
            for (Book book : books) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle());
            }
        }
    }

    private static void updateExistingBook() {
        System.out.println("\n----- UPDATE BOOK -----");
        System.out.print("Enter the ID of the book to update: ");
        String id = scanner.nextLine();
        Book existingBook = inventoryService.findBookById(id);

        if (existingBook == null) {
            System.out.println("Book with that ID not found.");
            return;
        }

        System.out.print("Enter new Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new Publisher: ");
        String publisher = scanner.nextLine();
        int yearPublished = getIntInput("Enter new Year Published: ");

        if (existingBook instanceof Novel) {
            System.out.print("Enter new Author: ");
            String author = scanner.nextLine();
            inventoryService.updateBook(id, new Novel(id, title, publisher, yearPublished, author));
        } else if (existingBook instanceof Magazine) {
            System.out.print("Enter new Period Type: ");
            String periodType = scanner.nextLine();
            inventoryService.updateBook(id, new Magazine(id, title, publisher, yearPublished, periodType));
        }
        System.out.println("Book updated successfully!");
    }

    private static void deleteBook() {
        System.out.println("\n----- DELETE BOOK -----");
        System.out.print("Enter the ID of the book to delete: ");
        String id = scanner.nextLine();
        inventoryService.deleteBook(id);
        System.out.println("Book deleted successfully!");
    }
}
