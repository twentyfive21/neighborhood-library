package com.pluralsight;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        // array holding 20 books
        Book[] books = new Book[20];
        setLibrary(books);
        getAvailableBooks(books);
        getUnavailableBooks(books);
        getUserInfo(books);
    }

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
        System.out.print("What number ? ");
        int selection = scanner.nextInt();
        switch (selection) {
            case 1 : getAvailableBooks(books);
                break;
            case 2: getUnavailableBooks(books);
                break;
            case 3: quitProgram();
            default: getUserInfo(books);
        }
    }
    // available books method
    public static void getAvailableBooks(Book[] books){
        for (Book book : books ){
            if(!book.isCheckedOut()) {
                System.out.print(book.getId() + " ");
                System.out.print(book.getIsbn() + " " );
                System.out.print(book.getTitle() + " ");
                System.out.println("\n");
            }
        }
        runProgramAgain(books);
    }
    // unavailable books method
    public static void getUnavailableBooks(Book[] books){
        System.out.println("\nCHECKED OUT BOOKS");
        for (Book book : books ){
            if(book.isCheckedOut()) {
                System.out.print(book.getId() + " ");
                System.out.print(book.getIsbn() + " " );
                System.out.print(book.getTitle() + " ");
                System.out.println(book.getCheckedOutTo());
                System.out.println("\n");
            }
        }
        runProgramAgain(books);
    }
    // check in book method

    // check out book method

    // ~~~~~~~~~~~ quit program method ~~~~~
    public static void quitProgram() {
        System.out.println("\nYou have chosen to leave. \n" +
                "Please come again to Ethereal library and we hope you enjoyed your visit today!");
        System.out.println("Have a nice day! :)");
    }
    // ~~~~~~~~~~~ re-run program method  ~~~~~
    // allows user to interact again without having to re-run the program and lose changes
    public static void runProgramAgain(Book[] books){
        System.out.println("Would you like to do anything else today? ");
        getUserInfo(books);
    }
}
