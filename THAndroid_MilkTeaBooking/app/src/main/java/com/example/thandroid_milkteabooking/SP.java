package com.example.thandroid_milkteabooking;

import com.example.thandroid_milkteabooking.model.order;

import java.util.ArrayList;

public class SP {
    public ArrayList<order> createNEW() {
        order home= new order(R.drawable.image3,"Trà Sửa Phùng Gia","100000 ","0");
        order home1= new order(R.drawable.image3,"Trà Sửa Trân Châu","100000 ","0");
        order home2= new order(R.drawable.image3,"Trà Sửa Trà Xanh","100000 ","0");
        order home3= new order(R.drawable.image3,"Trà Sửa Gì Đó Đó","10000","0");
        ArrayList<order> list= new ArrayList<>();
        list.add(home);
        list.add(home1);
        list.add(home2);
        list.add(home3);

        return list;
    }
}
