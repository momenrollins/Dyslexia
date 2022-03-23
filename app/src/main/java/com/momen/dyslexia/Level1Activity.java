package com.momen.dyslexia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Level1Activity extends AppCompatActivity {

    private RecyclerView rvLevel1;
    private Level1Adapter adapter;
    private Button submit;
    private TextView degree;
    ArrayList<Level_1Model> level_1ModelsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        initView();
        level_1ModelsList.add(new Level_1Model(R.drawable.vector, "خرو", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.vector, "غر", "ـة"));
        level_1ModelsList.add(new Level_1Model(R.drawable.vector, "", "ـيل"));
        level_1ModelsList.add(new Level_1Model(R.drawable.vector, "معطـ", ""));
        rvLevel1.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Level1Adapter(level_1ModelsList);
        rvLevel1.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> letters = adapter.getLetters();
                int counter = 0;
                for (int i = 0; i < letters.size(); i++) {
                    String letter = letters.get(i);
                    if (letter == null || letter.trim().equals("")) {
                        adapter.signs.set(i, "");
                        adapter.notifyItemChanged(i);
                    } else if (letter.equals("ف")) {
                        adapter.signs.set(i, "✔");
                        adapter.notifyItemChanged(i);
                        counter++;
                    } else {
                        adapter.signs.set(i, "❌");
                        adapter.notifyItemChanged(i);
                    }
                }
                degree.setText(counter+" / "+letters.size());
            }
        });
    }

    private void initView() {
        rvLevel1 = (RecyclerView) findViewById(R.id.rv_level1);
        submit = findViewById(R.id.submit_btn);
        degree = findViewById(R.id.degree);
    }
}