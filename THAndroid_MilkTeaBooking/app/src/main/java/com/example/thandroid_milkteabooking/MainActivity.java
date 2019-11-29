package com.example.thandroid_milkteabooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressBarMain);


        CountDownTimer countDownTimer= new CountDownTimer(10000,88) {
            @Override
            public void onTick(long millisUntilFinished) {
                int curent = progressBar.getProgress();

                progressBar.setProgress(curent+1);
            }

            @Override
            public void onFinish() {
                Intent intent= new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        };

        countDownTimer.start();
    }
}
