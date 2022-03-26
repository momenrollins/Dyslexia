package com.momen.dyslexia;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SelectLetter extends AppCompatActivity {
    private Level1Adapter adapter;
    String[] right_letters = {"ت", "ت"};
    String[] wrond_letters = {"ن", "ك"};
    int[] images = {R.drawable.tmr, R.drawable.trabeza};
    private RecyclerView rvSelectletter;
    private ImageView ivWord;
    private LinearLayout linyer;
    private TextView l2;
    private TextView l1;
    private Button lNext;
    int index = 0;
    ArrayList<Level_1Model> level_1ModelsList = new ArrayList<>();
    String[] names = {"مسجد", "خروف", "دب", "فيل", "أرنب", "معطف", "بيت"};
    String[] letternames = {"م", "خ", "د", "ف", "أ", "م", "ب"};
    private TextView txtLetter;
    private ExtendedFloatingActionButton submitBtn;
    ArrayList<String> ans = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_letter);


        initView();
        ans.add("م");
        ans.add("خ");
        ans.add("د");
        ans.add("ف");
        ans.add("أ");
        ans.add("م");
        ans.add("ب");
        level_1ModelsList.add(new Level_1Model(R.drawable.mosque, "مسجد", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.sheep, "خروف", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.bear, "دب", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.elephant, "فيل", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.rabbit, "أرنب", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.coat, "معطف", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.house, "بيت", ""));
        rvSelectletter.setLayoutManager(new LinearLayoutManager(SelectLetter.this));
        adapter = new Level1Adapter(this, level_1ModelsList);
        adapter.names = names;

        rvSelectletter.setAdapter(adapter);

        rvSelectletter.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Level1Adapter(this, level_1ModelsList);
        ivWord.setImageResource(images[0]);
        l1.setText(right_letters[0]);
        l2.setText(wrond_letters[0]);
        txtLetter.setVisibility(View.VISIBLE);

        lNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index == right_letters.length) {
                    txtLetter.setText("");

                    txtLetter.setVisibility(View.VISIBLE);
                    rvSelectletter.setVisibility(View.VISIBLE);
                    linyer.setVisibility(View.GONE);
                    ivWord.setVisibility(View.GONE);
                    lNext.setVisibility(View.GONE);
                    submitBtn.setVisibility(View.VISIBLE);
                    for (String letter : letternames) {

                        txtLetter.append(letter + "  ");

                    }
                } else {
                    ivWord.setImageResource(images[index]);
                    l1.setText(right_letters[index]);
                    l2.setText(wrond_letters[index]);
                }

            }
        });
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtLetter.setText("شاطر");

            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtLetter.setText("خطأ");
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
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
                txtLetter.setText(counter + " / " + names.length);
            }
        });
    }


    private void initView() {
        rvSelectletter = (RecyclerView) findViewById(R.id.rv_selectletter);
        ivWord = (ImageView) findViewById(R.id.iv_word);
        linyer = (LinearLayout) findViewById(R.id.linyer);
        l2 = (TextView) findViewById(R.id.l_2);
        l1 = (TextView) findViewById(R.id.l_1);
        lNext = (Button) findViewById(R.id.l_next);
        txtLetter = (TextView) findViewById(R.id.txt_letter);
        submitBtn = (ExtendedFloatingActionButton) findViewById(R.id.submit_btn);
    }
}