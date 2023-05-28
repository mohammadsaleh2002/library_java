package mypackage;

import java.util.Scanner;

class MyLib implements Library {
    public Users currentUser;

    @Override
    public void Menu(int number) {
        switch (number) {
            case 1:
                RegisterUser();
                break;
            case 2:
                if (currentUser instanceof Admin)
                    RegisterBook();
                else
                    System.out.println("Access denied. Only admins can register books.");
                break;
            case 3:
                SearchBook();
                break;
            case 4:
                ReserveBook();
                break;
            case 5:
                ReturnBook();
                break;
            case 7:
                Book.list();
                break;
            case 8:
                System.out.println(Book.getResCount());
            case 6:
                System.out.println("Exiting the program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void RegisterUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter ID: ");
        int ID = scanner.nextInt();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        User newUser = new User(ID, username, age);
        Users.add(newUser);
        System.out.println("User registered successfully.");
    }

    private void RegisterBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book abstract: ");
        String abstractText = scanner.nextLine();
        System.out.print("Enter book ageGroup: ");
        String ageGroup = scanner.nextLine();
        System.out.print("Enter book status: ");
        String status = scanner.nextLine();

        Book book1 = new Book();
        book1.Register(ISBN , name , author , abstractText ,ageGroup, status);
        System.out.println("Book registered successfully.");

    }

    private void SearchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by:");
        System.out.println("1. ISBN");
        System.out.println("2. Name");
        System.out.println("3. Author");
        System.out.println("4. Abstract");
        System.out.print("Enter search type: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();

        String result = SearchBook(type, keyword);
        if (result != null) {
            System.out.println("Book found!");
            System.out.println("ISBN: " + result);
        } else {
            System.out.println("Book not found!");
        }
    }

    @Override
    public  String SearchBook(int type, String keyword) {
        for (Book book : Books) {
            switch (type) {
                case 1:
                    if (book.getISBN().equals(keyword))
                        return book.getISBN();
                    break;
                case 2:
                    if (book.getName().equals(keyword))
                        return book.getISBN();
                    break;
                case 3:
                    if (book.getAuthor().equals(keyword))
                        return book.getISBN();
                    break;
                case 4:
                    if (book.getAbstractText().matches("(?i).*" + keyword + ".*"))
                        return book.getISBN();
                    break;
                default:
                    return null;
            }
        }
        return null;
    }

    @Override
    public boolean Login(String username, String password) {
        for (Admin admin : Admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                currentUser = admin;
                return true;
            }
        }

        for (User user : Users) {
            if (user.getUsername().equals(username)) {
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    private void ReserveBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userID = scanner.nextLine();

        if (SearchBook(1, ISBN) != null) {
            if (AgeOK(ISBN, userID)) {
                if (!IsReserved(ISBN)) {
                    for (Book book : Books) {
                        if (book.getISBN().equals(ISBN)) {
                            book.setReserved(true);
                            book.setReservedBy(userID);
                            book.incrementResCount();
                            WriteStatus(book);
                            System.out.println("Book reserved successfully.");
                            return;
                        }
                    }
                } else {
                    System.out.println("Book is already reserved.");
                }
            } else {
                System.out.println("Age does not meet the book's age range requirement.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private boolean AgeOK(String ISBN, String userID) {

        return true;
    }

    private boolean IsReserved(String ISBN) {
        for (Book book : Books) {
            if (book.getISBN().equals(ISBN)) {
                return book.isReserved();
            }
        }
        return false;
    }

    private void WriteStatus(Book book) {

    }

    private void ReturnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userID = scanner.nextLine();

        if (IsReserved(ISBN)) {
            for (Book book : Books) {
                if (book.getISBN().equals(ISBN) && book.getReservedBy().equals(userID)) {
                    book.setReserved(false);
                    book.setReservedBy("");
                    book.decrementResCount();
                    WriteStatus(book);
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
            System.out.println("Book is not reserved by the specified user.");
        } else {
            System.out.println("Book is not reserved.");
        }
    }

    @Override
    public void ReserveBook(String ISBN, String userID) {

    }

    @Override
    public void ReturnBook(String ISBN, String userID) {
    }
}
