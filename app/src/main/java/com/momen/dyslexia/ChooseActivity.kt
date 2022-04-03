package com.momen.dyslexia

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {
    val choosesList = ArrayList<ChooseModel>()
    var index = 0
    var degree = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        sharedPreferences = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
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

        showQuestion(choosesList[index])
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

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    @SuppressLint("SetTextI18n")
    private fun handleClick() {
        index++

        if (index < 6)
            showQuestion(choosesList[index])
        else {
            paraTv.visibility = GONE
            ans1.visibility = GONE
            ans2.visibility = GONE
            ans3.visibility = GONE
            ans4.visibility = GONE
            questionTv.text = "عدد الاجابات الصحيحة: $degree \n" +
                    "عدد الاجابات الخاطئة: ${choosesList.size - degree}"

            editor!!.putString("lvl6Deg", degree.toString() + " / " + (choosesList.size))
            editor!!.commit()

        }
    }

    private fun showQuestion(chooseModel: ChooseModel) {
        questionTv.text = chooseModel.question
        ans1.text = chooseModel.ans1
        ans2.text = chooseModel.ans2
        ans3.text = chooseModel.ans3
        ans4.text = chooseModel.ans4
    }
}