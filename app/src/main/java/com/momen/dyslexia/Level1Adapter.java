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
import android.widget.RelativeLayout;
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
    int[] imgs;
    List<String> signs;
    List<String> letters;
    Context context;
    TextToSpeech tts;
    Boolean imgOnly = false;

    public Level1Adapter(Context context, ArrayList<Level_1Model> level_1ModelsList) {
        this.context = context;
        this.level_1ModelList = level_1ModelsList;
        signs = new ArrayList<>();
        letters = new ArrayList<>();
        for (Level_1Model ignored : level_1ModelList) {
            signs.add("");
            letters.add("");
        }
        answersArray = new String[level_1ModelList.size()];
    }

    public Level1Adapter(Context context, String[] names, int[] imgs, Boolean imgOnly) {
        this.context = context;
        this.names = names;
        this.imgs = imgs;
        this.imgOnly = imgOnly;
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
        if (!imgOnly) {
            holder.ivWord.setImageResource(level_1ModelList.get(position).image);
            holder.firstWord.setText(level_1ModelList.get(position).firstLetter);
            holder.secandWord.setText(level_1ModelList.get(position).lastLetter);
            holder.signTv.setText(signs.get(position));
            holder.letter.setText(letters.get(position));
        }
        else{
/*            holder.imgLayout.getLayoutParams().height=320;
            holder.imgLayout.getLayoutParams().width=320;*/
        }

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
        return names.length;
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
        private RelativeLayout imgLayout;

        public ViewHolderLevel(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            ivWord = (ImageView) view.findViewById(R.id.iv_word);
            imgLayout = view.findViewById(R.id.imgLayout);
            secandWord = (TextView) view.findViewById(R.id.secand_word);
            letter = (EditText) view.findViewById(R.id.letter);
            firstWord = (TextView) view.findViewById(R.id.first_word);
            signTv = view.findViewById(R.id.tv_sign);
            if (imgOnly) {
                secandWord.setVisibility(View.GONE);
                letter.setVisibility(View.GONE);
                firstWord.setVisibility(View.GONE);
                signTv.setVisibility(View.GONE);
            } else
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
