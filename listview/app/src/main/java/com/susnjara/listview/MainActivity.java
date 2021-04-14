package com.susnjara.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener{

    public static final String KEY_INPUT = "input data";

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private List<String> dataList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        setupRecyclerView();
    }

    private void setupData(){
        dataList = new ArrayList<>();
        dataList.add("prvo ime");
        dataList.add("drugo ime");
        dataList.add("trece ime");
        dataList.add("Primjer string");
        dataList.add("Antonio Šušnjara");
        dataList.add("ListView");
        dataList.add("Ivan Pero");
        dataList.add("Mario Maric");
        dataList.add("Jos ime");
        dataList.add("Zadaca lv 3");
        dataList.add("setupData");
        dataList.add("setupRecyclerView");
        dataList.add("Lkrterr ajjsjw");
    }

    private void setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        customAdapter = new CustomAdapter(dataList, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onNameClick(int position){
        Log.d(TAG, "onNameClick: int position" + position);
        Log.d(TAG, dataList.get(position));

        Intent intent = new Intent(getApplicationContext(), NameActivity.class);
        intent.putExtra(KEY_INPUT, dataList.get(position));
        this.startActivity(intent);
    }
}