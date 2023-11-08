package com.example.volumecalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // AdapterView : GridView
    GridView gridView;

    //ArrayList of Shapes
    ArrayList<Shape> shapeArrayList;

    // Adapter: MyCustomAdapter
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        shapeArrayList = new ArrayList<>();

        Shape shape1 = new Shape(R.drawable.earth,"Sphere");
        Shape shape2 = new Shape(R.drawable.jupiter,"Cyclinder");
        Shape shape3 = new Shape(R.drawable.mars,"Cube");
        Shape shape4 = new Shape(R.drawable.uranus,"Prism");

        shapeArrayList.add(shape1);
        shapeArrayList.add(shape2);
        shapeArrayList.add(shape3);
        shapeArrayList.add(shape4);

        adapter = new MyCustomAdapter(shapeArrayList,getApplicationContext());

        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent i = new Intent(getApplicationContext(), Sphere.class);
                startActivity(i);
            }
        });
    }
}