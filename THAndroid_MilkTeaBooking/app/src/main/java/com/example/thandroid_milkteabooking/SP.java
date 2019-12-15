package com.example.thandroid_milkteabooking;

import android.util.Log;

import com.example.thandroid_milkteabooking.File.SQL;
import com.example.thandroid_milkteabooking.File.UserModel;
import com.example.thandroid_milkteabooking.model.order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class SP {
    public ArrayList<order> createNEW() throws SQLException {
//        order home= new order(R.drawable.image3,"Trà Sửa Phùng Gia","100000 ","0");
//        order home1= new order(R.drawable.image3,"Trà Sửa Trân Châu","100000 ","0");
//        order home2= new order(R.drawable.image3,"Trà Sửa Trà Xanh","100000 ","0");
     // order home3= new order(R.drawable.image3,"Trà Sửa Gì Đó Đó","10000");
        ArrayList<order> list= new ArrayList<>();
//        list.add(home);
//        list.add(home1);
//        list.add(home2);
      //  list.add(home3);
        List<com.example.thandroid_milkteabooking.File.SP> list1 = new ArrayList<>();
        UserModel us = new UserModel();
        list1 = us.getuserlist();
        for(com.example.thandroid_milkteabooking.File.SP s : list1){
            list.add(new order(SQL.convertBitMap(s.getAnh()),s.getName(),s.getGia()+""));//SQL.convertBitMap(s.getAnh())
            Log.d("abcccc",s.getName());
        }
        return list;
    }
}
