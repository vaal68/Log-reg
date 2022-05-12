package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection extends ConfigsDB{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException,SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

        public void singUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_LOGIN + "," + Const.USERS_PASS + ")" +
                "VALUES(?,?)";


            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, user.getLogin());
                prSt.setString(2, user.getPass());
                prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        public ArrayList<String> getUser(){
        ResultSet resSet;
        ArrayList <String> profile1 = new ArrayList<>();
        String select = "SELECT * FROM "+ Const.USER_TABLE;
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                resSet = prSt.executeQuery();
                while (resSet.next()) {
                    User user = new User();
                    user.setId(resSet.getInt(Const.USERS_ID));
                    user.setLogin(resSet.getString(Const.USERS_LOGIN));
                    user.setPass(resSet.getString(Const.USERS_PASS));
                    String login = user.getLogin() + user.getPass();
                    profile1.add(login);
                    System.out.println(login);
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return profile1;
        }

    }


