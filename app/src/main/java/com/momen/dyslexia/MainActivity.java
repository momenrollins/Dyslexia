package com.momen.dyslexia;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private TextView mText;
    private ImageView iv_mic;
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_mic = findViewById(R.id.btn_speak);
        mText = findViewById(R.id.textView1);

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
                    Toast
                            .makeText(MainActivity.this, "" + e.getMessage(),
                                    Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                mText.setText(
                        Objects.requireNonNull(result).get(0));
            }
        }
    }


}