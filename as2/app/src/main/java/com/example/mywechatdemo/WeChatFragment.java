package com.example.mywechatdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class WeChatFragment extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private WeChatAdapter wechatadapter;

    private List<String> peopleData = new ArrayList<>();//聊天内容
    private List<String> peopleName = new ArrayList<>();//聊天者姓名



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.tab01, container, false);
        recyclerView =view.findViewById(R.id.recy01);
        peopleName();
        peopleData();

        viewInit();
        return view;
    }
    private void viewInit(){
        context = this.getActivity();
        wechatadapter = new WeChatAdapter(context);
        //设置LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(wechatadapter);
        wechatadapter.peopleName(peopleName);
        wechatadapter.peopleData(peopleData);
    }
    private void peopleName(){
        peopleName.add("J1syan");
        peopleName.add("eriserva");
    }
    private void peopleData(){
        peopleData.add("拼多多链接------");
        peopleData.add("淘宝链接-----");
    }


}