package cn.itcast.servlet.login.bean;

public class LoginParams {
    private String username;
    private String password;

    public LoginParams(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
