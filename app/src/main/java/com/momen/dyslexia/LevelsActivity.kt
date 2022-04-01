package com.momen.dyslexia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_levels.*

class LevelsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)
        val levels = ArrayList<String>()
        levels.add("المستوى الأول")
        levels.add("المستوى الثاني")
        levels.add("المستوى الثالث")
        levels.add("المستوى الرابع")
        levels.add("المستوى الخامس")

        level_recycler.setLayoutManager(LinearLayoutManager(this))
        level_recycler.setAdapter(LevelAdapter(levels, this))
    }
}