package com.pluralsight;

public class Library {
    public static void main(String[] args) {
        // array holding 20 books
        Book[] books = new Book[20];
        setLibrary(books);
    }

    public static void setLibrary(Book[] books){
        books[0] = new Book(1, "ISBN1", "Kaitou Jeanne", false, "");
        books[1] = new Book(2, "ISBN2", "Psychic Princess", false, "");
        books[2] = new Book(3, "ISBN3", "Free!", false, "");
        books[3] = new Book(4, "ISBN4", "My Happy Marriage", false, "");
        books[4] = new Book(5, "ISBN5", "Sword Art Online", false, "");
        books[5] = new Book(6, "ISBN6", "BTS", false, "");
        books[6] = new Book(7, "ISBN7", "Shugo Chara", false, "");
        books[7] = new Book(8, "ISBN8", "Fruits Basket", false, "");
        books[8] = new Book(9, "ISBN9", "Twentyfive twentyone", false, "");
        books[9] = new Book(10, "ISBN10", "Singles Inferno", false, "");
        books[10] = new Book(11, "ISBN11", "Suits", false, "");
        books[11] = new Book(12, "ISBN12", "Yumeiro Patissiere", false, "");
        books[12] = new Book(13, "ISBN13", "Special A", false, "");
        books[13] = new Book(14, "ISBN14", "Attack on Titian", false, "");
        books[14] = new Book(15, "ISBN15", "Dragon Tales", false, "");
        books[15] = new Book(16, "ISBN16", "Code Geass", false, "");
        books[16] = new Book(17, "ISBN17", "Maid Sama", false, "");
        books[17] = new Book(18, "ISBN18", "Demon Slayer", false, "");
        books[18] = new Book(19, "ISBN19", "Ouran Highschool Host Club", false, "");
        books[19] = new Book(20, "ISBN20", "Sailor Moon", false, ""); // Additional book
    }

}
