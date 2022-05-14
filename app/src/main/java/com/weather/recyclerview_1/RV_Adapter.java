package com.weather.recyclerview_1;

import android.content.Context;
import android.util.Log;
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

    private static final String TAG = RV_Adapter.class.getSimpleName();
    // this is our Data which need to be shown
    private ArrayList<String> nums ;

    //this the textView will display the data (Single item)
    private TextView textView;


    // Interface for the clickListener in recycler View
    public interface ClickListener{
        void onItemClick(int index);

    }
    private ClickListener listener;



    class RV_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public RV_ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textview);
            itemView.setOnClickListener(this);
            Log.d(TAG,"ViewHolder holding the View :- "+itemView+" and click listener is set");
        }

        @Override
        public void onClick(View v) {
            int index = getAdapterPosition();
            listener.onItemClick(index);
        }
    }

    public RV_Adapter(ArrayList<String> list, ClickListener clickListener) {
        this.nums = list;
        this.listener = clickListener;
    }


    @NonNull
    @Override
    public RV_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        Log.d(TAG,"onCreateViewHolder on parent : "+parent +
                "\n"+" on view Type : "+viewType);
        return new RV_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RV_ViewHolder holder, int position) {
        textView.setText(nums.get(position));
        Log.d(TAG,"Setting Text on position : "+position + "\n" + " on Holder "+holder);
    }

    @Override
    public int getItemCount() {
        return nums.size();
    }

    public void setData(ArrayList<String> num){
        nums = num;
    }







}
