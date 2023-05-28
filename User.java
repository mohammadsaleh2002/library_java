package mypackage;

import java.time.LocalDateTime;

class User extends Users {
    private int age;
    private String reserved;

    public User(int ID, String username, int age) {
        super(ID, username);
        this.age = age;
        this.reserved = "";
        this.regTime = LocalDateTime.now();
    }

    public boolean isReserved(String ISBN) {
        return reserved == ISBN;
    }
}
