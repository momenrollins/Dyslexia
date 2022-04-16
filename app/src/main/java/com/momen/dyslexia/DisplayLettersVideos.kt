package com.momen.dyslexia

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    var tanween_videos = intArrayOf(
        R.raw.tanwen_v_1,
        R.raw.tanwen_v_2,
        R.raw.tanwen_v_3,
        R.raw.tanwen_v_4,
        R.raw.tanwen_v_5,
        R.raw.tanwen_v_6,
        R.raw.tanwen_v_7,
        R.raw.tanwen_v_8,
        R.raw.tanwen_v_9,
        R.raw.tanwen_v_10,
        R.raw.tanwen_v_11,
        R.raw.tanwen_v_12,
        R.raw.tanwen_v_13,
        R.raw.tanwen_v_14,
        R.raw.tanwen_v_15,
        R.raw.tanwen_v_16,
        R.raw.tanwen_v_17,
        R.raw.tanwen_v_18,
        R.raw.tanwen_v_19,
        R.raw.tanwen_v_20,
        R.raw.tanwen_v_21,
        R.raw.tanwen_v_22,
        R.raw.tanwen_v_23,
        R.raw.tanwen_v_24,
        R.raw.tanwen_v_25,
        R.raw.tanwen_v_26,
        R.raw.tanwen_v_27,
        R.raw.tanwen_v_28

    )
    var videos_learn = intArrayOf(
        R.raw.first_v,
        R.raw.secand_v,
        R.raw.thaird_v
    )
    var arrangeList = intArrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,
        R.drawable.p7,
        R.drawable.p8,
        R.raw.thaird_v
    )
    var index = 0
    var type = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_letters_videos)
        index = intent.getIntExtra("position", 0)
        type = intent.getStringExtra("type")!!
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
        if (index == 0) {
            backBtn.visibility = View.INVISIBLE
        } else {
            nextBtn.visibility = View.VISIBLE
            backBtn.visibility = View.VISIBLE
        }
        if (type.equals("learn")) {
            if (index == videos_learn.size - 1) {
                nextBtn.visibility = View.INVISIBLE
            }
        } else {
            if (index == videos.size - 1) {
                nextBtn.visibility = View.INVISIBLE
            }
        }

        if (type == "arrange" && index < 8) {
            replayBtn.visibility = View.INVISIBLE
            imageView.visibility = View.VISIBLE
            videoView.visibility = View.INVISIBLE
            imageView.setImageResource(arrangeList[index])
        } else {
            replayBtn.visibility = View.VISIBLE
            videoView.visibility = View.VISIBLE
            imageView.visibility = View.INVISIBLE
            if (type.equals("3ady"))
                path = "android.resource://" + packageName + "/" + videos[index]
            else if (type.equals("tanween"))
                path = "android.resource://" + packageName + "/" + tanween_videos[index]
            else if (type.equals("learn"))
                path = "android.resource://" + packageName + "/" + videos_learn[index]
            else if (type.equals("arrange")) {
                path = "android.resource://" + packageName + "/" + arrangeList[index]
            }
            videoView!!.setVideoURI(Uri.parse(path))
            videoView!!.start()
        }
        /*videoView!!.setOnCompletionListener {
         options!!.visibility = View.VISIBLE
        }*/


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