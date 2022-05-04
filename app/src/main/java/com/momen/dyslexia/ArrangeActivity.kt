package com.momen.dyslexia

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_arrange.*

class ArrangeActivity : AppCompatActivity() {
    var imgs1 = intArrayOf( R.drawable.ar3,R.drawable.ar1, R.drawable.ar2, R.drawable.ar4)
    var imgs2 = intArrayOf(R.drawable.story_g_2, R.drawable.story_g_3, R.drawable.story_g_1)
    var imgs3 = intArrayOf(
        R.drawable.story_hant_3,
        R.drawable.stiry_hant_1,
        R.drawable.story_hant_2,
        R.drawable.story_hant_4
    )
    var imgs4 = intArrayOf(
        R.drawable.story_baird_h_3,
        R.drawable.story_baird_h_1,
        R.drawable.story_baird_h_2,
        R.drawable.story_baird_h_4
    )
    var imgs5 = intArrayOf(
        R.drawable.story_man_4,
        R.drawable.story_man_2,
        R.drawable.story_man_1,
        R.drawable.story_man_3,
        R.drawable.story_man_5
    )
    var imgs6 = intArrayOf(
        R.drawable.story_tree_2,
        R.drawable.story_tree_1,
        R.drawable.story_tree_3,
        R.drawable.story_tree_4
    )
    var numbers1 = arrayListOf("2", "1", "3", "4")
    var numbers2 = arrayListOf("2", "3", "1")
    var numbers3 = arrayListOf("3","1", "2",  "4")
    var numbers4 = arrayListOf("3","1", "2",  "4")
    var numbers5 = arrayListOf("4", "2", "1", "3", "5")
    var numbers6 = arrayListOf("2", "1", "3", "4")
    var list: ArrayList<String> = ArrayList()
    var modelList: ArrayList<ArrangeModel> = ArrayList()
    var arrangeAdapter: ArrangeAdapter? = null
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var index = 0
    var count = 0
    var isSuccess = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrange)
        sharedPreferences = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        modelList.add(ArrangeModel(imgs1, numbers1))
        modelList.add(ArrangeModel(imgs2, numbers2))
        modelList.add(ArrangeModel(imgs3, numbers3))
        modelList.add(ArrangeModel(imgs4, numbers4))
        modelList.add(ArrangeModel(imgs5, numbers5))
        modelList.add(ArrangeModel(imgs6, numbers6))
        list.addAll(numbers1)
        list.reverse()
        arrange_recycler.setHasFixedSize(true)

        arrangeAdapter = ArrangeAdapter(this, modelList[0], list)
        arrange_recycler.adapter = arrangeAdapter

        arrange_next.setOnClickListener {
            Log.d("TAG", "onCreate:index ${index} ")
            index++

            if (index <= 5) {
                result()


                list.addAll(modelList[index].numbers)
                list.reverse()
                arrangeAdapter?.updateList(modelList[index])
            } else {
                arrange_next.visibility = View.GONE
                arrange_recycler.visibility = View.GONE
                txt_view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);

                result()
                editor!!.putString("story", "${count} / 6")
                editor!!.commit()
                txt_view.text = " ${sharedPreferences!!.getString("story", "")}"
            }


        }
    }

    fun result() {
        for (x in 0 until arrangeAdapter!!.numbersAns.size) {
            if (arrangeAdapter!!.numbersAns[x].equals(modelList[index - 1].numbers[x])) {
                isSuccess = true
            } else {
                isSuccess = false
                break
            }
        }
        if (isSuccess) count++
        isSuccess = false

    }

}