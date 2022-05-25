package com.company;

public class User {
    private int id;
    private String name;
    private String pass;

    public User(String login, String pass) {
        this.name = login;
        this.pass = pass;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return name;
    }

    public void setLogin(String login) {
        this.name = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
