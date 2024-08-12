import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.println("Enter book author: ");
                    String author = input.nextLine();
                    System.out.println("Enter book title: ");
                    String title = input.nextLine();
                    System.out.println("Enter number of pages: ");
                    int pages = input.nextInt();
                    library.addNewBook(new Book(author, title, pages));
                    break;
                case 2:
                    System.out.println("Enter book title to remove: ");
                    String removeBook = input.nextLine();
                    library.deleteBook(removeBook);
                    break;
                case 3:
                    System.out.println("Enter reader name: ");
                    String readerName = input.nextLine();
                    System.out.println("Enter reader ID: ");
                    int readerId = input.nextInt();
                    library.registerReader(readerName, readerId);
                    break;
                case 4:
                    System.out.println("Enter reader name to remove: ");
                    String removeName = input.nextLine();
                    library.removeReader(removeName);
                    break;
                case 5:
                    System.out.println("Enter author name to search: ");
                    String searchAuthor = input.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 6:
                    System.out.println("Goodbye :)");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong number try again!\n");
                    break;
            }
        }

    }

    public static void displayMenu() {
        System.out.println("____________________________________________________");
        System.out.println("Choose the number of your choice from the menu:");
        System.out.println("For adding a book - Press 1");
        System.out.println("For deleting a book - Press 2");
        System.out.println("For registering a new reader - Press 3");
        System.out.println("For removing a reader - Press 4");
        System.out.println("For Searching books by author - Press 5");
        System.out.println("For Exit - Press 6");
        System.out.println("\nYour choice: ");
    }

}
