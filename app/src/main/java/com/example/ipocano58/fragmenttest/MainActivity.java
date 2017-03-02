package com.example.ipocano58.fragmenttest;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import layout.AFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, new AFragment(), "TagA");
        ft.commit();
    }

    public void setStackCountText() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                TextView textView = (TextView) findViewById(R.id.back_stack_text);
//                textView.setText("BackStack数:" + getFragmentManager().getBackStackEntryCount());
//            }
//        }, 1000);

    }
}
