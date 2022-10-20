package com.example.mywechatdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.Myholder> {
    private View view;
    private Context context;
    private List<String>peopleName;
    private List<String>peopleData;

    //初始化
    public WeChatAdapter(Context context){
        this.context=context;
        this.peopleName=peopleName;
        this.peopleData=peopleData;
    }


    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false);
        Myholder holder = new Myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(peopleName.get(position));
        holder.textView2.setText(peopleData.get(position));
        holder.linearLayout_item.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(holder.itemView.getContext(), ChatActivity.class);
                    intent.putExtra("name",peopleName.get(position));
                    intent.putExtra("msg" ,peopleData.get(position));
                    context.startActivity(intent);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return peopleData.size();
    }

    public void WeChatAdapter(Context context) {
        this.context = context;
    }

    public void peopleData(List<String> peopleData) {
        this.peopleData = peopleData;
    }

    public void peopleName(List<String> peopleName) {
        this.peopleName = peopleName;
    }

    class Myholder extends RecyclerView.ViewHolder {
        private TextView textView1,textView2;
        LinearLayout linearLayout_item;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView_item1);
            textView2 = itemView.findViewById(R.id.textView_item2);
            linearLayout_item = itemView.findViewById(R.id.linearLayout_item);
        }
    }
}

