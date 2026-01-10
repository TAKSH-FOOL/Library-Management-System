import java.util.Scanner;

class Member extends User {
    Member(int id, String name, String role) {
        super(id, name, role);
    }

    void displayInfo(){
        System.out.println("Member ID: " + id + ", Name: " + name);
    }

    boolean isRegistered() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Member ID: ");
        int inputId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Member Name: ");
        String inputName = sc.nextLine();
        return (inputId == id && inputName.equals(name));
    }

    public static void register(Member[] members, int id, String name) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                members[i] = new Member(id, name, "MEMBER");
                System.out.println("Member Registered Successfully");
                return;
            }
        }
        System.out.println("Registration Failed: No available slots");
    }

    private boolean matches(int checkId, String checkName) {
        return this.id == checkId && this.name.equals(checkName);
    }

    public static Member authenticate(Member[] members, int checkId, String checkName) {
        if (members == null) return null;
        for (Member a : members) {
            if (a != null && a.matches(checkId, checkName)) {
                return a;
            }
        }
        return null;
    }
    
    public static boolean login(Member[] members, int checkId, String checkName) {
        Member found = authenticate(members, checkId, checkName);
        if (found != null) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Login Failed");
            return false;
        }
    }
}
