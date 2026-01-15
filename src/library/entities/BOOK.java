package library.entities;

public class BOOK {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

   public BOOK(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

   public int getBookId() {
        return bookId;
    }


   public boolean isIssued() {
        return isIssued;
    }

   public void issueBook() {
        isIssued = true;
    }


   public void returnBook() {
        isIssued = false;
    }

    public void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author +
                " | " + (isIssued ? "Issued" : "Available"));
    }


}
