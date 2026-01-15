package library.entities;

public abstract class USER {
    protected int id;
    protected String name;
    protected String Role;
    protected String password;

    protected USER(int id, String name, String Role, String password) {
        this.id = id;
        this.name = name;
        this.Role = Role;
        this.password = password;
    }

    public boolean authenticate(String name, int id, String password) {
        return this.name.equals(name)
                && this.id == id
                && this.password.equals(password); // later → hashed
    }

    abstract void displayInfo();
}
