package com.weather.recyclerview_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * RV_Adapter is used to cache the data in Recycler View
 * It must be extended by RecyclerView.Adapter<RV_ViewHolder> in this case
 */
public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.RV_ViewHolder>{

    private ArrayList<String> nums = new ArrayList<>();
    private TextView textView;
    class RV_ViewHolder extends RecyclerView.ViewHolder {
        public RV_ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textview);
        }
    }

    @NonNull
    @Override
    public RV_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new RV_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RV_ViewHolder holder, int position) {
        textView.setText(nums.get(position));
    }

    @Override
    public int getItemCount() {
        return nums.size();
    }

    public void setData(ArrayList<String> num){
        nums = num;
    }
    public RV_Adapter(ArrayList<String> list){
        this.nums = list;
    }






}
