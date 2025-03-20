package com.enigma.gosling;

import java.util.Scanner;

public class Main {
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
     }

    private static void displayAllBooks() {
        System.out.println("\n----- ALL BOOKS -----");
    }

    private static void searchBook() {
        System.out.println("\n----- SEARCH BOOK -----");

    }

    private static void updateExistingBook() {
        System.out.println("\n----- UPDATE BOOK -----");

    }

    private static void deleteBook() {
        System.out.println("\n----- DELETE BOOK -----");

    }
}