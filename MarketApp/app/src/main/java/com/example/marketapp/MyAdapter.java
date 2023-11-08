package com.example.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Item> itemList;


    public static ItemClickListener clickListener;

    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;
    }

    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create new viewholders for items
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // bind data from dataset to views within the view holder
        Item item = itemList.get(position);
        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());
        holder.imageView.setImageResource(item.getItemImg());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public static class MyViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // holds references to the views within the item layout
        ImageView imageView;
        TextView title;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(this);
        }


        // linking up this default onclick with our onclick in the new interface itemclicklistener
        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v,getAdapterPosition());
            }
        }
    }
}
