import com.kodilla.patterns.prototype.library.Book;
import com.kodilla.patterns.prototype.library.Library;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class LibraryTestSuite {
    @Test
    void testGetBooks() {
        //Given
        Book book1 = new Book("Book 1", "Author 1", LocalDate.of(2020, 1, 1));
        Book book2 = new Book("Book 2", "Author 2", LocalDate.of(2020, 2, 2));
        Book book3 = new Book("Book 3", "Author 3", LocalDate.of(2020, 3, 3));

        Library library = new Library("Library number: 1");

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;
        try{
            shallowClonedLibrary = (Library) library.shallowCopy();
            shallowClonedLibrary.setName("Shallow Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        try{
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println("Orginal library: " + library);
        System.out.println("Shallow Cloned Library: " + shallowClonedLibrary);
        System.out.println("Deep Cloned Library: " + deepClonedLibrary);
        assertEquals(3, library.getBooks().size());
        assertEquals(3, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertNotSame(library, shallowClonedLibrary);
        assertNotSame(library, deepClonedLibrary);
    }
}
