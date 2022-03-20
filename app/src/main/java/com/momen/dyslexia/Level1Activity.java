package com.momen.dyslexia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Level1Activity extends AppCompatActivity {

    private RecyclerView rvLevel1;
    private Level1Adapter adapter;
    ArrayList<Level_1Model>level_1ModelsList= new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        initView();
        level_1ModelsList.add(new Level_1Model(R.drawable.vector,"خر","ف"));
        level_1ModelsList.add(new Level_1Model(R.drawable.vector,"حم","ر"));
        level_1ModelsList.add(new Level_1Model(R.drawable.vector,"ح","ن"));
        level_1ModelsList.add(new Level_1Model(R.drawable.vector,"ك","ب"));
        level_1ModelsList.add(new Level_1Model(R.drawable.vector,"قر","ط"));
        rvLevel1.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Level1Adapter(level_1ModelsList);
        rvLevel1.setAdapter(adapter);
    }

    private void initView() {
        rvLevel1 = (RecyclerView) findViewById(R.id.rv_level1);


    }
}