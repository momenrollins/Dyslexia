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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ArrangeAdapter extends RecyclerView.Adapter<ArrangeAdapter.ViewHolderLevel> {

    Context context;
    ArrangeModel arrangeModel;
    Boolean resetET = true;

    public ArrangeAdapter(@NotNull Context context, @NotNull ArrangeModel arrangeModel) {
        this.context = context;
        this.arrangeModel = arrangeModel;
    }

    @NonNull
    @Override
    public ViewHolderLevel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new ViewHolderLevel(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_arrange, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLevel holder, @SuppressLint("RecyclerView") int position) {

        holder.itemIv.setImageResource(arrangeModel.getImgs()[position]);
        if (resetET) {
            holder.numberEt.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return arrangeModel.getImgs().length;
    }

    public List<String> getNumbers() {
        return arrangeModel.getNumbers();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void updateList(@NotNull ArrangeModel arrangeModel) {
        this.arrangeModel = arrangeModel;
        resetET=true;
        notifyDataSetChanged();
    }

    public class ViewHolderLevel extends RecyclerView.ViewHolder {
        private EditText numberEt;
        private ImageView itemIv;

        public ViewHolderLevel(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            itemIv = view.findViewById(R.id.item_iv);
            numberEt = view.findViewById(R.id.number_et);

        }
    }
}
