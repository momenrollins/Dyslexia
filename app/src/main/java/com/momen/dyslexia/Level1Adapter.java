package com.momen.dyslexia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Level1Adapter extends RecyclerView.Adapter<Level1Adapter.ViewHolderLevel> {

    ArrayList<Level_1Model> level_1ModelList;
    String[] answersArray;
    String[] names;
    List<String> signs;
    List<String> letters;
    Context context;
    TextToSpeech   tts;
    public Level1Adapter(Context context, ArrayList<Level_1Model> level_1ModelsList) {
        this.context=context;
        this.level_1ModelList = level_1ModelsList;
        signs = new ArrayList<>();
        letters = new ArrayList<>();
        for (Level_1Model ignored : level_1ModelList) {
            signs.add("");
            letters.add("");
        }
        answersArray = new String[level_1ModelList.size()];
    }

    @NonNull
    @Override
    public ViewHolderLevel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new ViewHolderLevel(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.level_1_item, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLevel holder, @SuppressLint("RecyclerView") int position) {

        holder.ivWord.setImageResource(level_1ModelList.get(position).image);
        holder.firstWord.setText(level_1ModelList.get(position).firstLetter);
        holder.secandWord.setText(level_1ModelList.get(position).lastLetter);
        holder.signTv.setText(signs.get(position));
        holder.letter.setText(letters.get(position));
           tts = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
           tts.setLanguage(Locale.forLanguageTag("ar"));

            }
        });
        holder.ivWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                tts.setLanguage(Locale.forLanguageTag("ar"));
                tts.speak(names[position], TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return level_1ModelList.size();
    }

    public List<String> getLetters() {
        return letters;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolderLevel extends RecyclerView.ViewHolder {
        private TextView secandWord;
        private EditText letter;
        private TextView firstWord;
        private ImageView ivWord;
        private TextView signTv;

        public ViewHolderLevel(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            secandWord = (TextView) view.findViewById(R.id.secand_word);
            letter = (EditText) view.findViewById(R.id.letter);
            firstWord = (TextView) view.findViewById(R.id.first_word);
            ivWord = (ImageView) view.findViewById(R.id.iv_word);
            signTv = view.findViewById(R.id.tv_sign);
            letter.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    letters.set(getAdapterPosition(), charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }
}
