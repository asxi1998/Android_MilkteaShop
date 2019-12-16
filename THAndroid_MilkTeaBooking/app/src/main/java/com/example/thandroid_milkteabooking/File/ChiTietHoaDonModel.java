package com.example.thandroid_milkteabooking.File;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonModel {

    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    public ChiTietHoaDonModel() {
        connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
    }

    public List<ChiTietHoaDon> getHoaDonlist() throws SQLException {
        List<ChiTietHoaDon> list = new ArrayList<>();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from ChiTietHoaDon";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new ChiTietHoaDon(rs.getInt("MaHoaDon"),rs.getInt("SP"),rs.getInt("SL"),rs.getInt("ThanhTien")));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        Log.d("con",list.size()+"sdfsd");
        return list;
    }

    public boolean Insert(ChiTietHoaDon objUser) throws SQLException {
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "insert into ChiTietHoaDon values(" + objUser.getMaHoaDon() + ","+objUser.getSP()+","+objUser.getSL()+","+objUser.getThanhTien()+")";
        Log.d("sql6666666666",sql);
        if (statement.executeUpdate(sql) > 0) { // Dùng lệnh executeUpdate cho các lệnh CRUD
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }
}
