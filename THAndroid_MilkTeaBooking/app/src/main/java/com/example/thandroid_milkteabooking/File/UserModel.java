package com.example.thandroid_milkteabooking.File;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public UserModel() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public List<SP> getuserlist() throws SQLException {
        List<SP> list = new ArrayList<>();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from sp";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new SP(rs.getString("ten"),rs.getBytes("anh"), rs.getInt("gia")));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        Log.d("con",list.size()+"sdfsd");
        return list;
    }
    public int getID(SP hoaDon) throws SQLException {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select ID from SP where ten='"+hoaDon.getName()+"'";
        Log.d("sql",sql);
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        int id=0;
        while (rs.next()) {
            id=rs.getInt("ID");
        }
        connection.close();// Đóng kết nối
        return id;
    }

//    public boolean Insert(SP objUser) throws SQLException {
//        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
//        String sql = "insert in to User(Name) values(" + objUser.getName() + ")";
//        if (statement.executeUpdate(sql) > 0) { // Dùng lệnh executeUpdate cho các lệnh CRUD
//            connection.close();
//            return true;
//        } else {
//            connection.close();
//            return false;
//        }
//    }

//    public boolean Update(User objUser) throws SQLException {
//        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
//        String sql = "Update User set Name = " + objUser.getName() + " where ID = " + objUser.getID();
//        if (statement.executeUpdate(sql) > 0) {
//            connection.close();
//            return true;
//        } else
//            connection.close();
//        return false;
//    }
//
//    public boolean Delete(User objUser) throws SQLException {
//        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
//        String sql = "delete from User where ID = " + objUser.getID();
//        if (statement.executeUpdate(sql) > 0){
//            connection.close();
//            return true;
//        }
//
//        else
//            connection.close();
//            return false;
//    }

}