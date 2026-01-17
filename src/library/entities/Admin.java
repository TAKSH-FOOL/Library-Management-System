package library.entities;

public class Admin extends User {
    private static int adminCount = 1;

    public static int getAdminCount() {
        return adminCount;
    }

    private static void incrementAdminCount() {
        ++adminCount;
    }

    public Admin(int id, String name, String role, String password) {
        super(id, name, role, password);
        incrementAdminCount();
    }

    public void displayInfo() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }


}
