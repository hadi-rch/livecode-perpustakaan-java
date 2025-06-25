package com.enigma.gosling;

public abstract class Book {
    private String id;
    private String title;
    private String publisher;
    private int yearPublished;

    public Book(String id, String title, String publisher, int yearPublished) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getTitle();

    public String getRawTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}