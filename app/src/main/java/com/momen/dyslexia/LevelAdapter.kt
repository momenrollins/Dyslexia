package com.momen.dyslexia

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.momen.dyslexia.R
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import java.util.ArrayList

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
            context.startActivity(
                Intent(
                    context,
                    Level1Activity::class.java
                ).putExtra("index", position)
            )
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