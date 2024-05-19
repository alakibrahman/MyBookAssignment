import java.util.Scanner;

public class LibraryManagementSystem {
    private static final int MAX_BOOKS = 100;

    private static Book[] library = new Book[MAX_BOOKS];
    private static int numBooks = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nLibrary Management System");

            System.out.println("1. Add a book");

            System.out.println("2.Remove a book");

            System.out.println("3.Search for a book");

            System.out.println("4.Display all books");

            System.out.println("5.Exit");

            System.out.println("Enter your choice");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    addBook(scanner);
                    break;
                case 2:

                    removeBook(scanner);
                    break;
                case 3:

                    searchBook(scanner);
                    break;
                case 4:

                    displayBooks();
                    break;
                case 5:

                    System.out.println("Exiting the system Goodbye!");
                    break;
                default:

                    System.out.println("Invalid choice Please try again.");
            }
            } while(choice != 5);

        scanner.close();
        }

    private static void displayBooks() {
    }

    private static void addBook(Scanner scanner) {

        if(numBooks >= MAX_BOOKS) {
            System.out.println("Library is full. Cannot add more books,");
            return;
        }
            System.out.println("Enter book title: ");
        String title = scanner.nextLine();

            System.out.println("Enter author name: ");
            String author = scanner.nextLine();

            for(int i = 0; i < numBooks; i++) {
                if(library[i].getTitle().equalsIgnoreCase(title)) {
                    System.out.println("Book already exists in the library.");
                    return;
                }
            }

            library[numBooks] = new Book(title , author);
            numBooks++;
            System.out.println("Book added successfully. ");
    }

   private static void removeBook(Scanner scanner) {
        System.out.println("Enter book title to remove: ");
        String titleToRemove = scanner.nextLine();

        for(int i = 0; i < numBooks; i++) {
            
            if(library[i].getTitle().equalsIgnoreCase(titleToRemove)) {
                
                for(int j = i; j < numBooks - 1; j++) {
                    
                    library [j] = library[j + 1];
                }
                numBooks--;
                System.out.println("Book removed successfully.");
                return;
            }
        }

       System.out.println("Book not found in the library,");
    }
    private static void searchBook(Scanner scanner) {
        System.out.println("Enter book title or author: ");
        String searchTerm = scanner.nextLine();
    }
}

