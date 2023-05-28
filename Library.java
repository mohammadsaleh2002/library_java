package mypackage;


import java.util.ArrayList;
import java.util.List;

interface Library {
    ArrayList<Book> Books = new ArrayList<Book>();
    ArrayList<Admin> Admins = new ArrayList<Admin>();
    ArrayList<User> Users = new ArrayList<User>();

    void Menu(int number);

    String  SearchBook(int type, String keyword);

    boolean Login(String username, String password);

    void ReserveBook(String ISBN, String userID);

    void ReturnBook(String ISBN, String userID);
}

