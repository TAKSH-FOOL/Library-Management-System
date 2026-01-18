package library.app;

import library.entities.*;
import library.services.Login;
import library.services.Menu;
import library.services.BookService;
import library.services.MemberService;


import java.util.Scanner;
public class LibraryManagementSystem {

    static Book[] books = new Book[10000];
    static Member[] members = new Member[1000];
    static Admin[] admins = new Admin[10];
    static int bookCount = 0;
    static int memberCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Login login = new Login();
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        while (true){
            System.out.println("Welcome to the Library Management System");
            Menu.roleMenu();
            int roleChoice = sc.nextInt();

            Admin isAdmin = null;
            Member isMember = null;
            if(roleChoice == 1){
                Menu.authOption();
                int adminChoice = sc.nextInt();
                if(adminChoice == 1){
                     isAdmin = login.adminLogin(admins,0);
                }
                else if (adminChoice == 2){
                     isAdmin =  login.adminRegister(admins);
                }
                else {
                    System.out.println("invalid choice");
                }
                if (isAdmin != null){
                    while (true){
                        Menu.adminMenu();
                        int functionChoice = sc.nextInt();
                        if(functionChoice == 1){
                            switch (functionChoice){
                                case 1:{
                                    bookService.addBook(books);
                                    break;
                                }
                                case 2:{
                                    bookService.viewBook(books);
                                    break;
                                }
                                case 3:{
                                    memberService.viewMembers(members);
                                    break;
                                }
                                case 4:{
                                    memberService.removeMember(members);
                                    break;
                                }
                                case 5:{
                                    System.exit(0);
                                }
                                default:{
                                    System.out.println("invalid choice");
                                }
                            }
                        }
                    }

                }
            }
            else if(roleChoice == 2){
                Menu.authOption();
                int memberChoice = sc.nextInt();
                if(memberChoice == 1){
                    isMember = login.memberLogin(members,0);
                }
                else if(memberChoice == 2){
                   isMember =  login.memberRegister(members);
                }
                else  {
                    System.out.println("invalid choice");
                }
                if (isMember != null){
                    while (true){
                        Menu.memberMenu();
                        int functionChoice = sc.nextInt();
                        switch (functionChoice){
                            case 1:{
                                bookService.issueBook(books);
                                break;
                            }
                            case 2:{
                                bookService.returnBook(books);
                                break;
                            }
                        }
                    }
                }
            }
            break;
        }
    }
}
