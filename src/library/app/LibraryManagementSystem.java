package library.app;

import library.entities.BOOK;
import library.entities.Login;
import library.entities.Member;
import library.entities.Admin;

import java.util.Scanner;
public class LibraryManagementSystem {

    static BOOK[] books = new BOOK[10000];
    static Member[] members = new Member[1000];
    static Admin[] admins = new Admin[10];
    static int bookCount = 0;
    static int memberCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for(;true;){
            System.out.println("Welcome to the Library Management System");
            System.out.println("select your role:");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.print("Enter your choice: ");
            int roleChoice = sc.nextInt();
            if(roleChoice == 1){
                System.out.println("1. Login");
                System.out.println("2. REGISTER");
                System.out.print("Enter your choice: ");
                int adminChoice = sc.nextInt();
                if(adminChoice == 1){
                    Login admin = new Login();
                    admin.adminLogin(admins);
                    return;
                }
                else if(adminChoice == 2){
                    Login admin = new Login();
                    admin.adminRegister(admins);
                    return;
                }
            }
            else if(roleChoice == 2){
                System.out.println("1. Login");
                System.out.println("2. REGISTER");
                System.out.print("Enter your choice: ");
                int memberChoice = sc.nextInt();
                if(memberChoice == 1){
                    Login member = new Login();
                    member.memberLogin(members);
                    return;
                }
                else if(memberChoice == 2){
                    Login member = new Login();
                    member.memberRegister(members);
                    return;
                }
            }
        }
    }
}
