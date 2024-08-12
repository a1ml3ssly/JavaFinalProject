import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExample {


    private Library library;

    /**
     * Sets up a new {@link Library} instance before each test
     */
    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    /**
     * Verifies that a new book is added correctly to an empty library
     */
    @Test
    public void testAddNewBookToEmptyLibrary() {
        Book book = new Book("Author", "Title", 100);
        library.addNewBook(book);

        Shelf firstShelf = library.getShelves().get(0);
        assertEquals(1, firstShelf.getBooks().size());
        assertEquals("Title", firstShelf.getBooks().get(0).getTitle());
        assertEquals("Author", firstShelf.getBooks().get(0).getAuthor());
    }

    /**
     * Checks that a new book is added to the second shelf when the first shelf is full
     */
    @Test
    public void testAddNewBookWhenFirstShelfIsFull() {

        for (int i = 0; i < 5; i++) {
            library.addNewBook(new Book("Author" + i, "Title" + i, 60 + i));
        }

        Book newBook = new Book("New Author", "New Title", 60);
        library.addNewBook(newBook);

        Shelf secondShelf = library.getShelves().get(1);
        assertEquals(1, secondShelf.getBooks().size());
        assertEquals("New Title", secondShelf.getBooks().get(0).getTitle());
        assertEquals("New Author", secondShelf.getBooks().get(0).getAuthor());
    }

    /**
     * Ensures that a new book is handled correctly when all shelves are full
     */
    @Test
    public void testAddNewBookWhenShelvesAreFull(){

        for (int i = 0; i < 15; i++) {
            library.addNewBook(new Book("Author" + i, "Title" + i, 60 + i));
        }

        Book newBook = new Book("New Author", "New Title", 60);
        library.addNewBook(newBook);

        assertEquals(5,library.getShelves().get(2).getBooks().size());

        assertFalse(library.getShelves().get(0).getBooks().contains(newBook));
        assertFalse(library.getShelves().get(1).getBooks().contains(newBook));
        assertFalse(library.getShelves().get(2).getBooks().contains(newBook));
    }

}