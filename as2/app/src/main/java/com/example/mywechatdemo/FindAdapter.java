package com.example.mywechatdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.Myholder> {
    private Context context;
    private ArrayList<String> title;

    public FindAdapter(Context context,ArrayList<String> newsTitle){
        this.context = context;
        this.title = newsTitle;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_find, parent, false);
        Myholder myholder;
        myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView1.setText(title.get(position));
        holder.linearLayoutOfDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,findActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;
        LinearLayout linearLayoutOfDiscover;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1_find);

            linearLayoutOfDiscover = itemView.findViewById(R.id.linearlayout_find);
        }
    }
}
