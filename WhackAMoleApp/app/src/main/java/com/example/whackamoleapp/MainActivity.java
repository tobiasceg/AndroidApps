package com.example.whackamoleapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.whackamoleapp.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons;
    private int redButtonIndex;
    private int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Button[9];
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);

        updateRedButtonPosition();
    }

    public void buttonClicked(View view) {
        Button clickedButton = (Button) view;

        if (clickedButton.getId() == buttons[redButtonIndex].getId()) {
            score++;
            Toast.makeText(this, "Score: " + score, Toast.LENGTH_SHORT).show();
            updateRedButtonPosition();
        }
    }

    private void updateRedButtonPosition() {
        Random random = new Random();
        int newRedButtonIndex;
        do {
            newRedButtonIndex = random.nextInt(9);
        } while (newRedButtonIndex == redButtonIndex);

        // Reset the previous red button's color to blue
        buttons[redButtonIndex].setText("");

        // Set the new red button's color to red
        redButtonIndex = newRedButtonIndex;
        buttons[redButtonIndex].setText("*");
    }
}