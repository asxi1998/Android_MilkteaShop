package com.example.thandroid_milkteabooking.File;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoaDonModel {
    private static JDBCController jdbcController = new JDBCController();
    private static Connection connection;

    public HoaDonModel() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public List<HoaDon> getHoaDonlist() throws SQLException {
        List<HoaDon> list = new ArrayList<>();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from HoaDon";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new HoaDon(rs.getInt("SDT"),rs.getString("Ngay"),rs.getInt("TongTien")));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        Log.d("con",list.size()+"sdfsd");
        return list;
    }
    public static int getID(HoaDon hoaDon) throws SQLException {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database

        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select ID from HoaDon where SDT="+hoaDon.getSDT()+" and Ngay='"+hoaDon.getNgay()+"' and TongTien="+hoaDon.getTongTien()+"";
        Log.d("sql12",sql);
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        int id=0;
        while (rs.next()) {
            id=rs.getInt("ID");
            }
        connection.close();// Đóng kết nối
        return id;
    }

    public static boolean Insert(HoaDon objUser) throws SQLException {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database

        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "insert into HoaDon values(" + objUser.getSDT() + ",'"+objUser.getNgay()+"',"+objUser.getTongTien()+")";
        Log.d("sql2222222",sql);
        if (statement.executeUpdate(sql) > 0) { // Dùng lệnh executeUpdate cho các lệnh CRUD
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }



}
