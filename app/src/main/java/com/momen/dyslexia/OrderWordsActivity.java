package com.momen.dyslexia;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class OrderWordsActivity extends AppCompatActivity {
    String[] listWordsTest1 = {"يسبح السمك في الماء", "هذه سمكة صغيرة", "هي معلمة نشيطة", "هذا طير ازرق"};
    String[] listWordsTest2 = {"هو ولد سعيد", "هو رجل قوى", "هذه وردة جميلة"};
    int[] imagesTest1 = {R.drawable.swim_fish, R.drawable.small_fish, R.drawable.active_teacher, R.drawable.blue_baird};
    int[] imagesTest2 = {R.drawable.boy, R.drawable.strong_man, R.drawable.flower};
    ArrayList<String> wrongLetters = new ArrayList();
    ArrayList<String> rightLetters = new ArrayList();
    private LinearLayout linearLayout;
    private TextView letter1;
    private TextView letter2;
    private TextView letter3;
    private TextView letter4;
    private ImageView ivWord;
    private LinearLayout linearLayout2;
    private EditText letter11;
    private EditText letter12;
    private EditText letter13;
    private EditText letter14;
    private Button nextWord;
    private TextView result;
    int index = 0;
    String commingFrom = "";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_words);
        initView();
        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        commingFrom = getIntent().getStringExtra("commingFrom");
        if (commingFrom.equals("keply")) {
            splitT3Letters(listWordsTest1, imagesTest1);

        } else if (commingFrom.equals("bo3dy")) {
            splitT3Letters(listWordsTest2, imagesTest2);

        }
        nextWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] word ;
                if (commingFrom.equals("keply")) {
                    word = listWordsTest1[index].split(" ");
                    nextStep(listWordsTest1, imagesTest1,word);

                } else if (commingFrom.equals("bo3dy")) {
                    word = listWordsTest2[index].split(" ");

                    nextStep(listWordsTest2, imagesTest2,word);

                }


            }
        });

    }

    public void  nextStep(String[] listWords, int[] images,String[] word){
        if (word.length == 3) {
            String _result = letter14.getText().toString().trim() + letter13.getText().toString().trim() + " " + letter12.getText().toString().trim() + " " + letter11.getText().toString().trim();
            Log.d("TAG", "onClick:result " + _result);
            Log.d("TAG", "onClick:result  " + listWords[index]);
            _result.replace(" ", "");
            if (_result.equals(listWords[index])) {

                rightLetters.add(listWords[index]);


            } else {
                Log.d("TAG", "onClick:wrong   " + listWords[index]);

                wrongLetters.add(listWords[index]);

            }
            index = index + 1;


        } else {
            String _result = letter14.getText().toString().trim() + " " + letter13.getText().toString().trim() + " " + letter12.getText().toString().trim() + " " + letter11.getText().toString().trim();

            if (_result.equals(listWords[index])) {

                Log.d("TAG", "onClick:innn  " + index);

                rightLetters.add(listWords[index]);


            } else {
                wrongLetters.add(listWords[index]);
            }
            index = index + 1;


        }
        splitT3Letters(listWords, images);

    }

    public void splitT3Letters(String[] listWords, int[] images) {
        Log.d("TAG", "splitT3Letters: " + index);

        if (index >= listWords.length) {
            index = 0;
      /*      if (rightLetters.size() != 0) {
                result.append("النتيجة : " + rightLetters.size() + " من " + listWords.length +
                        "\n الكلمات الصحيحة : \n");

                for (int x = 0; x < rightLetters.size(); x++) {
                    result.append(rightLetters.get(x) + ",");

                }
            }*/
            result.append("النتيجة : " + rightLetters.size() + " من " + listWords.length +
                    "\n");
            if (wrongLetters.size() != 0) {
                result.append(" الكلمات الخاطئة : \n ");
                for (int x = 0; x < wrongLetters.size(); x++) {
                    result.append(wrongLetters.get(x) + ",");
                }
                Set<String> set = new HashSet<String>();
                set.addAll(wrongLetters);

                if (commingFrom.equals("keply")) {
                    editor.putStringSet("wrongLetters_l5",set);
                    editor.putString("lvl5Deg",rightLetters.size()  + " / " + listWords.length);
                    editor.commit();

                } else if (commingFrom.equals("bo3dy")) {
                    editor.putStringSet("words_wrong_l4_bo3dy", set);
                    editor.putString("lvl4Deg_bo3dy", rightLetters.size() + " / " + listWords.length);
                    editor.commit();

                }



            }
            nextWord.setVisibility(View.GONE);
            letter11.setVisibility(View.GONE);
            letter12.setVisibility(View.GONE);
            letter13.setVisibility(View.GONE);
            letter14.setVisibility(View.GONE);


        } else {
            ivWord.setImageResource(images[index]);

            Random r = new Random();
            letter11.setText("");
            letter12.setText("");
            letter13.setText("");
            letter14.setText("");
            result.setText("");
            String[] word = listWords[index].split(" ");
            if (word.length == 3) {
                letter3.setVisibility(View.GONE);
                letter13.setVisibility(View.GONE);


                word = scramble(r, word);
                letter1.setText("" + word[0]);
                letter2.setText("" + word[1]);
                letter4.setText("" + word[2]);
            } else if (word.length == 4) {
                letter3.setVisibility(View.VISIBLE);
                letter13.setVisibility(View.VISIBLE);


                word = scramble(r, word);
                letter1.setText("" + word[0]);
                letter2.setText("" + word[1]);
                letter3.setText("" + word[2]);
                letter4.setText("" + word[3]);
            }

        }


    }


    public static String[] scramble(Random random, String[] inputString) {
        // Convert your string into a simple char array:

        // Scramble the letters using the standard Fisher-Yates shuffle,
        for (int i = 0; i < inputString.length; i++) {
            int j = random.nextInt(inputString.length);
            // Swap letters
            String temp = inputString[i];
            inputString[i] = inputString[j];
            inputString[j] = temp;
        }

        return inputString;
    }

    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        letter1 = (TextView) findViewById(R.id.letter1);
        letter2 = (TextView) findViewById(R.id.letter2);
        letter3 = (TextView) findViewById(R.id.letter3);
        letter4 = (TextView) findViewById(R.id.letter4);
        ivWord = (ImageView) findViewById(R.id.iv_word);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        letter11 = (EditText) findViewById(R.id.letter11);
        letter12 = (EditText) findViewById(R.id.letter12);
        letter13 = (EditText) findViewById(R.id.letter13);
        letter14 = (EditText) findViewById(R.id.letter14);
        nextWord = (Button) findViewById(R.id.nextWord);
        result = (TextView) findViewById(R.id.result);
    }
}