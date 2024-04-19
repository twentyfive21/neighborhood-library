package com.pluralsight;
// This class is used to create a book object.
public class Book {
    // class properties
   private int id;
   private String isbn;
   private String title;
   private boolean isCheckedOut;
   private String checkedOutTo;
   // constructor
    public Book(int id, String isbn, String title, boolean isCheckedOut,
                String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }
    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
    // override toString
    @Override
    public String toString() {
        return "Book id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo='" + checkedOutTo + '\'';
    }
    // methods
    public void checkOut (String name) {
        setCheckedOutTo(name);
        setCheckedOut(true);
    }
    public void checkIn () {
        setCheckedOutTo("");
        setCheckedOut(false);
    }
}
