import java.util.ArrayList;

public class Reader {
    private int id;
    private String name;
    private ArrayList<String> books;

    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    /**
     * Add a book title to the list of books read by the reader
     *
     * @param bookTitle
     */
    public void readBook(String bookTitle) {
        if (!books.contains(bookTitle)) {
            books.add(bookTitle);
            System.out.println(name + " has read the book " + bookTitle);
        } else {
            System.out.println(name + " has already read the book " + bookTitle);
        }
    }

    public String toString() {
        return "Reader Id:" + id + "Name: " + name + "Books: " + books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }
}
