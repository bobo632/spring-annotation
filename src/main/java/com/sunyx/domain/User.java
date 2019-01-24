package com.sunyx.domain;

/**
 * Created by liuli on 2018/12/27.
 */
public class User {
    private String username;
    private String password;
    private String iphone;
    public User() {
    }

    public User(String username, String password, String iphone) {
        this.username = username;
        this.password = password;
        this.iphone = iphone;
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

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", iphone='" + iphone + '\'' +
                '}';
    }
}
