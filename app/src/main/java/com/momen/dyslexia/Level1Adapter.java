package com.momen.dyslexia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Level1Adapter extends RecyclerView.Adapter<Level1Adapter.ViewHolderLevel> {

    ArrayList<Level_1Model> level_1ModelList;

    public Level1Adapter(ArrayList<Level_1Model> level_1ModelsList) {
        this.level_1ModelList=level_1ModelsList;
    }


    @NonNull
    @Override
    public ViewHolderLevel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new ViewHolderLevel(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.level_1_item, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLevel holder, int position) {

        holder.ivWord.setImageResource(level_1ModelList.get(position).image);
        holder.firstWord.setText(level_1ModelList.get(position).firstLetter);
        holder.secandWord.setText(level_1ModelList.get(position).lastLetter);
    }

    @Override
    public int getItemCount() {
        return level_1ModelList.size();
    }



    public class ViewHolderLevel extends RecyclerView.ViewHolder {
        private TextView secandWord;
        private EditText letter;
        private TextView firstWord;
        private ImageView ivWord;

        public ViewHolderLevel(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }
        private void initView(View view) {
            secandWord = (TextView)view. findViewById(R.id.secand_word);
            letter = (EditText)view. findViewById(R.id.letter);
            firstWord = (TextView)view. findViewById(R.id.first_word);
            ivWord = (ImageView) view.findViewById(R.id.iv_word);
        }
    }
}
