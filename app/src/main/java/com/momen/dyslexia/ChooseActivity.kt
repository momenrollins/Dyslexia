package com.momen.dyslexia

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {
    val choosesList = ArrayList<ChooseModel>()
    var index = 0
    var degree = 0
    var comingFrom = ""
    var imgList = intArrayOf(
        R.drawable.im_5_2,
        R.drawable.kharof,
        R.drawable.dop,
        R.drawable.girl,
        R.drawable.zarafa,
        R.drawable.dagaga,
        R.drawable.plane,
        R.drawable.hera,
        R.drawable.feel,
        R.drawable.alp,
        R.drawable.kora,
        R.drawable.far,
        R.drawable.regl,
        R.drawable.st2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        sharedPreferences = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE)
        comingFrom = intent.getStringExtra("comingFrom")!!
        editor = sharedPreferences!!.edit()
        if (comingFrom == "0") {
            ans4.visibility = GONE
            paraText.visibility = GONE
            paraImg.visibility= VISIBLE
            fillFirstLetters()
        } else {
            fillChoose()
        }


        showQuestion(choosesList[index], index)
        ans1.setOnClickListener {
            if (ans1.text == choosesList[index].realAns)
                degree++
            handleClick()
        }
        ans2.setOnClickListener {
            if (ans2.text == choosesList[index].realAns)
                degree++
            handleClick()
        }
        ans3.setOnClickListener {
            if (ans3.text == choosesList[index].realAns)
                degree++
            handleClick()
        }
        ans4.setOnClickListener {
            if (ans4.text == choosesList[index].realAns)
                degree++
            handleClick()
        }
    }

    private fun fillChoose() {
        choosesList.add(
            ChooseModel(
                "الشيء التي تحبه ليلى هو",
                "النظافة", "الرياضة", "القراءة", "السباحة", "القراءة"
            )
        )
        choosesList.add(
            ChooseModel(
                "معنى كلمة مجتهدة في عبارة \" طالبة مجتهدة \" هي ",
                "تطيع والديها",
                "متفوقة في دروسها",
                "تحافظ على نظافة ملابسها",
                "تعتني بإخوتها",
                "متفوقة في دروسها"
            )
        )
        choosesList.add(
            ChooseModel(
                "في النص كلمة بمعني فرحت\" هي",
                "تحب", "تحافظ ", "اختارت", "سرت", "سرت"
            )
        )
        choosesList.add(
            ChooseModel(
                "رتبت ليلى الكتب ...",
                "على رفوف المكتبة", "في الخزانة", "على الطاولة", "في الحقيبة", "على رفوف المكتبة"
            )
        )
        choosesList.add(
            ChooseModel(
                "عكس كلمة تحافظ بالمعنى هو",
                "تهمل", "تعتني", "ترتب", "ترعى", "تهمل"
            )
        )
        choosesList.add(
            ChooseModel(
                "العنوان الأكثر مناسبة للنص هو",
                "الطالبة النظيفة",
                "الطالبة المطيعة",
                "الطالبة المجتهدة",
                "المكتبة",
                "الطالبة المجتهدة"
            )
        )
    }

    private fun fillFirstLetters() {
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ج",
                "س",
                "ز",
                "",
                "ج"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ج",
                "ح",
                "خ",
                "",
                "خ"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ق",
                "د",
                "ث",
                "",
                "د"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ت",
                "ن",
                "ب",
                "",
                "ب"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ز",
                "ص",
                "س",
                "",
                "ز"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ج",
                "د",
                "ة",
                "",
                "د"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "غ",
                "ط",
                "ر",
                "",
                "ط"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "هـ",
                "ي",
                "س",
                "",
                "هـ"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ب",
                "ف",
                "س",
                "",
                "ف"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ق",
                "ي",
                "س",
                "",
                "ق"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ت",
                "ا",
                "ك",
                "",
                "ك"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ف",
                "ي",
                "س",
                "",
                "ف"
            )
        )
        choosesList.add(
            ChooseModel(
                "اختار الحرف الأول",
                "ث",
                "س",
                "ر",
                "",
                "ر"
            )
        )
    }

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    @SuppressLint("SetTextI18n")
    private fun handleClick() {
        index++

        if (index < choosesList.size)
            showQuestion(choosesList[index],index)
        else {
            paraTv.visibility = GONE
            ans1.visibility = GONE
            ans2.visibility = GONE
            ans3.visibility = GONE
            ans4.visibility = GONE
            questionTv.text = "عدد الاجابات الصحيحة: $degree \n" +
                    "عدد الاجابات الخاطئة: ${choosesList.size - degree}"

            if (comingFrom == "0")
                editor!!.putString("lvl1FinalDeg", degree.toString() + " / " + (choosesList.size))
            else editor!!.putString("lvl6Deg", degree.toString() + " / " + (choosesList.size))
            editor!!.commit()

        }
    }

    private fun showQuestion(chooseModel: ChooseModel, index: Int) {
        if (comingFrom=="0")
            paraImg.setImageResource(imgList[index])
        questionTv.text = chooseModel.question
        ans1.text = chooseModel.ans1
        ans2.text = chooseModel.ans2
        ans3.text = chooseModel.ans3
        ans4.text = chooseModel.ans4
    }
}