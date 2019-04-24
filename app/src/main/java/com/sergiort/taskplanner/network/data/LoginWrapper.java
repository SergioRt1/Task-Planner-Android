package com.sergiort.taskplanner.network.data;

public class LoginWrapper {

    private String username;
    private String password;

    public LoginWrapper() {
    }

    public LoginWrapper(String username, String password) {
        this.username = username;
        this.password = password;
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
