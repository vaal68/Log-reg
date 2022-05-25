package com.company;

import java.util.Scanner;

public class Login extends DB {
    private static final int fall = 3;

    public Login() {
        System.out.println("Вход\n");
        LoginWindow();
    }



    public void LoginWindow() {
        boolean isCorrect = false;
        for (int i = 0; i < fall; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Имя пользователя: ");
            String name = scanner.next();
            System.out.print("Пароль: ");
            String pass = scanner.next();
            String login = name + pass;
            DB dbConOp = new DB();

            isCorrect = dbConOp.getProfile().contains(login);

            if (isCorrect) break;
            else System.err.println("\nWrong username or password. Try again. Number of attempts " + (fall - i - 1));
        }
            if (isCorrect) System.out.println("\nWelcome");
            else System.err.println("\nYou are not registered in the system");

    }

}
