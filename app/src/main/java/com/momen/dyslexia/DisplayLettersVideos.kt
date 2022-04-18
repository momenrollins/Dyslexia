package com.momen.dyslexia

import android.content.pm.ActivityInfo
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
        R.raw.story_v1,
        R.raw.story_v2,
        R.raw.story_v3,
        R.raw.story_v4
    )
    var story1List = intArrayOf(
        R.drawable.st1,
        R.drawable.st2,
        R.drawable.st3,
        R.drawable.st4,
        R.drawable.st5,
        R.drawable.st6,
        R.drawable.st7,
        R.drawable.st8,
        R.drawable.st9,
        R.drawable.st10,
        R.drawable.st11,
        R.drawable.st12,
        R.drawable.st13,
        R.drawable.st14,
        R.drawable.st15,
        R.drawable.st16,
        R.drawable.st17,
        R.drawable.st18,
        R.drawable.st19,
        R.drawable.st20,
        R.drawable.st21,
        R.drawable.st22,
        R.drawable.st23,
        R.drawable.st24,
        R.drawable.st25,
        R.drawable.st26,
        R.drawable.st27,
        R.drawable.st28,
    )
    var story2List = intArrayOf(
        R.drawable.s_img1,
        R.drawable.s_img2,
        R.drawable.s_img3,
        R.drawable.s_img4,
        R.drawable.s_img5,
        R.drawable.s_img6,
        R.drawable.s_img7,
        R.drawable.s_img8,
        R.drawable.s_img9,
        R.drawable.s_img10,
        R.drawable.s_img11,
        R.drawable.s_img12,
        R.drawable.s_img13,
        R.drawable.s_img14,
    )
    var index = 0
    var type = ""
    var story = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_letters_videos)
        index = intent.getIntExtra("position", 0)
        type = intent.getStringExtra("type")!!
        story = intent.getIntExtra("story", 0)
        if (type == "arrange")
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
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
    }


    private fun action(index: Int) {
        if (index == 0) {
            backBtn.visibility = View.INVISIBLE
        } else {
            nextBtn.visibility = View.VISIBLE
            backBtn.visibility = View.VISIBLE
        }
        if (type.equals("learn")) {
            if (index == videos_learn.size - 1)
                nextBtn.visibility = View.INVISIBLE

        } else if (type.equals("arrange")) {
            if (index == arrangeList.size - 1)
                nextBtn.visibility = View.INVISIBLE

        } else if (type.equals("story") && story == 3) {
            nextBtn.visibility = View.INVISIBLE
        } else {
            if (index == videos.size - 1) {
                nextBtn.visibility = View.INVISIBLE
            }
        }

        if (type == "arrange" && index < 8 || type == "story" && story != 3) {
            replayBtn.visibility = View.INVISIBLE
            imageView.visibility = View.VISIBLE
            videoView.visibility = View.INVISIBLE
            if (type == "arrange")
                imageView.setImageResource(arrangeList[index])
            else {
                if (story == 1)
                    imageView.setImageResource(story1List[index])
                if (story == 2) {
                    if (index == story2List.size - 1) {
                        nextBtn.visibility = View.INVISIBLE
                    }
                    imageView.setImageResource(story2List[index])

                }
            }
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
            } else if (type.equals("story")) {
                path = "android.resource://" + packageName + "/" + R.raw.story3
            }

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            videoView!!.setVideoURI(Uri.parse(path))
            videoView!!.start()
        }

    }
}