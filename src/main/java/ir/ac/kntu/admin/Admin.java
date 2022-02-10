package ir.ac.kntu.admin;

import java.util.Objects;

public class Admin {
    private String userName;

    private String password;

    public Admin(String userName, String password) {
        userName = userName.toLowerCase().trim();
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public boolean logIn(String userName, String password) {
        userName = userName.toLowerCase().trim();
        return this.userName.equals(userName) && this.password.equals(password);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Admin admin = (Admin) object;
        return Objects.equals(getUserName(), admin.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName());
    }
}
