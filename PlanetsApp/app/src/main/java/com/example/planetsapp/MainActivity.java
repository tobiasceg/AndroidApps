package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create adapterview: a listview
        listView = findViewById(R.id.listView);

        //data sources : arraylist<planets>
        planetsArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Earth", "1 Moon", R.drawable.earth);
        Planet planet2 = new Planet("Jupiter" , "10 Moons", R.drawable.jupiter);
        Planet planet3 = new Planet("Neptune", "33 Moons", R.drawable.neptune);
        Planet planet4 = new Planet("Uranus", "2 Moons", R.drawable.uranus);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);

        // Adapter:
        adapter = new MyCustomAdapter(planetsArrayList,getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Planet Name: " + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}