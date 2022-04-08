package com.momen.dyslexia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LettersImages extends AppCompatActivity {
    int[] images = {R.drawable.im1, R.drawable.im2, R.drawable.im3, R.drawable.im4, R.drawable.im5};
    int[] right_images = {R.drawable.lion, R.drawable.im_2, R.drawable.im_3, R.drawable.im_4, R.drawable.im_5};
    int[] left_images = {R.drawable.im_1, R.drawable.im_2_2, R.drawable.crown, R.drawable.im_4_2, R.drawable.im_5_2};
    private RecyclerView rvWords;
    private LettersImagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_images);
        initView();
        rvWords.setLayoutManager(new LinearLayoutManager(this));
        adapter=new LettersImagesAdapter(images,right_images,left_images);
        rvWords.setAdapter(adapter);
    }

    private void initView() {
        rvWords = (RecyclerView) findViewById(R.id.rv_words);
    }
}