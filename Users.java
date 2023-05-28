package mypackage;

import java.time.LocalDateTime;

class Users {
    public int ID;
    protected LocalDateTime regTime;
    private String username;

    public Users(int ID, String username) {
        this.ID = ID;
        this.username = username;
        this.regTime = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }


}

