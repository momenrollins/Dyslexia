package com.momen.dyslexia

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.widget.VideoView
import android.widget.LinearLayout
import android.widget.ImageButton
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.momen.dyslexia.R
import kotlinx.android.synthetic.main.activity_display_letters_videos.*

class DisplayLettersVideos : AppCompatActivity() {
/*    private var videoView: VideoView? = null
    private var finishBtn: Button? = null
    private var options: LinearLayout? = null
    private var backBtn: ImageButton? = null
    private var replayBtn: ImageButton? = null
    private var nextBtn: ImageButton? = null*/

    var path: String? = null
    var videos = intArrayOf(
        R.raw.lv_1,
        R.raw.lv_2,
        R.raw.lv_3,
        R.raw.lv_4,
        R.raw.lv_5,
        R.raw.lv_6,
        R.raw.lv_7,
        R.raw.lv_8,
        R.raw.lv_9,
        R.raw.lv_10,
        R.raw.lv_11,
        R.raw.lv_12,
        R.raw.lv_13,
        R.raw.lv_14,
        R.raw.lv_15,
        R.raw.lv_16,
        R.raw.lv_17,
        R.raw.lv_18,
        R.raw.lv_19,
        R.raw.lv_20,
        R.raw.lv_21,
        R.raw.lv_22,
        R.raw.lv_23,
        R.raw.lv_24,
        R.raw.lv_25,
        R.raw.lv_26,
        R.raw.lv_27,
        R.raw.lv_28
    )
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_letters_videos)
        index = intent.getIntExtra("actvtyNum", 26)
        action(index)

            replayBtn.setOnClickListener {
                action(index)

            }
            nextBtn.setOnClickListener {
                index++
                action(index)

            }
            backBtn.setOnClickListener {
                index--
                action(index)

            }



      //  initView()
    }


    private fun action(index: Int) {

        options!!.visibility = View.GONE

        path = "android.resource://" + packageName + "/" + videos[index]
        videoView!!.setVideoURI(Uri.parse(path))
        videoView!!.start()
        videoView!!.setOnCompletionListener {
         options!!.visibility = View.VISIBLE
        }

        if (index==0){
            backBtn.visibility = View.GONE
        }else if (index== videos.size -1){
            nextBtn.visibility = View.GONE
        }else{
            nextBtn.visibility = View.VISIBLE
            backBtn.visibility = View.VISIBLE

        }
    }
   /* private fun initView() {
        videoView = findViewById<View>(R.id.videoView) as VideoView
        finishBtn = findViewById<View>(R.id.finishBtn) as Button
        options = findViewById<View>(R.id.options) as LinearLayout
        backBtn = findViewById<View>(R.id.backBtn) as ImageButton
        replayBtn = findViewById<View>(R.id.replayBtn) as ImageButton
        nextBtn = findViewById<View>(R.id.nextBtn) as ImageButton
    }*/
}