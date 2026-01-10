import java.util.Scanner;

class Admin extends User {

    Admin(int id, String name, String role) {
        super(id, name, role);
    }

    void displayInfo() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }

    boolean isRegistered() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        int inputId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String inputName = sc.nextLine();
        return (inputId == id && inputName.equals(name));
    }

    public static Admin authenticate(Admin[] admins, int checkId, String checkName) {
        if (admins == null) return null;
        for (Admin a : admins) {
            if (a != null && a.matches(checkId, checkName)) {
                return a;
            }
        }
        return null;
    }

    public static boolean login(Admin[] admins, int checkId, String checkName) {
        Admin found = authenticate(admins, checkId, checkName);
        if (found != null) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Login Failed");
            return false;
        }
    }

    private boolean matches(int checkId, String checkName) {
        return this.id == checkId && this.name.equals(checkName);
    }

    public static void register(Admin[] admins, int id, String name) {
        for (int i = 0; i < admins.length; i++) {
            if (admins[i] == null) {
                admins[i] = new Admin(id, name, "ADMIN");
                System.out.println("Admin Registered Successfully");
                return;
            }
        }
        System.out.println("Registration Failed: No available slots");
    }
}
