package com.enigma.gosling.service;

import com.enigma.gosling.Book;
import com.enigma.gosling.InventoryService;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getRawTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
    
    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public void updateBook(String id, Book updatedBook) {
        Book existingBook = findBookById(id);
        if (existingBook != null) {
            int index = books.indexOf(existingBook);
            books.set(index, updatedBook);
        }
    }

    @Override
    public void deleteBook(String id) {
        Book bookToRemove = findBookById(id);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }
}
