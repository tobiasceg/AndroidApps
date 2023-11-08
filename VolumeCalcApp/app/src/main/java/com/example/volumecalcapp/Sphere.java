package com.example.volumecalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Sphere extends AppCompatActivity {
    TextView title;
    TextView result;
    EditText input;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        title = findViewById(R.id.textView);
        result = findViewById(R.id.result);
        input = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = input.getText().toString();

                int r = Integer.parseInt(radius);

                double volume = (4/3) * 3.1415 * r*r*r;

                result.setText("V = " + volume + "m^3");

            }
        });
    }
}