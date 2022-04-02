package com.momen.dyslexia

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class LevelAdapter(var levelTextArray: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<LevelAdapter.ViewHolderLevel>() {
    var sharedPreferences: SharedPreferences? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLevel {
        return ViewHolderLevel(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_level, parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolderLevel,
        @SuppressLint("RecyclerView") position: Int
    ) {

        holder.levelText!!.text = levelTextArray[position]
        holder.levelCard!!.setOnClickListener {
            if (position == 0)
                context.startActivity(
                    Intent(
                        context,
                        LettersRecord::class.java
                    ).putExtra("index", position)
                )
            else if (position == 1) context.startActivity(
                Intent(
                    context,
                    Level1Activity::class.java
                ).putExtra("index", position)
            )
            else if (position == 2) context.startActivity(
                Intent(
                    context,
                    WordsActivity::class.java
                ).putExtra("index", position)
            )
            else if (position == 3) context.startActivity(
                Intent(
                    context,
                    SelectLetter::class.java
                ).putExtra("index", position)
            )
            else if (position == 4) context.startActivity(
                Intent(
                    context,
                    OrderWordsActivity::class.java
                ).putExtra("index", position)
            ) else {
                val dialog = Dialog(context)
                dialog.setTitle("النتائج")
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(false)
                dialog.setContentView(R.layout.result_dialog)
                val lp = WindowManager.LayoutParams()
                lp.copyFrom(dialog.getWindow()!!.getAttributes())
                lp.width = WindowManager.LayoutParams.MATCH_PARENT
//                lp.height = 500
                dialog.show()
                dialog.getWindow()!!.setAttributes(lp)
                val dialogTxt: TextView = dialog.findViewById<TextView>(R.id.text_dialog)
                var set: Set<String> = HashSet()
                set = sharedPreferences!!.getStringSet("wrongLetters", null)!!

                dialogTxt.append("\nالمستوى الاول:")
                if (set.isNotEmpty()) {

                    dialogTxt.append("\n الكلمات الخاطئة")
                    set.forEach { s ->
                        dialogTxt.append("${s},")
                    }
                }else{
                    dialogTxt.append("\n لاتوجد كلمات خاطئة")

                }
                dialogTxt.append("\n==========================")
                dialogTxt.append("\nالمستوى الثانى:")

                set=sharedPreferences!!.getStringSet("wrong_words_l2",null)!!
                if (set.isNotEmpty()) {
                    dialogTxt.append("\n الكلمات الخاطئة:")

                    set.forEach { s ->
                        dialogTxt.append("${s},")
                    }
                }else{
                    dialogTxt.append("\n لاتوجد كلمات خاطئة")

                }
                dialogTxt.append("\n==========================")
                dialogTxt.append("\nالمستوى الثالث:")

                set=sharedPreferences!!.getStringSet("words_wrong_l3",null)!!
                if (set.isNotEmpty()) {
                    dialogTxt.append("\n الكلمات الخاطئة:")

                    set.forEach { s ->
                        dialogTxt.append("${s},")
                    }
                }else{
                    dialogTxt.append("\n لاتوجد كلمات خاطئة")

                }
                dialogTxt.append("\n==========================")
                dialogTxt.append("\nالمستوى الرابع:")

                set=sharedPreferences!!.getStringSet("selectFLettersWrong",null)!!
                if (set.isNotEmpty()) {
                    dialogTxt.append("\n الكلمات الخاطئة:")

                    set.forEach { s ->
                        dialogTxt.append("${s},")
                    }
                }else{
                    dialogTxt.append("\n لاتوجد كلمات خاطئة")

                }
                dialogTxt.append("\n==========================")
                dialogTxt.append("\nالمستوى الخامس:")

                set=sharedPreferences!!.getStringSet("wrongLetters_l5",null)!!
                if (set.isNotEmpty()) {
                    dialogTxt.append("\n الكلمات الخاطئة:")

                    set.forEach { s ->
                        dialogTxt.append("${s},")
                    }
                }else{
                    dialogTxt.append("\n لاتوجد كلمات خاطئة")

                }


                val dialogButton: Button = dialog.findViewById(R.id.btn_dialog) as Button
                dialogButton.setOnClickListener(View.OnClickListener { dialog.dismiss() })

                dialog.show()

            }
        }
    }

    override fun getItemCount(): Int {
        return levelTextArray.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolderLevel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var levelText: TextView? = null
        var levelCard: CardView? = null

        fun initView(view: View) {
            levelText = view.findViewById(R.id.level_text)
            levelCard = view.findViewById(R.id.level_card)
            sharedPreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)

        }

        init {
            initView(itemView)
        }
    }
}