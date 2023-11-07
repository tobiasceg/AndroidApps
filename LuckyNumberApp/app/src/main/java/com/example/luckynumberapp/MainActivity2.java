package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView luckyNo;
    Button share_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        luckyNo = findViewById(R.id.resultMsg);
        share_Btn = findViewById(R.id.shareRes);

        //recv intent
        Intent i = getIntent();

        String userName = i.getStringExtra("name");

        //Generate no. number
        Random random = new Random();

        luckyNo.setText(""+random.nextInt(1000));

        share_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random.nextInt(1000));
            }
        });
    }

    public void shareData(String name,int random){
        //implicit intent
        Intent i = new Intent(Intent.ACTION_SEND); // sending out info
        i.setType("text/plain"); //of type string

        //additional info
        i.putExtra(Intent.EXTRA_SUBJECT,name + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "Lucky number is "+ random);

        startActivity(Intent.createChooser(i,"choose a platform"));

    }
}