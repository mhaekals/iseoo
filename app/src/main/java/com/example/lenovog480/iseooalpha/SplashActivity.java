package com.example.lenovog480.iseooalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    boolean user = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (user == true) {
                        Intent go = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(go);
                    } else {
                        Intent d = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(d);
                    }
                }
            }
        };
        timer.start();

    }
}
