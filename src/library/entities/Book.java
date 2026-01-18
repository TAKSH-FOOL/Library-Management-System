package library.entities;

public class Book {
    static int id = 0;
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

   public Book(String title, String author) {
        ++id;
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

   public int getBookId() {
        return bookId;
   }

   public void issueBook() {
       isIssued = true;
   }

   public boolean isIssued() {
        return isIssued;
    }

   public void returnBook() {
        isIssued = false;
    }

    public void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author +
                " | " + (isIssued ? "Issued" : "Available"));
    }


}
