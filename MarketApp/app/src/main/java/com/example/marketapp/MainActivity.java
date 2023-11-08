package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    RecyclerView recyclerView;

    List<Item> itemList;

    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        itemList = new ArrayList<>();

        Item item1 = new Item(R.drawable.beverage,"Beverage", "its a drink");
        Item item2 = new Item(R.drawable.bread,"Bread", "its a bread");
        Item item3 = new Item(R.drawable.fruit,"Fruit", "its a fruit");
        Item item4 = new Item(R.drawable.milk,"Milk", "its a milk");
        Item item5 = new Item(R.drawable.popcorn,"Popcorn", "its a popcorn");
        Item item6 = new Item(R.drawable.vegitables,"Vegetables", "its a vegetables");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this,
                "You chose " + itemList.get(pos).getItemName(),
                Toast.LENGTH_SHORT).show();
    }
}