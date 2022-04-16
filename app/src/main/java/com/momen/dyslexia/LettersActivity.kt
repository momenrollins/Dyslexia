package com.momen.dyslexia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class LettersActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var lettersAdapter: LettersAdapter? = null
    var letters = arrayOf(
        "أ: ألف",
        "ب: باء",
        "ت: تاء",
        "ث: ثاء",
        "ج: جيم",
        "ح: حاء",
        "خ: خاء",
        "د: دال",
        "ذ: ذال",
        "ر: راء",
        "ز: زين",
        "س: سين",
        "ش: شين",
        "ص: صاد",
        "ض: ضاد",
        "ط: طاء",
        "ظ: ظاء",
        "ع: عين",
        "غ: غين",
        "ف: فاء",
        "ق: قاف",
        "ك: كاف",
        "ل: لام",
        "م: ميم",
        "ن: نون",
        "هـ: هاء",
        "و: واو",
        "ي: ياء"
    )
    var videos_levels = arrayOf(
        "النشاط الاول",
        "النشاط الثانى",
        "النشاط الثالث")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letters)
        recyclerView = findViewById(R.id.activity_recycler)
        recyclerView!!.setHasFixedSize(true)

        val lvl = intent.getIntExtra("lvl", 0)
        var type=""
        if (lvl == 0){
            type = "3ady"
            lettersAdapter = LettersAdapter(letters)

        }
        else if (lvl == 1) {
            lettersAdapter = LettersAdapter(letters)
            type = "tanween"
        }else if (lvl == 2) {
            lettersAdapter = LettersAdapter(videos_levels)
            type = "learn"
        }



        recyclerView!!.adapter = lettersAdapter

        lettersAdapter!!.setOnItemClickListener(LettersAdapter.OnItemClickListener { position ->
            startActivity(
                Intent(
                    this, DisplayLettersVideos::class.java
                ).putExtra("position", position).putExtra("type", type)
            )
        })
    }
}