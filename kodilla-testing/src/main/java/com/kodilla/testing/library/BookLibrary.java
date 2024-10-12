package com.kodilla.testing.library;

import java.util.*;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }
    public List<Book> listBookWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBookWithCondition(titleFragment);
        if (resultList.size() > 20) {
            return bookList;
        }
        bookList = resultList;
        return bookList;
    }
    public List<Book> listBookInHandsOf(LibraryUser libraryUser) {
        List<Book> booksInHands = libraryDatabase.listBookInHandsOf(libraryUser);
        return booksInHands;
    }
}
