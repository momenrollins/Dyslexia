package com.momen.dyslexia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LettersImagesAdapter extends RecyclerView.Adapter<LettersImagesAdapter.ViewHolderClass> {
    private ImageView ivLetter;
    private ImageView ivLeft;
    private ImageView ivRight;



    int[] images;
    int[] right_images;
    int[] left_images;

    public LettersImagesAdapter(int[] images, int[] right_images, int[] left_images) {
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
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {

        ivLetter.setImageResource(images[position]);
        ivRight.setImageResource(right_images[position]);
        ivLeft.setImageResource(left_images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder {
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            ivLetter = (ImageView) view.findViewById(R.id.iv_letter);
            ivLeft = (ImageView) view.findViewById(R.id.iv_left);
            ivRight = (ImageView) view.findViewById(R.id.iv_right);
        }
    }
}
