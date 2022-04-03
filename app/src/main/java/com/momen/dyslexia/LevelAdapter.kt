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
                context.startActivity(
                    Intent(
                        context,
                        ChooseActivity::class.java
                    ).putExtra("index", position))
            }
            //)
            /*
                      )*/
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

        }

        init {
            initView(itemView)
        }
    }
}