package com.example.thandroid_milkteabooking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.thandroid_milkteabooking.model.order;
import com.example.thandroid_milkteabooking.Adapter.orderAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    RecyclerView recyclerView;
    orderAdapter orderAdapter;
    ArrayList<order> orderList;


//    private ArrayList<order> createNEW() {
//        order home= new order(R.drawable.image3,"Trà Sửa Phùng Gia","100000 ","0");
//        order home1= new order(R.drawable.image3,"Trà Sửa Trân Châu","100000 ","0");
//        order home2= new order(R.drawable.image3,"Trà Sửa Trà Xanh","100000 ","0");
//        order home3= new order(R.drawable.image3,"Trà Sửa Gì Đó Đó","10000","0");
//        ArrayList<order> list= new ArrayList<>();
//        list.add(home);
//        list.add(home1);
//        list.add(home2);
//        list.add(home3);
//
//        return list;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclervieworder);
        SP sp=new SP();
        orderList = sp.createNEW();
        orderAdapter = new orderAdapter(orderList, getContext());
        recyclerView.setAdapter(orderAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }














}
