package com.momen.dyslexia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

public class LettersImagesAdapter extends RecyclerView.Adapter<LettersImagesAdapter.ViewHolderClass> {


    String[] names;
    int[] images;
    int[] right_images;
    int[] left_images;
    TextToSpeech tts;
    Context context;
    public LettersImagesAdapter(int[] images, int[] right_images, int[] left_images, String[] names, Context context) {
        this.context = context;
        this.names = names;
        this.images = images;
        this.right_images = right_images;
        this.left_images = left_images;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent, false);

        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, @SuppressLint("RecyclerView") int position) {

        holder.ivLetter.setImageResource(images[position]);
        holder.ivRight.setImageResource(right_images[position]);
        holder.ivLeft.setImageResource(left_images[position]);

        tts = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.forLanguageTag("ar"));
                tts.setSpeechRate(0.6f);
            }
        });
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(names[position], TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder {
        private ImageView ivLetter;
        private ImageView ivLeft;
        private ImageView ivRight;
        private CardView card;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            card=view.findViewById(R.id.card);
            ivLetter = (ImageView) view.findViewById(R.id.iv_letter);
            ivLeft = (ImageView) view.findViewById(R.id.iv_left);
            ivRight = (ImageView) view.findViewById(R.id.iv_right);
        }
    }
}
