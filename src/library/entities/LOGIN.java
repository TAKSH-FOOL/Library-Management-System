package library.entities;

import java.util.Scanner;

public class LOGIN {
    Scanner sc = new Scanner(System.in);

    public void adminLogin(ADMIN [] adminArray) {
        System.out.println("enter your name : ");
        String name = sc.nextLine();
        System.out.println("enter your id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter your password : ");
        String password = sc.nextLine();
        ADMIN admin = authenticateAdmin(adminArray, name, id, password);
        if (admin != null) {
            System.out.println("Login successful. Welcome, " + admin.name + "!");
        }
        else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    public void adminRegister(ADMIN [] adminArray) {

        System.out.println("enter your name : ");
        String name = sc.nextLine();
        int id = ADMIN.getAdminCount();
        ADMIN.incrementAdminCount();
        sc.nextLine();
        System.out.println("enter your password : ");
        String password = sc.nextLine();
        for (int i = 0; i < adminArray.length; i++) {
            if (adminArray[i] == null) {
                adminArray[i] = new ADMIN(id, name, "ADMIN", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                break;
            }
        }
        System.out.println("Registration failed. No available slots.");
    }

    ADMIN authenticateAdmin(ADMIN[] adminArray, String name, int id, String password) {
        for (ADMIN admin : adminArray) {
            if (admin != null && admin.authenticate(name, id, password)) {
                return admin;
            }
        }
        return null;
    }

    public void memberLogin(MEMBER [] memberArray) {
        System.out.println("enter your name : ");
        String name = sc.nextLine();
        System.out.println("enter your id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter your password : ");
        String password = sc.nextLine();
        MEMBER member = authenticateMember(memberArray, name, id, password);
        if (member != null) {
            System.out.println("Login successful. Welcome, " + member.name + "!");
        }
        else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    public void memberRegister(MEMBER [] memberArray) {

        System.out.println("enter your name : ");
        String name = sc.nextLine();
        int id = MEMBER.getMemebrCount();
        MEMBER.incrementMemberCount();
        sc.nextLine();
        System.out.println("enter your password : ");
        String password = sc.nextLine();
        for (int i = 0; i < memberArray.length; i++) {
            if (memberArray[i] == null) {
                memberArray[i] = new MEMBER(id, name, "MEMBER", password);
                System.out.println("Registration successful. Welcome, " + name + "!");
                break;
            }
        }
        System.out.println("Registration failed. No available slots.");
    }

    MEMBER authenticateMember(MEMBER[] memberArray, String name, int id, String password) {
        for (MEMBER member : memberArray) {
            if (member != null && member.authenticate(name, id, password)) {
                return member;
            }
        }
        return null;
    }

}
