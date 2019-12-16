package com.example.thandroid_milkteabooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thandroid_milkteabooking.model.order;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements DemoFragmentInterface {

    ImageView imageViewTichDiem;
    ImageView imageViewDatHang;
    ImageView imageViewUuDai;
    ImageButton btn;
    LinearLayout linearLayout;
    BottomNavigationView navView;
    FrameLayout frameLayout ;
    public static ArrayList<order> manggiohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageViewDatHang=findViewById(R.id.imageViewfragmenthomeDathang);
        imageViewUuDai=findViewById(R.id.imageViewfragmenthomeUudai);
        imageViewTichDiem=findViewById(R.id.imageViewfragmenthomeTichDiem);
        linearLayout=findViewById(R.id.linearLayout);
        frameLayout =findViewById(R.id.framelayoutHome);
        btn= findViewById(R.id.imageButtonshopping);

        navView = findViewById(R.id.bottomNavigationView);
        loadFragment(new HomeFragment());
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navView.setSelectedItemId(R.id.navigation_home);

        imageViewTichDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this,"Hệ thống chưa tồn tại",Toast.LENGTH_LONG).show();
            }
        });

        imageViewUuDai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this,"Hệ thống chưa tồn tại",Toast.LENGTH_LONG).show();
            }
        });
        imageViewDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new OrderFragment();
                linearLayout.setVisibility(View.GONE);
                btn.setVisibility(View.VISIBLE);
                loadFragment(fragment);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = new GetOrderFragment();
                linearLayout.setVisibility(View.GONE);
                btn.setVisibility(View.GONE);


                loadFragment(fragment);
                manggiohang=OrderFragment.giohang;
                for(int i=0;i<manggiohang.size();i++)
                {
                    Log.d("eeeee",manggiohang.get(i).getMota()+manggiohang.size());
                }
            }
        });
        if(manggiohang!=null)
        {


        }else
        {
            manggiohang= new ArrayList<>();
        }
//        SQLite sqLite;
//        sqLite=new SQLite(this,"milktea.sqlite",null,1);
//        sqLite.QueryData("CREATE TABLE IF NOT EXISTS array(Title NVARCHAR(50) PRIMARY KEY, Image NVARCHAR(50), Price NVARCHAR(50), soluong NVARCHAR(50))");


    }
    @Override
    public void sendData( RecyclerView.Adapter  lst) {
        GetOrderFragment demo1Fragment = (GetOrderFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_getorder);

        if (demo1Fragment != null || demo1Fragment.isInLayout()) { // kiem tra fragment can truyen data den co thuc su ton tai va dang hien
            demo1Fragment.showInfor(lst);
        } else {
            Toast.makeText(getApplicationContext(), "Fragment is not exist", Toast.LENGTH_LONG).show();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    linearLayout.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    frameLayout =findViewById(R.id.framelayoutHome);
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_order:
                    fragment = new OrderFragment();
                    linearLayout.setVisibility(View.GONE);
                    btn.setVisibility(View.VISIBLE);
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    linearLayout.setVisibility(View.GONE);
                    btn.setVisibility(View.GONE);
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frameLayout.getId(), fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
