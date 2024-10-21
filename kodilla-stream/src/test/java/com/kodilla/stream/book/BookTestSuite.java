package com.kodilla.stream.book;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTestSuite {
    @Test
    void testGetListUsingFor(){
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> bookList = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, bookList.size())
                        .filter(n -> bookList.get(n).getYear() > 2007)
                                .count();
        assertEquals(3,numberOfBooksPublicatedAfter2007);
    }
}
