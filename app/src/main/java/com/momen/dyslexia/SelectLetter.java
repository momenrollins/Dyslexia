package com.momen.dyslexia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectLetter extends AppCompatActivity {
    private Level1Adapter adapter;
    String[] right_letters = {"ت", "ت", "ت"};
    String[] wrond_letters = {"ن", "ك", "ط"};
    ArrayList<String> right_letters_answer = new ArrayList();
    ArrayList<String> wrond_letters_answer = new ArrayList();
    int[] images = {R.drawable.tmr, R.drawable.trabeza, R.drawable.crown};
    private RecyclerView rvSelectletter;
    private ImageView ivWord;
    private LinearLayout linyer;
    private Button l2;
    private Button l1;
    private Button lNext;
    int index = 0;
    int counter = 0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList<Level_1Model> level_1ModelsList = new ArrayList<>();
    String[] names = {"ظرف", "طائرة", "طاووس", "ظفر"};
    String[] letternames = {"م", "خ", "د", "ف", "أ", "م", "ب"};
    private TextView txtLetter;
    private ExtendedFloatingActionButton submitBtn;
    ArrayList<String> ans = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_letter);
        initView();
        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        ans.add("ظ");
        ans.add("ط");
        ans.add("ط");
        ans.add("ظ");
        level_1ModelsList.add(new Level_1Model(R.drawable.envelope, "ظرف", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.plane, "طائرة", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.peacock, "طاووس", ""));
        level_1ModelsList.add(new Level_1Model(R.drawable.fingernail, "ظفر", ""));
        rvSelectletter.setLayoutManager(new LinearLayoutManager(SelectLetter.this));
        adapter = new Level1Adapter(this, level_1ModelsList);

        adapter.names = names;
        rvSelectletter.setAdapter(adapter);
        ivWord.setImageResource(images[0]);
        l1.setText(right_letters[0]);
        l2.setText(wrond_letters[0]);
        txtLetter.setVisibility(View.VISIBLE);

        lNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1.setBackgroundColor(Color.WHITE);
                l2.setBackgroundColor(Color.WHITE);
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
                l1.setBackgroundColor(Color.GREEN);
                right_letters_answer.add(right_letters[index]);

                l1.setBackgroundColor(Color.WHITE);
                l2.setBackgroundColor(Color.WHITE);
                index++;
                counter++;

                if (index == right_letters.length) {
                    txtLetter.setText("");

                    txtLetter.setVisibility(View.VISIBLE);
                    rvSelectletter.setVisibility(View.VISIBLE);
                    linyer.setVisibility(View.GONE);
                    ivWord.setVisibility(View.GONE);
                    lNext.setVisibility(View.GONE);
                    submitBtn.setVisibility(View.VISIBLE);
                    /*for (String letter : letternames) {

                        txtLetter.append(letter + "  ");

                    }*/
                    txtLetter.setText("اكتب الحرف الذي يبدأ به الصورة");

                } else {
                    ivWord.setImageResource(images[index]);
                    l1.setText(right_letters[index]);
                    l2.setText(wrond_letters[index]);
                }

            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtLetter.setText("خطأ");
                wrond_letters_answer.add(right_letters[index]);
                l1.setBackgroundColor(Color.GREEN);
                l2.setBackgroundColor(Color.RED);
//                index++;

                if (index == right_letters.length) {
                    txtLetter.setText("");

                    txtLetter.setVisibility(View.VISIBLE);
                    rvSelectletter.setVisibility(View.VISIBLE);
                    linyer.setVisibility(View.GONE);
                    ivWord.setVisibility(View.GONE);
                    lNext.setVisibility(View.GONE);
                    submitBtn.setVisibility(View.VISIBLE);
                   /* for (String letter : letternames) {

                        txtLetter.append(letter + "  ");

                    }*/
                    txtLetter.setText("اكتب الحرف الذي يبدأ به الصورة");
                } else {
                    ivWord.setImageResource(images[index]);
                    l1.setText(right_letters[index]);
                    l2.setText(wrond_letters[index]);
                }


            }

        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                List<String> letters = adapter.getLetters();
                counter = 3;
                Log.d("TAG", "onClick:letters  " + letters.size());
                for (int i = 0; i < letters.size(); i++) {
                    Log.d("TAG", "onClick:letters  " + letters.get(i));

                    String letter = letters.get(i);
                    if (letter == null || letter.trim().equals("")) {
                        Log.d("TAG", "onClick:letters null " + letters.get(i));

                        adapter.signs.set(i, "");
                        adapter.notifyItemChanged(i);
                    } else if (letter.equals(ans.get(i))) {
                        Log.d("TAG", "onClick:letters R " + letters.get(i));

                        adapter.signs.set(i, "✔");
                        adapter.notifyItemChanged(i);
                        counter++;
                    } else {
                        Log.d("TAG", "onClick:letters F " + letters.get(i));

                        adapter.signs.set(i, "❌");
                        adapter.notifyItemChanged(i);
                    }
                }
                txtLetter.setText(counter + " / " + (names.length + right_letters.length));
                Set<String> set = new HashSet<String>();
                Set<String> set2 = new HashSet<String>();
                set.addAll(right_letters_answer);
                set2.addAll(wrond_letters_answer);
                editor.putStringSet("selectFLettersRight", set);
                editor.putStringSet("selectFLettersWrong", set2);
                editor.commit();
            }
        });
    }


    private void initView() {
        rvSelectletter = (RecyclerView) findViewById(R.id.rv_selectletter);
        ivWord = (ImageView) findViewById(R.id.iv_word);
        linyer = (LinearLayout) findViewById(R.id.linyer);
        l2 = findViewById(R.id.l_2);
        l1 = findViewById(R.id.l_1);
        lNext = (Button) findViewById(R.id.l_next);
        txtLetter = (TextView) findViewById(R.id.txt_letter);
        submitBtn = (ExtendedFloatingActionButton) findViewById(R.id.submit_btn);
    }
}