package com.example.mywechat;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class WechatBlankFragment extends Fragment {
    private weixin_adapter adapter;
    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    private Context context;

    public WechatBlankFragment() {
        // Required empty public constructor
    }
    private void initData(){
        for(int i=0;i<30;i++) {
            list.add("朋友" + i + "消息未读");
        }
    }

    private void initView1(){
        context=this.getActivity();
        adapter=new weixin_adapter(context,list);

        ItemTouchHelper.Callback callback = new SwipeItemTouchHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_weixin, container, false);
        View view = inflater.inflate(R.layout.tab01, container, false);
        recyclerView=view.findViewById(R.id.recy01);
        initData();
        initView1();
        return view;
    }
}