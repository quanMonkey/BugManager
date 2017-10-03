package com.example.dao;

import java.sql.*;

/**
 * Created by liuquan on 2017/7/7.
 */
public class TestConnection {

    public static void main(String[] args) {
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        String sql = null;
        String url = new String("jdbc:mysql://localhost:3306/part01");
        try {
            System.out.println("*");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "123456");
            sta = con.createStatement();
            sql = new String("select * from user_login");
            res = sta.executeQuery(sql);
            System.out.println("name     sex     age");
            while (res.next()) {
                System.out.print(res.getInt("loginID"));
                System.out.print("     ");
                System.out.print(res.getString("userName"));
                System.out.print("     ");
                System.out.print(res.getString("userPwd") + "\n");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException");
        } catch (Exception b) {

        } finally {
            try {
                if (con != null)
                    con.close();
                if (sta != null)
                    sta.close();
                if (res != null)
                    res.close();
            } catch (Exception e) {

            }
        }
    }
}
