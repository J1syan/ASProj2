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
import android.widget.ImageView;
import android.widget.TextView;

public class findActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button agreementButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        imageView =findViewById(R.id.friend);
        imageView.setImageResource(R.drawable.txl);

    }

    @Override
    protected void onStart() {
        super.onStart();
        agreementButton = findViewById(R.id.approval);
        agreementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(findActivity.this, findResultActivity.class);
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
                        TextView textView_love = findViewById(R.id.approval);
                        textView_love.setText(result.getData().getStringExtra("result") + "赞同");
                    }
                }
            }
    );
}