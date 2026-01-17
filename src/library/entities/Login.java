package library.entities;

import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);

    public void adminLogin(Admin[] adminArray) {
        System.out.print("enter your name : ");
        String name = sc.nextLine();
        System.out.print("enter your id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        Admin admin = authenticateAdmin(adminArray, name, id, password);
        if (admin != null) {
            System.out.println("Login successful. Welcome, " + admin.name + "!");
        }
        else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    public void adminRegister(Admin[] adminArray) {

        System.out.print("enter your name : ");
        String name = sc.nextLine();
        int id = Admin.getAdminCount();
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        for (int i = 0; i < adminArray.length; i++) {
            if (adminArray[i] == null) {
                adminArray[i] = new Admin(id, name, "Admin", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                return;
            }
        }
        System.out.println("Registration failed. No available slots.");
    }

    Admin authenticateAdmin(Admin[] adminArray, String name, int id, String password) {
        for (Admin admin : adminArray) {
            if (admin != null && admin.authenticate(name, id, password)) {
                return admin;
            }
        }
        return null;
    }

    public void memberLogin(Member[] memberArray) {
        System.out.print("enter your name : ");
        String name = sc.nextLine();
        System.out.print("enter your id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        Member member = authenticateMember(memberArray, name, id, password);
        if (member != null) {
            System.out.println("Login successful. Welcome, " + member.name + "!");
        }
        else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    public void memberRegister(Member[] memberArray) {

        System.out.print("enter your name : ");
        String name = sc.nextLine();
        int id = Member.getMemebrCount();
        Member.incrementMemberCount();
        System.out.print("enter your password : ");
        String password = sc.nextLine();
        for (int i = 0; i < memberArray.length; i++) {
            if (memberArray[i] == null) {
                memberArray[i] = new Member(id, name, "Member", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                return;
            }
        }
        System.out.println("Registration failed. No available slots.");
    }

    Member authenticateMember(Member[] memberArray, String name, int id, String password) {
        for (Member member : memberArray) {
            if (member != null && member.authenticate(name, id, password)) {
                return member;
            }
        }
        return null;
    }

}
