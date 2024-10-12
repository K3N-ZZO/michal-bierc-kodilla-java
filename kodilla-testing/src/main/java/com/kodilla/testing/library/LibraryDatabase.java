package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
    //List of books having title Condition on beginning
    List<Book> listBookWithCondition(String titleFragment);
    //List of books borrowed by user
    List<Book> listBookInHandsOf(LibraryUser libraryUser);

    //Try to rent a book for user
    //Return
    boolean rentABook(LibraryUser libraryUser, Book book);

    //returns number of books returned by user
    int returnBooks(LibraryUser libraryUser);
}
