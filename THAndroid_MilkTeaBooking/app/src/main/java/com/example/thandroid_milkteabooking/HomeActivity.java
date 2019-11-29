package com.example.thandroid_milkteabooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    ImageView imageViewTichDiem;
    ImageView imageViewDatHang;
    ImageView imageViewUuDai;

    LinearLayout linearLayout;
    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageViewDatHang=findViewById(R.id.imageViewfragmenthomeDathang);
        imageViewUuDai=findViewById(R.id.imageViewfragmenthomeUudai);
        imageViewTichDiem=findViewById(R.id.imageViewfragmenthomeTichDiem);
        linearLayout=findViewById(R.id.linearLayout);

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
                loadFragment(fragment);
            }
        });


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    linearLayout.setVisibility(View.VISIBLE);
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_order:
                    fragment = new OrderFragment();
                    linearLayout.setVisibility(View.GONE);
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    linearLayout.setVisibility(View.GONE);
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayoutHome, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
