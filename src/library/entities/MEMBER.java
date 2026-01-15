package library.entities;
import java.util.Scanner;

public class MEMBER extends USER {
    static int memebrCount = 1;

    public static int getMemebrCount() {
        return memebrCount;
    }

    public static void incrementMemberCount() {
        ++memebrCount;
    }

    public MEMBER(int id, String name, String role, String password) {
        super(id, name, role, password);
    }

    public void displayInfo(){
        System.out.println("Member ID: " + id + ", Name: " + name);
    }

}
