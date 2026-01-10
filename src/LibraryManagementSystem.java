import java.util.Scanner;
public class LibraryManagementSystem {

    static Book[] books = new Book[10000];
    static Member[] members = new Member[1000];
    static Admin[] admins = new Admin[10];
    static int bookCount = 0;
    static int memberCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (;;) {
            System.out.println("Welcome to the Library Management System");
            System.out.println("----------------------------------------");
            System.out.println("please select your Role to continue:");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.println("1. Login as Admin");
                System.out.println("2. Register as Admin");
                int adminOption = sc.nextInt();
                sc.nextLine();

                if (adminOption == 1) {
                    System.out.println("--- Admin Login ---");
                    System.out.print("Enter Admin ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Admin Name: ");
                    String name = sc.nextLine();
                    boolean loggedIn = Admin.login(admins, id, name);
                    if (!loggedIn) {
                        System.out.println("Exiting...");
                        return;
                    }
                } else if (adminOption == 2) {
                    System.out.println("--- Admin Registration ---");
                    System.out.print("Enter Admin ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Admin Name: ");
                    String name = sc.nextLine();
                    Admin.register(admins, id, name);
                }

                System.out.println("\n--- Library Management System ---");
                System.out.println("1. Add Book");
                System.out.println("2. Register Member");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. View Books");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        addMember();
                        break;
                    case 3:
                        issueBook();
                        break;
                    case 4:
                        returnBook();
                        break;
                    case 5:
                        viewBooks();
                        break;
                    case 6:
                        System.out.println("System Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }

            } else if (option == 2) {
                System.out.println("1. Login as Admin");
                System.out.println("2. Register as Admin");
                int adminOption = sc.nextInt();
                sc.nextLine();

                if (adminOption == 1) {
                    System.out.println("--- Admin Login ---");
                    System.out.print("Enter Admin ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Admin Name: ");
                    String name = sc.nextLine();
                    boolean loggedIn = Admin.login(admins, id, name);
                    if (!loggedIn) {
                        System.out.println("Exiting...");
                        return;
                    }
                } else if (adminOption == 2) {
                    System.out.println("--- Admin Registration ---");
                    System.out.print("Enter Admin ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Admin Name: ");
                    String name = sc.nextLine();
                    Admin.register(admins, id, name);
                }
            }

            Admin admin = new Admin(1, "Admin");
            admin.displayInfo();

            while (true) {
                System.out.print("Enter your role (ADMIN/MEMBER): ");
                String role = sc.nextLine().toUpperCase();
                if (admin.isAdmin()) {

                } else {
                    System.out.println("Access denied. Only admins can perform these actions.");
                }
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books[bookCount++] = new Book(id, title, author);
        System.out.println("Book Added Successfully");
    }

    static void addMember() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        members[memberCount++] = new Member(id, name);
        System.out.println("Member Registered Successfully");
    }

    static void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId() == id) {
                if (!books[i].isIssued()) {
                    books[i].issueBook();
                    System.out.println("Book Issued Successfully");
                } else {
                    System.out.println("Book Already Issued");
                }
                return;
            }
        }
        System.out.println("Book Not Found");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId() == id) {
                books[i].returnBook();
                System.out.println("Book Returned Successfully");
                return;
            }
        }
        System.out.println("Book Not Found");
    }

    static void viewBooks() {
        System.out.println("\nBook ID | Title | Author | Status");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBook();
        }
    }
}
