package com.momen.dyslexia;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class LettersRecord extends AppCompatActivity {

    private TextView mText;
    private TextView qText;
    private TextView mText2;
    private ImageView iv_mic;
    private ImageView iv_word;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    int[] images = {R.drawable.im1, R.drawable.im2, R.drawable.im3, R.drawable.im4, R.drawable.im5, R.drawable.im6,
            R.drawable.im7, R.drawable.im8, R.drawable.im9, R.drawable.im10, R.drawable.im11, R.drawable.im12,
            R.drawable.im13, R.drawable.im14, R.drawable.im15, R.drawable.im16, R.drawable.im17, R.drawable.im18,
            R.drawable.im19, R.drawable.im20, R.drawable.im21, R.drawable.im22, R.drawable.im23, R.drawable.im24,
            R.drawable.im25, R.drawable.im26, R.drawable.im27, R.drawable.im28};
    String[] letters = {"الف", "باء", "تاء", "ثاء", "جيم", "حاء", "خاء", "دال", "ذال", "راء", "زاى", "سين", "شين", "صاد", "ضاد", "طاء", "ظاء", "عين", "غين", "فاء", "قاف", "كاف", "لام", "ميم", "نون", "هاء", "واو", "ياء"};
    String[] letters2 = {"الف", "به", "ته", "ثه", "جيم", "حه", "خه", "دال", "ذال", "ره", "زيه", "سين", "شين", "صاض", "ضاض", "طه", "ظه", "عين", "غين", "فه", "قف", "كاف", "لام", "ميم", "نون", "هه", "واو", "ياء"};

    ArrayList<String> wrongLetters = new ArrayList<>();
    ArrayList<String> rightLetters = new ArrayList<>();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    int index = 0;
    private Button result, next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_mic = findViewById(R.id.btn_speak);
        iv_word = findViewById(R.id.iv_word);
        mText = findViewById(R.id.textView1);
        qText = findViewById(R.id.q_tv);
        mText2 = findViewById(R.id.textView2);
        iv_word.setImageResource(images[index]);
        result = (Button) findViewById(R.id.result);
        next = (Button) findViewById(R.id.next);

        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        iv_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-EG");
                intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.momen.dyslexia");
                //   intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 20000); // value to wait

                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);  // 1 is the maximum number of results to be returned.


                try {
                    startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                } catch (Exception e) {

                }
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_mic.setVisibility(View.INVISIBLE);
                iv_word.setVisibility(View.INVISIBLE);
                qText.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                result.setVisibility(View.INVISIBLE);
                result();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                Log.d("TAG", "onClick:uuu lenth " + letters.length);

                if (index < letters.length) {
                    Log.d("TAG", "onClick:uuu lenth " + index);

                    mText.setText("");
                    mText2.setText("");
                    iv_word.setImageResource(images[index]);
                } else {

                    Log.d("TAG", "onClick:uuu " + index);
                    if (wrongLetters.isEmpty() && rightLetters.isEmpty()) {
                        Log.d("TAG", "onClick:uuu in" + index);

                        index = 0;
                        iv_word.setImageResource(images[index]);
                    } else {
                        Log.d("TAG", "onClick:uuu out " + index);

                        mText.setText("");
                        mText2.setText("");
                        next.setVisibility(View.INVISIBLE);
                        result.setVisibility(View.VISIBLE);

                    }


                }

            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                Log.d("TAG", "onActivityResult:iii index  " + index);
                if (Objects.requireNonNull(result).get(0).equals(letters[index]) || Objects.requireNonNull(result).get(0).equals(letters2[index])) {
                    mText.setText(
                            "شاطر 👏");
                    if (wrongLetters.contains(letters[index]) || wrongLetters.contains(letters2[index])) {
                        wrongLetters.remove(wrongLetters.size() - 1);
                        rightLetters.add(letters[index]);
                    } else {
                        if (!rightLetters.contains(letters[index]) && !rightLetters.contains(letters2[index]))
                            rightLetters.add(letters[index]);
                    }
                    index++;
                    if (index < letters.length) {
                        iv_word.setImageResource(images[index]);

                    } else {
                        index = 0;
                        iv_word.setImageResource(images[index]);
                        result();

                    }
                } else {

                    mText.setText(
                            "حاول تانى 😢");
                    if (!wrongLetters.contains(letters[index]) && !wrongLetters.contains(letters2[index]))
                        wrongLetters.add(letters[index]);

                }

            }
        }
    }


    public void result() {

        Log.d("TAG", "result:index  " + index);


        /*if (rightLetters.size() > wrongLetters.size())
            mText.setText(
                    "شاطر 👏");
        else
            mText.setText(
                "حاول تانى 😢");*/
        mText.setText(
                "");


        if (rightLetters.size() != 0) {
            mText.append("النتيجة : " + rightLetters.size() + " من " + letters.length +
                    "\n الكلمات الصحيحة : \n");

            for (int x = 0; x < rightLetters.size(); x++) {
                mText.append(rightLetters.get(x) + ",");

            }
        }
        if (wrongLetters.size() != 0) {
            mText2.append(" الكلمات الخاطئة : \n ");
            for (int x = 0; x < wrongLetters.size(); x++) {
                mText2.append(wrongLetters.get(x) + ",");

            }
        }
        Set<String> set = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set.addAll(rightLetters);
        set2.addAll(wrongLetters);
        editor.putStringSet("rightLetters", set);
        editor.putStringSet("wrongLetters", set2);
        editor.putString("lvl1Deg", rightLetters.size() + " / " + letters.length);
        editor.commit();

        rightLetters.clear();
        wrongLetters.clear();


    }


}