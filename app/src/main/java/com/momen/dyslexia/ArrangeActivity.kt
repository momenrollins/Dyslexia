package com.momen.dyslexia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_arrange.*

class ArrangeActivity : AppCompatActivity() {
    var imgs1 = intArrayOf(R.drawable.ar1, R.drawable.ar2, R.drawable.ar3, R.drawable.ar4)
    var imgs2 = intArrayOf(R.drawable.ar1, R.drawable.ar2, R.drawable.ar3)
    var numbers1 = arrayListOf("1", "2", "3", "4")
    var numbers2 = arrayListOf("1", "2", "3")
    var modelList: ArrayList<ArrangeModel> = ArrayList()
    var arrangeAdapter: ArrangeAdapter? = null
    var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrange)
        modelList.add(ArrangeModel(imgs1, numbers1))
        modelList.add(ArrangeModel(imgs2, numbers2))
        arrange_recycler.setHasFixedSize(true)
        arrangeAdapter = ArrangeAdapter(this, modelList[0])
        arrange_recycler.adapter = arrangeAdapter

        arrange_next.setOnClickListener {
            index++
            arrangeAdapter?.updateList(modelList[index])
        }
    }
}