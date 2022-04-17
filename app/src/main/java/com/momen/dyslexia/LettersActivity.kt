package com.momen.dyslexia

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
        "النشاط الثالث"
    )
    var story_l2 = arrayOf(
        "قصة 1",
        "قصة 2",
        "قصة 3",
        "قصة 4",
        "قصة 5",
        "قصة 6",
        "قصة 7",
        "قصة 8",
        "قصة 9",
        "قصة 10",
        "قصة 11",
        "قصة 12",
        "قصة 13",
        "قصة 14",


        )

    var arrange_levels = arrayOf(
        "صورة 1",
        "صورة 2",
        "صورة 3",
        "صورة 4",
        "صورة 5",
        "صورة 6",
        "صورة 7",
        "صورة 8",
        "فيديو 1",
        "فيديو 2",
        "فيديو 3",
        "فيديو 4",
    )
    var story = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letters)
        recyclerView = findViewById(R.id.activity_recycler)
        recyclerView!!.setHasFixedSize(true)

        val lvl = intent.getIntExtra("lvl", 0)
        var type = ""
        if (lvl == 0) {
            type = "3ady"
            lettersAdapter = LettersAdapter(letters)
        } else if (lvl == 1) {
            lettersAdapter = LettersAdapter(letters)
            type = "tanween"
        } else if (lvl == 2) {
            lettersAdapter = LettersAdapter(videos_levels)
            type = "learn"
        } else if (lvl == 3) {
            lettersAdapter = LettersAdapter(arrange_levels)
            type = "arrange"
        } else if (lvl == 4) {
            type = "story"
            story = intent.getIntExtra("story", 0)!!
            Log.d("TAG", "onCreate:story ${story} ")
            if (story == 1)
                lettersAdapter = LettersAdapter(letters)
            else if (story == 2)
                lettersAdapter = LettersAdapter(story_l2)


        }

        recyclerView!!.adapter = lettersAdapter
        lettersAdapter!!.setOnItemClickListener(LettersAdapter.OnItemClickListener { position ->
            startActivity(
                Intent(
                    this, DisplayLettersVideos::class.java
                ).putExtra("position", position).putExtra("type", type).putExtra("story", story)
            )
        })
    }
}