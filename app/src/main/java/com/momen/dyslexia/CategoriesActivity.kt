package com.momen.dyslexia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity() {
    lateinit var categoriesAdapter: CategoriesAdapter
    var categoriesList = ArrayList<CategoriesItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        cate_recycler.setHasFixedSize(true)
        categoriesList.add(CategoriesItem(R.drawable.hard, "نبذة عن صعوبات التعلم"))
        categoriesList.add(CategoriesItem(R.drawable.reading, "الاختبار القبلي للقراءة"))
        categoriesList.add(CategoriesItem(R.drawable.activites, "انشطة لعسر القراءة"))
        categoriesList.add(CategoriesItem(R.drawable.exam, "الاختبار البعدي للقراءة"))
        val itemListiner = CategoriesAdapter.OnItemClickListener { position ->
            if (position == 0)
                startActivity(Intent(this@CategoriesActivity, PDFActivity::class.java))
            else if (position == 1)
                startActivity(Intent(this@CategoriesActivity, LevelsActivity::class.java))
            else if (position == 2)
                startActivity(Intent(this@CategoriesActivity, LettersImages::class.java))
/*
            else if (position == 3)
                startActivity(Intent(this@CategoriesActivity, WordsActivity::class.java))*/


        }
        categoriesAdapter = CategoriesAdapter(itemListiner, categoriesList)
        cate_recycler.adapter = categoriesAdapter


    }
}