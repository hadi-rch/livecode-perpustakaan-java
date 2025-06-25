package com.enigma.gosling;

import java.util.List;

public interface InventoryService {
    void addBook(Book book);
    Book findBookById(String id);
    List<Book> findBooksByTitle(String title);
    List<Book> getAllBooks();
    void updateBook(String id, Book updatedBook);
    void deleteBook(String id);
}