package com.example.mywechatdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Random;

public class findResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_result);
        Intent intent = getIntent();
        Random r = new Random();
        int i = r.nextInt(200);
        intent.putExtra("result", String.valueOf(i));
        setResult(2, intent);
        finish();//结束MainActivity
    }

}