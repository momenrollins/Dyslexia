package com.momen.dyslexia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {
    private List<OnBoardingItem> onBoardingItems;

    public OnboardingAdapter(List<OnBoardingItem> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.on_boarding_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        if (position != 0) {
            holder.linearLayout1.setVisibility(View.GONE);
            holder.linearLayout2.setVisibility(View.VISIBLE);
            holder.setOnBoardingData(onBoardingItems.get(position), position);
        }


    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;
        ImageView vector;
        LinearLayout linearLayout1,linearLayout2;

        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDesc);
            vector = itemView.findViewById(R.id.vector);
            linearLayout1 = itemView.findViewById(R.id.linear_1);
            linearLayout2 = itemView.findViewById(R.id.linear_2);
        }

        void setOnBoardingData(OnBoardingItem onBoardingItem, int position) {

            textTitle.setText(onBoardingItem.getTitle());
            textDescription.setText(onBoardingItem.getDescription());
            if (position == 1) {
                vector.setVisibility(View.VISIBLE);
                textDescription.setVisibility(View.GONE);
            } else {
                vector.setVisibility(View.GONE);
                textDescription.setVisibility(View.VISIBLE);
            }
        }
    }
}