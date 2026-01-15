package library.app;

import library.entities.BOOK;
import library.entities.LOGIN;
import library.entities.MEMBER;
import library.entities.ADMIN;

import java.util.Scanner;
public class LibraryManagementSystem {

    static BOOK[] books = new BOOK[10000];
    static MEMBER[] members = new MEMBER[1000];
    static ADMIN[] admins = new ADMIN[10];
    static int bookCount = 0;
    static int memberCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for(;true;){
            System.out.println("Welcome to the Library Management System");
            System.out.println("select your role:");
            System.out.println("1. ADMIN");
            System.out.println("2. MEMBER");
            System.out.println("3. EXIT");
            int roleChoice = sc.nextInt();
            if(roleChoice == 1){
                System.out.println("1. LOGIN");
                System.out.println("2. REGISTER");
                int adminChoice = sc.nextInt();
                if(adminChoice == 1){
                    LOGIN admin = new LOGIN();
                    admin.adminLogin(admins);
                }
                else if(adminChoice == 2){
                    LOGIN admin = new LOGIN();
                    admin.adminRegister(admins);
                }
            }
            else if(roleChoice == 2){
                System.out.println("1. LOGIN");
                System.out.println("2. REGISTER");
                int memberChoice = sc.nextInt();
                if(memberChoice == 1){
                    LOGIN member = new LOGIN();
                    member.memberLogin(members);
                }
                else if(memberChoice == 2){
                    LOGIN member = new LOGIN();
                    member.memberRegister(members);
                }
            }
        }
    }
}
