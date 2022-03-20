package com.momen.dyslexia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterViewHolder> {
    public CategoriesAdapter(OnItemClickListener mListener, ArrayList<CategoriesItem> categoriesItems) {
        this.mListener = mListener;
        this.categoriesItems = categoriesItems;
    }

    OnItemClickListener mListener;
    ArrayList<CategoriesItem>categoriesItems;



    public interface OnItemClickListener {
        void onItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;

    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false);
        return new AdapterViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.activityTitle.setText(categoriesItems.get(position).cateTitle);
    }

    @Override
    public int getItemCount() {
        return categoriesItems.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView activityTitle;

        public AdapterViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            activityTitle = itemView.findViewById(R.id.activity_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onItemClick(position);

                    }
                }
            });
        }
    }
}
