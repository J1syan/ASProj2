package com.example.mywechatdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Random;

public class chatResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent4 = getIntent();
        Random r = new Random();
        int i = r.nextInt(200);
        intent4.putExtra("result", String.valueOf(i));
        setResult(2, intent4);
        finish();//结束MainActivity
    }
}