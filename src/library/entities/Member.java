package library.entities;

public class Member extends User {
    static int memebrCount = 1;

    public static int getMemebrCount() {
        return memebrCount;
    }

    public static void incrementMemberCount() {
        ++memebrCount;
    }

    public Member(int id, String name, String role, String password) {
        super(id, name, role, password);
    }

    public void displayInfo(){
        System.out.println("Member ID: " + id + ", Name: " + name);
    }

}
