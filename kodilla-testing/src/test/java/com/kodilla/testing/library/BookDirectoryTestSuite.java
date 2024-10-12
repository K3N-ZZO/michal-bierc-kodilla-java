package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@Nested
@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generatedListOfBooks(int booksQuantity){
        List<Book> resultListOfBooks = new ArrayList<>();
        for (int i = 0; i < booksQuantity; i++) {
            Book thebook = new Book("Author"+i,"Title"+i,1970+i);
            resultListOfBooks.add(thebook);
        }
        return resultListOfBooks;
    }
    @Test
    void testListBookWithConditionReturnList(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [3]
        List<Book> resultListOfBooks = new ArrayList<>();                                // [4]
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
        resultListOfBooks.add(book1);                                                    // [9]
        resultListOfBooks.add(book2);                                                    // [10]
        resultListOfBooks.add(book3);                                                    // [11]
        resultListOfBooks.add(book4);                                                    // [12]
        when(libraryDatabaseMock.listBookWithCondition("Secret")).thenReturn(resultListOfBooks);// [13]

        // When
        List<Book> theListOfBooks = bookLibrary.listBookWithCondition("Secret");        // [14]

        // Then
        assertEquals(4, theListOfBooks.size());                                          // [15]
    }

    @Test
    void testListBookWithConditionMoreThan20(){
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generatedListOfBooks(15);
        List<Book> resultListOf40Books = generatedListOfBooks(40);
        when(libraryDatabaseMock.listBookWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBookWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBookWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
        //When
        List<Book> theListofBooks0 = bookLibrary.listBookWithCondition("ZeroBooks");
        List<Book> theListofBooks15 = bookLibrary.listBookWithCondition("Any title");
        List<Book> theListofBooks40 = bookLibrary.listBookWithCondition("FortyBooks");
        //Then
        assertEquals(0,theListofBooks0.size());
        assertEquals(15,theListofBooks15.size());
        assertEquals(0,theListofBooks40.size());
    }


    @Test
    void testListBookWithConditionShorterThan3(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        //When
        List<Book> theListOfBooks10 = bookLibrary.listBookWithCondition("An");

        //Then
        assertEquals(0,theListOfBooks10.size());
        verify(libraryDatabaseMock,times(0)).listBookWithCondition(anyString());


    }
    @Test
    void testListBookInHands0(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooksInHands = generatedListOfBooks(0);
        when(libraryDatabaseMock.listBookInHandsOf(any(LibraryUser.class))).thenReturn(resultListOfBooksInHands);

        //When
         bookLibrary.listBookInHandsOf(new LibraryUser("Jan","Kowalski","55555555"));

        //Then
        assertEquals(0,resultListOfBooksInHands.size());
    }
    @Test
    void testListBookInHands1(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooksInHands = generatedListOfBooks(1);
        when(libraryDatabaseMock.listBookInHandsOf(any(LibraryUser.class))).thenReturn(resultListOfBooksInHands);
        //When
        bookLibrary.listBookInHandsOf(new LibraryUser("Jan","Kowalski","55555555"));
        //Then
        assertEquals(1,resultListOfBooksInHands.size());
    }
    @Test
    void testListBookInHands5(){
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooksInHands = generatedListOfBooks(5);
        when(libraryDatabaseMock.listBookInHandsOf(any(LibraryUser.class))).thenReturn(resultListOfBooksInHands);
        //When
        bookLibrary.listBookInHandsOf(new LibraryUser("Jan","Kowalski","55555555"));
        //Then
        assertEquals(5,resultListOfBooksInHands.size());
    }
}


