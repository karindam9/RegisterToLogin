package com.web.arindam.registertologin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpashScreenActivity extends AppCompatActivity {
    public static final int delaytime=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in=new Intent(SpashScreenActivity.this,RegisterToLogin.class);
                startActivity(in);
                finish();

            }
        },delaytime);
    }
}
