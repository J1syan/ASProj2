package com.example.mywechatdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FindFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<String> title = new ArrayList<>();
    private FindAdapter FindAdapter;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.tab03, container, false);

        recyclerView =view.findViewById(R.id.recy03);

        initTitle();
        initFindView();

        return view;
    }
    public void initFindView(){
        context = this.getActivity();
        FindAdapter= new FindAdapter(context,title);
        //设置LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(FindAdapter);
    }
    public void initTitle(){
        title.add("朋友圈");
        title.add("视频号");
        title.add("直播");
        title.add("扫一扫");
        title.add("摇一摇");
        title.add("看一看");
        title.add("搜一搜");
        title.add("附近");
        title.add("购物");
        title.add("游戏");
        title.add("小程序");

    }
}