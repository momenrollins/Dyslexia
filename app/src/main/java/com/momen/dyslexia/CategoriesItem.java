package com.momen.dyslexia;

public class CategoriesItem {
    int cateImg;
    String cateTitle;

    public CategoriesItem(int cateImg, String cateTitle) {
        this.cateImg = cateImg;
        this.cateTitle = cateTitle;
    }

    public int getCateImg() {
        return cateImg;
    }

    public void setCateImg(int cateImg) {
        this.cateImg = cateImg;
    }

    public String getCateTitle() {
        return cateTitle;
    }

    public void setCateTitle(String cateTitle) {
        this.cateTitle = cateTitle;
    }
}
