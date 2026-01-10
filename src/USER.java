abstract class User {
    protected int id;
    protected String name;
    protected String Role;

    User(int id, String name, String Role) {
        this.id = id;
        this.name = name;
        this.Role = Role;
    }

    boolean isAdmin() {
        return Role.equals("ADMIN");
    }
    boolean isMember() {return Role.equals("MEMBER");}
    abstract void displayInfo();
}
