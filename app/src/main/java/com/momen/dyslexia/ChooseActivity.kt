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
        R.drawable.regl
    )
    var imgListL2 = intArrayOf(
        R.drawable.tmsaa7,
        R.drawable.tofa7a,
        R.drawable.crown,
        R.drawable.envelope,
        R.drawable.football,
        R.drawable.news_anchor,
        R.drawable.wristwatch,
        R.drawable.soldier,
        R.drawable.elephant,
        R.drawable.water,
        R.drawable.feather,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        sharedPreferences = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE)
        comingFrom = intent.getStringExtra("comingFrom")!!
        editor = sharedPreferences!!.edit()
        if (comingFrom == "l0") {
            ans4.visibility = GONE
            paraText.visibility = GONE
            paraImg.visibility = VISIBLE
            fillFirstLetters()
        } else if (comingFrom == "l1") {
            ans4.visibility = GONE
            paraText.visibility = GONE
            paraImg.visibility = VISIBLE
            fillFirstLettersL2()
        } else if (comingFrom == "l6") {
            paraText.visibility = VISIBLE
            paraImg.visibility = GONE
            paraText.text =
                "جلس الأب في الغرفة بعد يوم عمل متعب، وقرأ جريدة. وبعد مرور وقت قصير، إكتشف عليّ أن أباه قد نام والجريدة في يده."
            fillL6()
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
        fillArray(
            "اختار الحرف الأول",
            "ج",
            "س",
            "ز",
            "ج",
        )

        fillArray(
            "اختار الحرف الأول",
            "ج",
            "ح",
            "خ",
            "خ"
        )

        fillArray(
            "اختار الحرف الأول",
            "ق",
            "د",
            "ث",
            "د"
        )

        fillArray(
            "اختار الحرف الأول",
            "ت",
            "ن",
            "ب",
            "ب"
        )

        fillArray(
            "اختار الحرف الأول",
            "ز",
            "ص",
            "س",
            "ز"

        )
        fillArray(
            "اختار الحرف الأول",
            "ج",
            "د",
            "ة",
            "د"
        )

        fillArray(
            "اختار الحرف الأول",
            "غ",
            "ط",
            "ر",
            "ط"
        )

        fillArray(
            "اختار الحرف الأول",
            "هـ",
            "ي",
            "س",
            "هـ"
        )

        fillArray(
            "اختار الحرف الأول",
            "ب",
            "ف",
            "س",
            "ف"

        )
        fillArray(
            "اختار الحرف الأول",
            "ق",
            "ي",
            "س",
            "ق"

        )
        fillArray(
            "اختار الحرف الأول",
            "ت",
            "ا",
            "ك",
            "ك"
        )

        fillArray(
            "اختار الحرف الأول",
            "ف",
            "ي",
            "س",
            "ف"
        )

        fillArray(
            "اختار الحرف الأول",
            "ث",
            "س",
            "ر",
            "ر"
        )

    }


    private fun fillFirstLettersL2() {
        fillArray(
            "...ـمساح",
            "تَ",
            "تِ",
            "تُ",
            "تِ",
        )

        fillArray(
            "...ـفاحة",
            "تَ",
            "تِ",
            "تُ",
            "تُ",
        )

        fillArray(
            "...ـاج",
            "تَ",
            "تِ",
            "تُ",
            "تَ",
        )
        fillArray(
            "..ـرف",
            "ظِ",
            "ظُ",
            "ظَ",
            "ظَ",
        )
        fillArray(
            "...ـرة",
            "كُـ",
            "كِـ",
            "كَـ",
            "كُـ",
        )
        fillArray(
            "مـ...ـيع",
            "ذِ",
            "ذَ",
            "ذُ",
            "ذِ",
        )
        fillArray(
            "...ـاعة",
            "سَـ",
            "سُـ",
            "سِـ",
            "سَـ",
        )
        fillArray(
            "...ـندي",
            "جَـ",
            "جُـ",
            "جِـ",
            "جُـ",
        )
        fillArray(
            "...ـيل",
            "فَـ",
            "فُـ",
            "فِـ",
            "فِـ",
        )
        fillArray(
            "...جاجة",
            "ـز",
            "زَ",
            "زُ",
            "زُ",
        )
        fillArray(
            "...يشة",
            "رَ",
            "ـرْ",
            "رِ",
            "رِ",
        )

    }

    private fun fillL6() {
        choosesList.add(
            ChooseModel(
                "جلس الأب :",
                "ا. على السرير",
                "ب. في الغرفة",
                "ت. فوق الطاولة",
                "ث. على الكرسي ",
                "ب. في الغرفة"
            )
        )
        choosesList.add(
            ChooseModel(
                " ماذا عمل الأب بعد أن عاد من العمل؟",
                " أ. شاهد  (التليفزيون)",
                "ب عمل عملا شاقا",
                "ت. قرأ جريدة",
                "ث. تعب",
                "ت. قرأ جريدة"
            )
        )
        choosesList.add(
            ChooseModel(
                "اكتشف علي أن أباه قد نام:",
                "ا. بعد مرور وقت قصير",
                "ب، بعد مرور وقت طويل",
                "ت. بعد مرور ثلاث ساعات",
                "ث. بعد مرور خمس ساعات",
                "ا. بعد مرور وقت قصير"
            )
        )
        choosesList.add(
            ChooseModel(
                "لماذا غلب النوم على الأب؟",
                "أ. لأنه لم ينم في الليل",
                "ب. لأن البرنامج كان مملة",
                "ت. لأنه عمل عملا شاق ",
                "ث. لأنه عمل عملا ممتع ",
                "ت. لأنه عمل عملا شاق "
            )
        )
        choosesList.add(
            ChooseModel(
                "كلمة (جريدة) هي :-",
                "أ. فعل مضارع",
                "ب. فعل ماض",
                "ت.اسم ",
                "ث. حرف",
                "ت.اسم "
            )
        )
        choosesList.add(
            ChooseModel(
                "الشخصية الرئيسة في النص :",
                "عمار ",
                "خالد",
                "الام",
                "القطار ",
                "عمار "
            )
        )
        choosesList.add(
            ChooseModel(
                "دعا عمار صديقة خالدا:.",
                "ليذاكر معه ",
                "ليلعب معه",
                "ليسافر معه",
                "ليعمل معه",
                "ليلعب معه"
            )
        )
        choosesList.add(
            ChooseModel(
                "لعب عمار وخالد بـ :.",
                "القطار",
                "الكرة",
                "السيارة",
                "الطائرة",
                "القطار"
            )
        )
    }


    private fun fillArray(Q: String, ans1: String, ans2: String, ans3: String, realAns: String) {
        choosesList.add(
            ChooseModel(
                Q,
                ans1,
                ans2,
                ans3,
                "",
                realAns
            )
        )
    }

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    @SuppressLint("SetTextI18n")
    private fun handleClick() {
        index++

        if (index < choosesList.size) {
            if (comingFrom == "l6" && index == 5)
                paraText.text = "دعا عمار صديقه خالدا ليلعب معه بقطاره الجديد، و طلب منه أن يمسكه حتّى ينتهي من تركيب القضبان. لكنه سقط من يده فتكسر و تفككت اجزاؤه . غضب عمار وصرخ قائلا : ماذا فعلت بلعبتي ؟\n" +
                        "أرميتها على الأرض لتكسرها ؟ رد خالد: لقد سقطت من يدي من غير قصد، وأرجو أن تسامحني . دخلت الأم وسألت عمارا عن سبب صراخه، فحكي لها ما حدث. ابتسمت الأم وقالت : يا بني، سأشتري لك قطارا جديدا، ولكن من أين أتي لك\n" +
                        "بصديق كخالد ؟\n" +
                        "ندم عمار على تسرعه، واعتذر إلى خالد، وراحا يلعبان معا .\n"
            showQuestion(choosesList[index], index)
        } else {
            paraTv.visibility = GONE
            ans1.visibility = GONE
            ans2.visibility = GONE
            ans3.visibility = GONE
            ans4.visibility = GONE
            questionTv.text = "عدد الاجابات الصحيحة: $degree \n" +
                    "عدد الاجابات الخاطئة: ${choosesList.size - degree}"

            if (comingFrom == "0")
                editor!!.putString("lvl1FinalDeg", degree.toString() + " / " + (choosesList.size))
            else editor!!.putString(
                "lvl6Deg$comingFrom",
                degree.toString() + " / " + (choosesList.size)
            )
            editor!!.commit()

        }
    }

    private fun showQuestion(chooseModel: ChooseModel, index: Int) {
        if (comingFrom == "l0")
            paraImg.setImageResource(imgList[index])
        else if (comingFrom == "l1")
            paraImg.setImageResource(imgListL2[index])

        questionTv.text = chooseModel.question
        ans1.text = chooseModel.ans1
        ans2.text = chooseModel.ans2
        ans3.text = chooseModel.ans3
        ans4.text = chooseModel.ans4
    }
}