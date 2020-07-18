package com.murari.charubeautyapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.murari.charubeautyapp.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewholder> {
    Context context;
    List<Integer>colorList;
    ColorAdapterListener listener;

    public ColorAdapter(Context context, ColorAdapterListener listener) {
        this.context = context;
        this.colorList = genColorList();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ColorViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.color_item,parent,false);
        return new ColorViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewholder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ColorViewholder extends RecyclerView.ViewHolder{

        public CardView color_section;

        public ColorViewholder(@NonNull View itemView) {
            super(itemView);
            color_section= itemView.findViewById(R.id.color_section);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }
    private List<Integer> genColorList() {
        List<Integer>   colorList=new ArrayList<>();

        colorList.add(Color.parseColor("#b99c96"));
        colorList.add(Color.parseColor("#d4af37"));
        colorList.add(Color.parseColor("#000000"));
        colorList.add(Color.parseColor("#e1c4ff"));
        colorList.add(Color.parseColor("#bbffff"));
        colorList.add(Color.parseColor("#fdfd96"));
        colorList.add(Color.parseColor("#f4b8da"));
        colorList.add(Color.parseColor("#231e1e"));
        colorList.add(Color.parseColor("#ad1d2d"));
        colorList.add(Color.parseColor("#811622"));
        colorList.add(Color.parseColor("#2997b7"));
        colorList.add(Color.parseColor("#6dd0e5"));
        colorList.add(Color.parseColor("#40b7ff"));
        colorList.add(Color.parseColor("#ffb6c1"));
        colorList.add(Color.parseColor("#d51400"));
        colorList.add(Color.parseColor("#f2b8ad"));
        colorList.add(Color.parseColor("#3e0a77"));
        colorList.add(Color.parseColor("#c1f588"));
        colorList.add(Color.parseColor("#b2d8d8"));
        colorList.add(Color.parseColor("#f2b8ad"));
        colorList.add(Color.parseColor("#e96166"));
        colorList.add(Color.parseColor("#d23c3d"));
        return colorList;
    }

    public interface ColorAdapterListener{
        void onColorSelected(int color);
    }
}
