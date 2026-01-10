class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    int getBookId() {
        return bookId;
    }

    boolean isIssued() {
        return isIssued;
    }

    void issueBook() {
        isIssued = true;
    }

    void returnBook() {
        isIssued = false;
    }

    void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author +
                " | " + (isIssued ? "Issued" : "Available"));
    }


}
