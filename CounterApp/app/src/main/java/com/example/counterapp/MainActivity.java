package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView counter_text;
    Button myButton;
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter_text = findViewById(R.id.textView);
        myButton = findViewById(R.id.myBtn);

        //functionalities
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter_text.setText(""+increaseCount());
            }
        });
    }

    public int increaseCount(){
        return ++counter;
    }
}