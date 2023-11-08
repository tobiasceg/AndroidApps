package com.example.planetsapp;

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

// bridge of arraylist of data to adapterview
public class MyCustomAdapter extends ArrayAdapter<Planet> {
    // custom objects --> arrayadapter<planet>

    private ArrayList<Planet> planetsArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }

    private static class MyViewHolder {
        //holds references to the views ( so that cosntant lookup is not needed)
        TextView planetName;
        TextView textView;
        ImageView imageView;
    }

    // Called to create and return a view for specific item in list
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the planet object for the current position
        Planet planet = getItem(position);

        // inflate layout
        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null) { // create new view
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            //Finding views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planetName);
            myViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            myViewHolder.textView = (TextView) convertView.findViewById(R.id.textView);


            result = convertView;

            // to be retrieved if recycled
            convertView.setTag(myViewHolder);

        }
        else{
            //view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;

        }

        //getting data from model class (planet)
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.textView.setText(planet.getMoonCount());
        myViewHolder.imageView.setImageResource(planet.getPlanetImage());

        return result;

    }
}
