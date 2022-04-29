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
    ArrayList<String> ans;

    public ArrangeAdapter(@NotNull Context context, @NotNull ArrangeModel arrangeModel,ArrayList<String> ans) {
        this.context = context;
        this.arrangeModel = arrangeModel;
        this.ans =ans;
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
        holder.numberEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                ans.set(position,charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrangeModel.getImgs().length;
    }

    public List<String> getNumbers() {
        return arrangeModel.getNumbers();
    }
    public ArrayList<String> getNumbersAns() {
        return ans;
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
        ans.clear();
        ans.addAll(arrangeModel.getNumbers());
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
