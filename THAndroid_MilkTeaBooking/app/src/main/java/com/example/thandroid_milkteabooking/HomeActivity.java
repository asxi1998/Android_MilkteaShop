package com.example.thandroid_milkteabooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    ImageView imageViewTichDiem;
    ImageView imageViewDatHang;
    ImageView imageViewUuDai;
    ImageButton btn;
    LinearLayout linearLayout;
    BottomNavigationView navView;
    FrameLayout frameLayout ;
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
