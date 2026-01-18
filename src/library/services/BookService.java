package library.services;
import library.entities.Book;

import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);
    public void addBook(Book[] books) {
        System.out.print("enter the book Title : ");
        String bookTitle = sc.next();
        System.out.print("enter the book Author : ");
        String bookAuthor = sc.nextLine();
        for (Book book : books) {
            if(book == null){
                book = new Book(bookTitle,bookAuthor);
            }
        }
    }

    public void viewBook(Book [] books){
        for(int i = 0; i < books.length; i++){
            if(books[i].isIssued() == true){
                books[i].displayBook();
            }
        }
        for(int i = 0; i < books.length; i++){
            if(books[i].isIssued() == false){
                books[i].displayBook();
            }
        }
    }

    public void removeBook(Book[] books){
        System.out.print("enter the book Id you want to remove : ");
        int bookId = sc.nextInt();
        for(Book book : books){
            book = null;
        }
    }

    public void issueBook(Book[] books){
        System.out.print("enter the book Id you want to issue : ");
        int bookId = sc.nextInt();
        for(Book book : books){
            if(book.getBookId() == bookId){
                book.issueBook();
            }
        }
    }

    public void returnBook(Book[] books){
        System.out.print("enter the book Id you want to return : ");
        int bookId = sc.nextInt();
        for(Book book : books){
            if(book.getBookId() == bookId){
                book.returnBook();
            }
        }
    }
}
