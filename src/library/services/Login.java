package library.services;

import library.entities.Admin;
import library.entities.Member;

import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);

    public Admin adminLogin(Admin[] adminArray, int i) {

        if(i<5){
            System.out.print("enter your name : ");
            String name = sc.nextLine();
            System.out.print("enter your id : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("enter your password : ");
            String password = sc.nextLine();
            Admin admin = authenticateAdmin(adminArray, name, id, password);
            if (admin != null) {
                System.out.println("Login successful. Welcome, " + name + "!");
                return admin;
            }
            else {
                System.out.println("Login failed. Invalid credentials.");
                return adminLogin(adminArray, i+1);
            }
        }
        System.out.println("Today's limit are over, come Tomorrow");
        return null;
    }

    public Admin adminRegister(Admin[] adminArray) {

        System.out.print("enter your name : ");
        String name = sc.nextLine();
        int id =0;
        while (true){
            System.out.print("enter id : ");
            id = sc.nextInt();
            sc.nextLine();
            if(isAdminIdExists(adminArray, id)){
                System.out.println("please enter another ID it is already used");
            }
            else{
                break;
            }
        }
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        for (int i = 0; i < adminArray.length; i++) {
            if (adminArray[i] == null) {
                adminArray[i] = new Admin(id, name, "Admin", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                return adminArray[i];
            }
        }
        System.out.println("Registration failed. No available slots.");
        return null;
    }

    Admin authenticateAdmin(Admin[] adminArray, String name, int id, String password) {
        for (Admin admin : adminArray) {
            if (admin != null && admin.authenticate(name, id, password)) {
                return admin;
            }
        }
        return null;
    }

    public Member memberLogin(Member[] memberArray, int i) {
        if(i<5){
            System.out.print("enter your name : ");
            String name = sc.nextLine();
            System.out.print("enter your id : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("enter your password : ");
            String password = sc.nextLine();
            Member member = authenticateMember(memberArray, name, id, password);
            if (member != null) {
                System.out.println("Login successful. Welcome, " + name + "!");
                return member;
            }
            else {
                System.out.println("Login failed. Invalid credentials.");
                return memberLogin(memberArray, i+1);
            }
        }
        System.out.println("Today's limit are over, come Tomorrow");
        return null;
    }

    public Member memberRegister(Member[] memberArray) {

        System.out.print("enter your name : ");
        String name = sc.nextLine();
        int id =0;
        while (true){
            System.out.print("enter id : ");
            id = sc.nextInt();
            sc.nextLine();
            if(isMemberIdExists(memberArray, id)){
                System.out.println("please enter another ID it is already used");
            }
            else{
                break;
            }
        }
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        for (int i = 0; i < memberArray.length; i++) {
            if (memberArray[i] == null) {
                memberArray[i] = new Member(id, name, "Member", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                return memberArray[i];
            }
        }
        System.out.println("Registration failed. No available slots.");
        return null;
    }

    Member authenticateMember(Member[] memberArray, String name, int id, String password) {
        for (Member member : memberArray) {
            if (member != null && member.authenticate(name, id, password)) {
                return member;
            }
        }
        return null;
    }

    private boolean isAdminIdExists(Admin [] adminArray, int id) {
        for (int i = 0; i < adminArray.length; i++) {
            if(adminArray[i] != null && adminArray[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    private boolean isMemberIdExists(Member [] memberArray, int id) {
        for (int i = 0; i < memberArray.length; i++) {
            if(memberArray[i] != null && memberArray[i].getId() == id){
                return true;
            }
        }
        return false;
    }

}
