package com.momen.dyslexia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
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
    ArrayList<String> ans = new ArrayList<>();
    String[] names = {"مسجد", "خروف", "دب", "فيل", "أرنب", "معطف", "بيت"};
    int[] imgs = {R.drawable.mosque, R.drawable.sheep, R.drawable.bear,
            R.drawable.elephant, R.drawable.rabbit, R.drawable.coat, R.drawable.house};

    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        initView();
        index = getIntent().getIntExtra("index", 1);
        level_1ModelsList.add(new Level_1Model(R.drawable.mosque, "", "ـسجد"));
        level_1ModelsList.add(new Level_1Model(R.drawable.sheep, "خرو", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.bear, "د", ""));
//        level_1ModelsList.add(new Level_1Model(R.drawable.vector, "غر", "ـة"));
        level_1ModelsList.add(new Level_1Model(R.drawable.elephant, "", "ـيل"));
        level_1ModelsList.add(new Level_1Model(R.drawable.rabbit, "أر", "ـب"));
        level_1ModelsList.add(new Level_1Model(R.drawable.coat, "معطـ", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.house, "بـ", "ـت"));
        rvLevel1.setLayoutManager(new LinearLayoutManager(this));
        if (index == 1) {
            adapter = new Level1Adapter(this, level_1ModelsList);
            adapter.names = names;
            rvLevel1.setAdapter(adapter);
            ans.add("م");
            ans.add("ف");
            ans.add("ب");
            ans.add("ف");
            ans.add("ن");
            ans.add("ف");
            ans.add("ي");
            rvLevel1.addItemDecoration(new DividerItemDecoration(rvLevel1.getContext(), DividerItemDecoration.VERTICAL));

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
                        } else if (letter.equals(ans.get(i))) {
                            adapter.signs.set(i, "✔");
                            adapter.notifyItemChanged(i);
                            counter++;
                        } else {
                            adapter.signs.set(i, "❌");
                            adapter.notifyItemChanged(i);
                        }
                    }
                    degree.setText(counter + " / " + letters.size());
                }
            });
        } else {
            adapter = new Level1Adapter(this, names, imgs, true);
            rvLevel1.setAdapter(adapter);

        }
    }

    private void initView() {
        rvLevel1 = (RecyclerView) findViewById(R.id.rv_level1);
        submit = findViewById(R.id.submit_btn);
        degree = findViewById(R.id.degree);
    }
}