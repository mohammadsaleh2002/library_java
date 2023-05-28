package mypackage;

class Admin extends Users {
    private String password;
    private boolean active;
    private String type;

    public Admin(int ID, String username, String password) {
        super(ID, username);
        this.password = password;
        this.active = true;
        this.type = "admin";
    }

    public String getPassword() {
        return password;
    }
}

