package com.pluralsight;
import java.util.Scanner;
public class Library {
    public static void main(String[] args) {
        // array holding 20 books
        Book[] books = new Book[20];
        setLibrary(books);
        getUserInfo(books);
    }
    // preset library with 20 books for the user
    public static void setLibrary(Book[] books){
        books[0] = new Book(1, "ISBN1", "Kaitou Jeanne", false, "");
        books[1] = new Book(2, "ISBN2", "Psychic Princess", false, "");
        books[2] = new Book(3, "ISBN3", "Free!", false, "");
        books[3] = new Book(4, "ISBN4", "My Happy Marriage", false, "");
        books[4] = new Book(5, "ISBN5", "Sword Art Online", false, "");
        books[5] = new Book(6, "ISBN6", "BTS", true, "Jin");
        books[6] = new Book(7, "ISBN7", "Shugo Chara", false, "");
        books[7] = new Book(8, "ISBN8", "Fruits Basket", false, "");
        books[8] = new Book(9, "ISBN9", "Twentyfive twentyone", false, "");
        books[9] = new Book(10, "ISBN10", "Singles Inferno", true, "Wonho");
        books[10] = new Book(11, "ISBN11", "Suits", true, "Edgar");
        books[11] = new Book(12, "ISBN12", "Yumeiro Patissiere", false, "");
        books[12] = new Book(13, "ISBN13", "Special A", false, "");
        books[13] = new Book(14, "ISBN14", "Attack on Titian", false, "");
        books[14] = new Book(15, "ISBN15", "Dragon Tales", true, "Madeline");
        books[15] = new Book(16, "ISBN16", "Code Geass", false, "");
        books[16] = new Book(17, "ISBN17", "Maid Sama", false, "");
        books[17] = new Book(18, "ISBN18", "Demon Slayer", true, "Catherine");
        books[18] = new Book(19, "ISBN19", "Ouran Highschool Host Club", false, "");
        books[19] = new Book(20, "ISBN20", "Sailor Moon", true, "Luna"); // Additional book
    }
    // get user info method
    public static void getUserInfo(Book[] books){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Ethereal library!\n~ Please choose an option below ~ "+
                "\n(1) Show Available Books"+"\n(2) Show Checked out books"
                +"\n(3) Exit Library\n" + "Selection: ");
        int selection = scanner.nextInt();
        // clear leftover CRLF in buffer
        scanner.nextLine();
        switch (selection) {
            case 1 : getAvailableBooks(books,scanner);
                break;
            case 2: getUnavailableBooks(books,scanner);
                break;
            case 3: quitProgram();
            break;
            default: System.out.println("Error Please choose one of the 3 options");
                getUserInfo(books);
                break;
        }
    }
    // available books method
    public static void getAvailableBooks(Book[] books, Scanner scanner){
        System.out.println("\n~~~~~~~~~ Available Books ~~~~~~~~~\n");
        for (Book book : books ){
            if(!book.isCheckedOut()) {
                System.out.print("Book ID: " + book.getId() + " \n");
                System.out.print("Book ISBN: " + book.getIsbn() + " \n" );
                System.out.print("Book Title: " + book.getTitle() + " \n");
                System.out.println("\n");
            }
        }
        System.out.println("\n~~~~~~~~~ End of available books ~~~~~~~~~\n");
        System.out.println("Would you like to check out a book today? Yes(y) or No(n)\n");
        System.out.print("Selection: ");
        String choice = scanner.nextLine().toLowerCase().trim();
        switch (choice){
            case "y": checkOutBook(scanner, books);
                    break;
            case "n": getUserInfo(books);
                    break;
            default : System.out.println("Error Please choose Y(yes) or N(no)");
                    getUserInfo(books);
                    break;
        }
    }
    // unavailable books method
    public static void getUnavailableBooks(Book[] books, Scanner scanner){
        System.out.println("\n~~~~~~~~~ Unavailable Books ~~~~~~~~~\n");
        for (Book book : books ){
            if(book.isCheckedOut()) {
                System.out.print("Book ID: " + book.getId() + " \n");
                System.out.print("Book ISBN: " + book.getIsbn() + " \n" );
                System.out.print("Book Title: " + book.getTitle() + " \n");
                System.out.println("Book currently checked out by: "
                        + book.getCheckedOutTo() + "\n");
            }
        }
        System.out.println("\n~~~~~~~~~ End of unavailable books ~~~~~~~~~\n");
        System.out.println("Would you like to check in a book today? Yes(y) or No(n)\n");
        System.out.print("Selection: ");
        String choice = scanner.nextLine().toLowerCase().trim();
        switch (choice){
            case "y": checkInBook(scanner, books);
                break;
            case "n":  getUserInfo(books);
                break;
            default :
                System.out.println("Error Please choose Yes(y) or No(n)");
                getUserInfo(books);
                break;
        }
    }
    // check in book method
    public static void checkInBook(Scanner scanner, Book[] books){
        System.out.print("Provide the Book ID of the book you wish to check in: ");
        int bookNum = scanner.nextInt();
        scanner.nextLine();
        bookNum = bookNum - 1;
        // if book is checked out then allow user to check in
        if (books[bookNum].isCheckedOut()){
            books[bookNum].checkIn("");
            System.out.println("\nCheck In Details: \n" +"Book ID: "+books[bookNum].getId()
                    + "\nBook Title: "+ books[bookNum].getTitle() + "\n");
        } else {
            System.out.println("\nBook is already checked in.");
        }
        runProgramAgain(books);
    }
    // check out book method
    public static void checkOutBook(Scanner scanner, Book[] books){
        System.out.print("Provide the Book ID of the book you wish to check out: ");
        int bookNum = scanner.nextInt();
        // array is zero indexed subtract 1 to get correct book id index
        bookNum = bookNum - 1;
        scanner.nextLine();
        System.out.print("Please provide your name for checkout: ");
        String nameOfCheckoutPerson = scanner.nextLine().trim();
        // if book is not checked out then allow user to check it out
        if (!books[bookNum].isCheckedOut()){
            books[bookNum].checkOut(nameOfCheckoutPerson);
            System.out.println("\nCheckout Details: \n" +"Book ID: "+books[bookNum].getId()
                    + "\nBook Title: "+ books[bookNum].getTitle() + "\nChecked out Person: "
                    + books[bookNum].getCheckedOutTo() + "\n");
        } else {
            System.out.println("This book is already checked out\n" +
                    "Please view our available books selection again!\n");
        }
        runProgramAgain(books);
    }
    // ~~~~~~~~~~~ quit program method ~~~~~
    public static void quitProgram() {
        System.out.println("\nYou have chosen to leave. \n" +
                "Please come again to Ethereal library and we hope you enjoyed your visit today!");
        System.out.println("Have a nice day! :)");
    }
    // ~~~~~~~~~~~ re-run program method  ~~~~~
    // allows user to interact again without having to re-run the program and lose changes
    public static void runProgramAgain(Book[] books){
        System.out.println("~~~ Would you like to do anything else today? ~~~");
        getUserInfo(books);
    }
}