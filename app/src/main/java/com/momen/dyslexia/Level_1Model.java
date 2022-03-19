package com.momen.dyslexia;

import android.widget.ImageView;

public class Level_1Model {
    int image;
    String firstLetter;
    String lastLetter;

    public Level_1Model(int image, String firstLetter, String lastLetter) {
        this.image = image;
        this.firstLetter = firstLetter;
        this.lastLetter = lastLetter;
    }

    public Level_1Model() {
    }
}
