package ua.edu.nau.icit.classes;

/**
 * Created by Alex on 23.07.2014.
 */
public class LogIn {
    String login;
    String password;

    public LogIn() {
        login = null;
        password = null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
