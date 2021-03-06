package com.momen.dyslexia;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WordsActivity extends AppCompatActivity {

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
    private Button nextWord;
    String commingFrom = "";
    String[] listWordsTest1 = {"ديك", "شجرة", "قطة", "تاج", "أرنب", "كرسي", "أسد", "شباك", "نجمة"};
    int[] imagesTest1 = {R.drawable.deek, R.drawable.tree, R.drawable.cat, R.drawable.crown, R.drawable.rabbit, R.drawable.chair, R.drawable.lion, R.drawable.window, R.drawable.star};

    String[] listWordsTest2 = {"بيت", "خبز", "شجرة", "أسد", "موز", "ظفر", "دمية", "كرة", "جمل", "قطار", "عربة", "عجلة"};
    int[] imagesTest2 = {R.drawable.house, R.drawable.bread, R.drawable.tree, R.drawable.lion, R.drawable.banana,
            R.drawable.fingernail, R.drawable.doll, R.drawable.football, R.drawable.s55, R.drawable.train, R.drawable.box_truck, R.drawable.s181};
    ArrayList<String> wrongLetters = new ArrayList();
    ArrayList<String> rightLetters = new ArrayList();
    int index = 0;
    private EditText letter14;
    private TextView result;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_words_aactivity);
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

                if (commingFrom.equals("keply")) {
                    nextStep(listWordsTest1, imagesTest1);

                } else if (commingFrom.equals("bo3dy")) {
                    nextStep(listWordsTest2, imagesTest2);

                }
            }


        });


    }


    public void nextStep(String[] listWords, int[] images) {
        if (listWords[index].length() == 3) {
            Log.d("TAG", "onClick: " + letter14.getText().toString() + letter12.getText().toString() + letter11.getText().toString());
            String _result = letter14.getText().toString() + letter12.getText().toString() + letter11.getText().toString();

            if (_result.equals(listWords[index])) {


                rightLetters.add(listWords[index]);


            } else {
                wrongLetters.add(listWords[index]);

            }
            index = index + 1;


        } else {
            String _result = letter14.getText().toString() + letter13.getText().toString() + letter12.getText().toString() + letter11.getText().toString();

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
                    result.append(wrongLetters.get(x) + ", ");
                }
                Set<String> set = new HashSet<String>();
                set.addAll(wrongLetters);


                if (commingFrom.equals("keply")) {
                    editor.putStringSet("words_wrong_l3", set);
                    editor.putString("lvl3Deg", rightLetters.size() + " / " + listWords.length);
                    editor.commit();

                } else if (commingFrom.equals("bo3dy")) {
                    editor.putStringSet("words_wrong_l3_bo3dy", set);
                    editor.putString("lvl3Deg_bo3dy", rightLetters.size() + " / " + listWords.length);
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
            String word = listWords[index];
            if (word.length() == 3) {
                letter3.setVisibility(View.GONE);
                letter13.setVisibility(View.GONE);
                letter12.addTextChangedListener(new GenericTextWatcher(letter11, letter12));
                letter14.addTextChangedListener(new GenericTextWatcher(letter12, letter14));

                word = scramble(r, word);
                letter1.setText("" + word.charAt(0));
                letter2.setText("" + word.charAt(1));
                letter4.setText("" + word.charAt(2));
            } else if (word.length() == 4) {
                letter3.setVisibility(View.VISIBLE);
                letter13.setVisibility(View.VISIBLE);
                letter12.addTextChangedListener(new GenericTextWatcher(letter11, letter12));
                letter13.addTextChangedListener(new GenericTextWatcher(letter12, letter13));
                letter14.addTextChangedListener(new GenericTextWatcher(letter13, letter14));

                word = scramble(r, word);
                letter1.setText("" + word.charAt(0));
                letter2.setText("" + word.charAt(1));
                letter3.setText("" + word.charAt(2));
                letter4.setText("" + word.charAt(3));
            }

        }


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
        nextWord = (Button) findViewById(R.id.nextWord);
        letter14 = (EditText) findViewById(R.id.letter14);
        result = (TextView) findViewById(R.id.result);
    }

    public static String scramble(Random random, String inputString) {
        // Convert your string into a simple char array:
        char a[] = inputString.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle,
        for (int i = 0; i < a.length; i++) {
            int j = random.nextInt(a.length);
            // Swap letters
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return new String(a);
    }
}

class GenericTextWatcher implements TextWatcher {
    private EditText etPrev;
    private EditText etNext;

    public GenericTextWatcher(EditText etNext, EditText etPrev) {
        this.etPrev = etPrev;
        this.etNext = etNext;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editable.toString();
        if (text.length() == 1)
            etNext.requestFocus();
        else if (text.length() == 0)
            etPrev.requestFocus();
    }

    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
    }

    @Override
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
    }
}