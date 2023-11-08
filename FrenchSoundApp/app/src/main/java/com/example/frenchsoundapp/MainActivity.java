package com.example.frenchsoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView welcomeMsg;

    Button redBtn;
    Button blueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMsg = findViewById(R.id.textView);
        redBtn = findViewById(R.id.red);
        blueBtn = findViewById(R.id.blue);

        //refers to View.onclicklistener interface redirecting to the onclick at the bottom
        redBtn.setOnClickListener(this);
        blueBtn.setOnClickListener(this);

//        ONLY FOR SINGLE BUTTON
//        redBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(
//                        getApplicationContext(),
//                        R.raw.red
//                );
//
//                mediaPlayer.start();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        int clickedBtnId = view.getId();

        if (clickedBtnId == R.id.red){
            playSounds(R.raw.red);
        }
        else if (clickedBtnId == R.id.blue){
            playSounds(R.raw.black);
        }
    }

    public void playSounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }
}