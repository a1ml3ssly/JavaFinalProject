public class Book {
    private String author;
    private String title;
    private int numOfPages;

    public Book(String author, String title, int numOfPages) {

        setAuthor(author);
        setTitle(title);
        setNumOfPages(numOfPages);

    }

    public String toString(){
        return "Author: "+author+" Title: "+title+" Amount of Pages: "+numOfPages;
    }
    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
