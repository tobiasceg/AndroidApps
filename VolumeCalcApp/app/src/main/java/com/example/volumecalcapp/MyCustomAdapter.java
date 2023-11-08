package com.example.volumecalcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {
    private ArrayList<Shape> shapeArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<Shape> shapeArrayList, Context context) {
        super(context, R.layout.grid_item_layout, shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }

    // ViewHolder: reference to each object - so wont be called so often
    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImg;
    }

    // getview: used to create and return a view for a specific item in grid
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // get shape object for current position
        Shape shape = getItem(position);

        // inflating layout
        MyViewHolder myViewHolder;

        if (convertView == null){

            // no view went off screen --> new view
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );

            // finding the views
            myViewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageView);
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(myViewHolder);
        }
        else{
            // resuse the view that went off screen
            myViewHolder = (MyViewHolder) convertView.getTag();


        }

        //getting data from model class
        myViewHolder.shapeName.setText(shape.getShapeName());
        myViewHolder.shapeImg.setImageResource(shape.getShapeImg());

        return convertView;
    }
}
