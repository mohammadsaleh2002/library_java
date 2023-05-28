package mypackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLib myLib = new MyLib();


        Admin defaultAdmin = new Admin(01, "admin", "password");
        myLib.Admins.add(defaultAdmin);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (myLib.Login(username, password)) {
            if (myLib.currentUser instanceof Admin) {
                System.out.println("Admin logged in successfully.");
            } else if (myLib.currentUser instanceof User) {
                System.out.println("User logged in successfully.");
            }

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Register User");
                System.out.println("2. Register Book");
                System.out.println("3. Search Book");
                System.out.println("4. Reserve Book");
                System.out.println("5. Return Book");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                myLib.Menu(choice);
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
}
