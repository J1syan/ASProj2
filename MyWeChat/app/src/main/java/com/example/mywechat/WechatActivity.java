package com.example.mywechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WechatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        TextView textView_main2_01 = findViewById(R.id.activity_chat_text);
        textView_main2_01.setText(msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button_main2_01 = findViewById(R.id.activity_chat_button);
        button_main2_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WechatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

