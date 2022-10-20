package com.example.mywechatdemo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        String name =intent.getStringExtra("name");
        String msg =intent.getStringExtra("msg");
        TextView textView_name = findViewById(R.id.activity_chat_name);
        TextView textView_msg = findViewById(R.id.activity_chat_text);

        textView_name.setText(name);
        textView_msg.setText(msg);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Button button_love = findViewById(R.id.activity_chat_love);

        Button button_back = findViewById(R.id.activity_chat_button);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        button_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this,chatResultActivity.class);
                test.launch(intent);//启动函数
            }
        });


    }

    public ActivityResultLauncher<Intent> test = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @SuppressLint("SetTextI18n")
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 2) {
                        TextView textView_love = findViewById(R.id.love_number);
                        textView_love.setText(result.getData().getStringExtra("result") + "人与你同时点赞");
                    }
                }
            }
    );
}