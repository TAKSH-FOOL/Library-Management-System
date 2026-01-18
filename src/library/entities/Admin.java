package library.entities;

public class Admin extends User {

    public Admin(int id, String name, String role, String password) {
        super(id, name, role, password);
    }

    public void displayInfo() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }


}
