package library.entities;
import java.util.Scanner;

public class ADMIN extends USER {
    private static int adminCount = 1;

    public static int getAdminCount() {
        return adminCount;
    }

    public static void incrementAdminCount() {
        ++adminCount;
    }

    public ADMIN(int id, String name, String role, String password) {
        super(id, name, role, password);
    }

    public void displayInfo() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }


}
