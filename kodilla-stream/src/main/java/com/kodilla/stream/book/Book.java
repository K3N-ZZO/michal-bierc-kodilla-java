package com.kodilla.stream.book;

public final class Book {
    private final String title;
    private final String author;
    private final int year;
    private final String signature;

    public Book(final String title,final String author,final int year,final String signature) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.signature = signature;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author= '" + author + '\''
                + ", title= '" + title + '\''
                + ", year= '" + year + '\'' + '}'
                + ", signature= '" + signature + '\'' + '}';
    }
}
