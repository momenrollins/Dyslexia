package com.momen.dyslexia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        val itemListiner = object : CategoriesAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                if (position == 0)
                    startActivity(Intent(this@CategoriesActivity, PDFActivity::class.java))
                else if(position == 1)
                    startActivity(Intent(this@CategoriesActivity, MainActivity::class.java))

            }

        }
        categoriesAdapter = CategoriesAdapter(itemListiner, categoriesList)
        cate_recycler.adapter = categoriesAdapter


    }
}