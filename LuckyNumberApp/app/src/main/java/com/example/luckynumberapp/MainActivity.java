package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView welcomeMsg;
    EditText nameInput;
    Button nextBtn;
    ImageView diceSprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMsg = findViewById(R.id.welcomeMsg);
        nameInput = findViewById(R.id.nameInput);
        nextBtn = findViewById(R.id.myBtn);
        diceSprite = findViewById(R.id.diceSprite);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = nameInput.getText().toString();

                //Explicit Intent --> to another screen
                Intent i = new Intent(
                        getApplicationContext(),
                        MainActivity2.class
                );

                // Passing the name to other screen (other activity)
                i.putExtra("name",userName);

                startActivity(i);
            }
        });

    }
}