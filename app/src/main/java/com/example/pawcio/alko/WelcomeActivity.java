package com.example.pawcio.alko;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {
    private static int TIME_OUT = 1300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, TIME_OUT);


        ImageView logoImageView = (ImageView) findViewById(R.id.imageView_logo);
        logoImageView.setImageResource(R.drawable.logo);
    }
}
