package com.momen.dyslexia

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
        categoriesList.add(CategoriesItem(R.drawable.vector, "نبذة عن صعوبات التعلم"))
        categoriesList.add(CategoriesItem(R.drawable.vector, "الاختبار القبلي للقراءة"))
        categoriesList.add(CategoriesItem(R.drawable.vector, "انشطة لعسر القراءة"))
        categoriesList.add(CategoriesItem(R.drawable.vector, "الاختبار البعدي للقراءة"))
        categoriesAdapter = CategoriesAdapter(categoriesList)
        cate_recycler.adapter=categoriesAdapter
    }
}