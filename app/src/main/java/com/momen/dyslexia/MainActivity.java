package com.momen.dyslexia;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private TextView mText;
    private TextView mText2;
    private ImageView iv_mic;
    private ImageView iv_word;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    int[] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f};
    String[] letters = {"الف", "باء", "جيم", "دال", "ميم", "خاء"};
    ArrayList<String> wrongLetters = new ArrayList();
    ArrayList<String> rightLetters = new ArrayList();

    int index = 0;
    private Button result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_mic = findViewById(R.id.btn_speak);
        iv_word = findViewById(R.id.iv_word);
        mText = findViewById(R.id.textView1);
        mText2 = findViewById(R.id.textView2);
        iv_word.setImageResource(images[index]);
        result = (Button) findViewById(R.id.result);

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
                result();
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
                if (Objects.requireNonNull(result).get(0).equals(letters[index])) {
                    mText.setText(
                            "شاطر 👏");
                    if (!wrongLetters.contains(letters[index]))
                        rightLetters.add(letters[index]);
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
                    wrongLetters.add(letters[index]);

                }

            }
        }
    }


    public void result() {

        Log.d("TAG", "result:index  " + index);

/*

        if (rightLetters.size() > wrongLetters.size())
            mText.setText(
                    "شاطر 👏");
        else mText.setText(
                "حاول تانى 😢");
*/
        mText.setText("");

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
        rightLetters.clear();
        wrongLetters.clear();
    }

    public void Go_To_Leve_1(View view) {

        index++;
        if (index < letters.length) {
            iv_word.setImageResource(images[index]);
        } else {
            mText.setText("");
            mText2.setText("");
            rightLetters.clear();
            wrongLetters.clear();
            index = 0;
            iv_word.setImageResource(images[index]);


        }


    }


}