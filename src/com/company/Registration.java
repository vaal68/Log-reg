package com.company;

import java.util.Scanner;

public class Registration {

    private String name;
    private String pass;


    public void registrationWindow() {
        System.out.println("Регистрация\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя пользователя: ");
        this.name = scanner.next();
        System.out.print("Пароль: ");
        this.pass = scanner.next();
        singUpNewUser();



    }

    private void singUpNewUser() {
        User user = new User(name,pass);
        DBConnection dbReg = new DBConnection();
        dbReg.singUpUser(user);
    }

}
