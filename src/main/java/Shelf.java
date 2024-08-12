import java.util.ArrayList;
import java.util.Collections;

public class Shelf {
    //private Book[] bookList = new Book[5];
    private ArrayList<Book> bookList = new ArrayList<>();
    //private LimitedArrayList<Book> bookList = new LimitedArrayList<>(5);
    private boolean isShelfFull;

    public Shelf() {
        isShelfFull = false;
    }

    /**
     * @param book
     */
    public void addBook(Book book) {
        if (isShelfFull) {
            System.out.println("Shelf is full");
        } else {
            bookList.add(book);
            if (bookList.size() == 5) {
                isShelfFull = true;
                System.out.println("You have inserted the last book possible into the bookshelf, it is now full");
            } else {
                System.out.println("Your book was added successfully");
            }
        }
    }

    /**
     * switch places between 2 books
     *
     * @param num1
     * @param num2
     */
    public void replaceBooks(int num1, int num2) {
        if (check_num_size(num1, 1, 5) && check_num_size(num2, 1, 5)) {
            if (num1 <= bookList.size()) {
                if (num2 <= bookList.size()) {
                    Collections.swap(bookList, num1 - 1, num2 - 1);
                    System.out.println("The books were swapped");
                } else {
                    System.out.println("The book number " + num2 + " does not exists in the shelf");
                }
            } else {
                System.out.println("The book number " + num1 + " does not exists in the shelf");
            }
        } else {
            System.out.println("you can only insert numbers between 1 to 5");
        }
    }

    /**
     * A method designed to check if the number given is between the min and max sizes
     *
     * @param num      the number that you want to check
     * @param min_size should be 1 most of the time
     * @param max_size should be 5 most of the time
     * @return true if the number is between those numbers
     */
    private boolean check_num_size(int num, int min_size, int max_size) {
        if (min_size <= num && num <= max_size) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if shelf is full
     *
     * @return true if the shelf is full, false if empty
     */
    public boolean isShelfFull() {
        return isShelfFull;
    }

    /**
     * @return the list of book
     */
    public ArrayList<Book> getBooks() {
        return bookList;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        for (Book book : shelf.bookList) {
            System.out.println(book);
        }
        shelf.addBook(new Book("J.K Rowling", "Harry Potter 1", 50));
        shelf.addBook(new Book("J.K Rowling", "Harry Potter 2", 50));
        shelf.addBook(new Book("J.K Rowling", "Harry Potter 3", 50));
        shelf.replaceBooks(1, 4);

        for (Book book : shelf.bookList) {
            System.out.println(book);
        }
    }
}