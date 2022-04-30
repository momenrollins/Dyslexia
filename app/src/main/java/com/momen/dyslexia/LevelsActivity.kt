package com.momen.dyslexia

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_levels.*

class LevelsActivity : AppCompatActivity() {
    var sharedPreferences: SharedPreferences? = null
    val levels = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)
        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)

        val activity = intent.getStringExtra("activity")
        Log.d("TAG", "onCreate: ac")

        if (activity == "1") {
            levels.add("المستوى الأول")
            levels.add("المستوى الثاني")
            levels.add("المستوى الثالث")
            levels.add("المستوى الرابع")
            levels.add("المستوى الخامس")
            levels.add("المستوى السادس")
        } else if (activity == "2") {
            levels.add("تعليم الطفل الحروف الابجدية واصواتها")
            levels.add("تعليم الحركات الضمة والفتحة والكسره")
            levels.add("تعليم الطفل دمج الحروف وتكوين كلمه")
            levels.add("تعليم الطفل دمج الكلمات وتكوين جمله")
            levels.add("تعليم الطفل قصة قصيره")
            levels.add("تعليم الطفل الفهم القراءي")
            fab.visibility = GONE
        } else {
            levels.add("التعرف على الحرف الاول والاوسط من الكلمة والتميز بين الحروف المتشابهه")
            levels.add("التميز بين الحركات الضمة والفتحة والكسره")
            levels.add("القدرة على تكوين كلمة من حروف")
            levels.add("القدرة على تكوين جملة من كلمات")
            levels.add("القدرة على فهم وترتيب قصة قصيرة")
            levels.add("القدرة على الفهم القرائي")
        }
        fab.setOnClickListener {
            openDialog()
        }
        level_recycler.setLayoutManager(LinearLayoutManager(this))
        level_recycler.setAdapter(LevelAdapter(levels, this))
    }

    private fun openDialog() {
        val dialog = Dialog(this)
        dialog.setTitle("النتائج")
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.result_dialog)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.getWindow()!!.getAttributes())
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
//                lp.height = 500
        dialog.show()
        dialog.getWindow()!!.setAttributes(lp)
        val dialogTxt: TextView = dialog.findViewById<TextView>(R.id.text_dialog)
        var set: Set<String> = HashSet()
        var degree1=""
        var degree2=""
        var degree3=""
        var degree4=""
        var degree5=""
        var degree6=""
        if (levels.contains("التعرف على الحرف الاول والاوسط من الكلمة والتميز بين الحروف المتشابهه")){
             degree1 = sharedPreferences!!.getString("lvl6Degl0", "--")!!
             degree2 = sharedPreferences!!.getString("lvl6Degl1", "--")!!
             degree3 = sharedPreferences!!.getString("lvl3Deg_bo3dy", "--")!!
             degree4 = sharedPreferences!!.getString("lvl4Deg_bo3dy", "--")!!
             degree5 = sharedPreferences!!.getString("story", "--")!!
             degree6 = sharedPreferences!!.getString("lvl6Degl6", "--")!!


            dialogTxt.append("\nالمستوى الاول:")
            dialogTxt.append("\nالدرجة: $degree1")
            if (set.isNotEmpty()) {

                dialogTxt.append("\n الكلمات الخاطئة")
                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            } else {
                //      dialogTxt.append("\n---")

            }


            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الثانى:")
            dialogTxt.append("\nالدرجة: $degree2")

            set = sharedPreferences!!.getStringSet("words_wrong_l3_bo3dy", HashSet())!!

            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الثالث:")
            dialogTxt.append("\nالدرجة: $degree3")

            if (set.isNotEmpty()) {
                dialogTxt.append("\n الكلمات الخاطئة: ")

                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            }

            set = sharedPreferences!!.getStringSet("words_wrong_l4_bo3dy", HashSet())!!
            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الرابع:")
            dialogTxt.append("\nالدرجة: $degree4")

            if (set.isNotEmpty()) {
                dialogTxt.append("\n الكلمات الخاطئة: ")

                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            }
            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الخامس:")
            dialogTxt.append("\nالدرجة: $degree5")

            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى السادي:")
            dialogTxt.append("\nالدرجة: $degree6")

        }else{
            set = sharedPreferences!!.getStringSet("wrongLetters", HashSet())!!
             degree1 = sharedPreferences!!.getString("lvl1Deg", "--")!!
             degree2 = sharedPreferences!!.getString("lvl2Deg", "--")!!
             degree3 = sharedPreferences!!.getString("lvl3Deg", "--")!!
             degree4 = sharedPreferences!!.getString("lvl4Deg", "--")!!
             degree5 = sharedPreferences!!.getString("lvl5Deg", "--")!!
             degree6 = sharedPreferences!!.getString("lvl6Deg", "--")!!

            dialogTxt.append("\nالمستوى الاول:")
            dialogTxt.append("\nالدرجة: $degree1")
            if (set.isNotEmpty()) {

                dialogTxt.append("\n الكلمات الخاطئة")
                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            } else {
                //      dialogTxt.append("\n---")

            }
            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الثانى:")
            dialogTxt.append("\nالدرجة: $degree2")

            set = sharedPreferences!!.getStringSet("wrong_words_l2", HashSet())!!
            if (set.isNotEmpty()) {
                dialogTxt.append("\n الكلمات الخاطئة: ")

                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            } else {
                //      dialogTxt.append("\n---")

            }


            set = sharedPreferences!!.getStringSet("words_wrong_l3", HashSet())!!

            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الثالث:")
            dialogTxt.append("\nالدرجة: $degree3")

            if (set.isNotEmpty()) {
                dialogTxt.append("\n الكلمات الخاطئة: ")

                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            }

            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الرابع:")
            dialogTxt.append("\nالدرجة: $degree4")

            set = sharedPreferences!!.getStringSet("selectFLettersWrong", HashSet())!!
            if (set.isNotEmpty()) {
                dialogTxt.append("\n الكلمات الخاطئة: ")

                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            } else {
                //      dialogTxt.append("\n---")

            }
            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى الخامس:")
            dialogTxt.append("\nالدرجة: $degree5")

            set = sharedPreferences!!.getStringSet("wrongLetters_l5", HashSet())!!
            if (set.isNotEmpty()) {
                dialogTxt.append("\n الكلمات الخاطئة: ")

                set.forEach { s ->
                    dialogTxt.append("${s},")
                }
            } else {
                //      dialogTxt.append("\n---")

            }
            dialogTxt.append("\n==========================")
            dialogTxt.append("\nالمستوى السادي:")
            dialogTxt.append("\nالدرجة: $degree6")
        }








        val dialogButton: Button = dialog.findViewById(R.id.btn_dialog) as Button
        dialogButton.setOnClickListener(View.OnClickListener { dialog.dismiss() })

        dialog.show()
    }

}