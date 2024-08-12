import java.util.ArrayList;

public class Library {
    private ArrayList<Shelf> shelves;
    private ArrayList<Reader> readers;


    public Library() {
        shelves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            shelves.add(new Shelf());
        }
        readers = new ArrayList<>();
    }

    /**
     * Checks if there is space for a new book in any shelf
     *
     * @return true if there is space, false if empty
     */
    public boolean isTherePlaceForNewBook() {
        for (Shelf shelf : shelves) {
            if (!shelf.isShelfFull()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a new book to the first shelf with available space
     *
     * @param book
     */
    public void addNewBook(Book book) {
        if (!isTherePlaceForNewBook()) {
            System.out.println("No space available for a new book");
            return;
        }
        for (Shelf shelf : shelves) {
            if (!shelf.isShelfFull()) {
                shelf.addBook(book);
                System.out.println("Book added: " + book.getTitle());
                return;
            }
        }
    }

    /**
     * Delete book from the library by the title
     *
     * @param bookTitle
     */
    public void deleteBook(String bookTitle) {
        boolean found = false;
        for (Shelf shelf : shelves) {
            ArrayList<Book> bookList = shelf.getBooks();
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getTitle().equals(bookTitle)) {
                    bookList.remove(i);
                    System.out.println(bookTitle + " is removed!");
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println(bookTitle + " is not found!");
        }
    }

    /**
     * Register a new reader with given name and id
     *
     * @param name
     * @param id
     */
    public void registerReader(String name, int id) {
        readers.add(new Reader(id, name));
    }

    /**
     * Remove reader from the readers list by their name
     *
     * @param name
     */
    public void removeReader(String name) {
        boolean found = false;
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getName().equals(name)) {
                readers.remove(i);
                System.out.println(name + " is removed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(name + " is not found!");
        }
    }

    /**
     * Search for books by the given author name and print the books title
     *
     * @param author
     */

    public void searchByAuthor(String author) {
        ArrayList<String> titles = new ArrayList<>();
        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks()) {
                if (book.getAuthor().equals(author)) {
                    titles.add(book.getTitle());
                }
            }
        }
        if (titles.isEmpty()) {
            System.out.println("No books by author " + author + " were found");
        } else {
            System.out.println("Books by " + author + ":" + titles);
        }
    }


    public ArrayList<Shelf> getShelves() {
        return shelves;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }
}
