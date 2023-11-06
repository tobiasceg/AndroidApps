package com.example.kilostopoundsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputKilo;
    Button converterButton;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputKilo = findViewById(R.id.kiloinput);
        converterButton = findViewById(R.id.convert);
        results = findViewById(R.id.outputDisplay);

        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = inputKilo.getText().toString();

                double kilos = Double.parseDouble(res);
                double pounds = kiloToPound(kilos);

                results.setText(""+pounds);
            }
        });
    }

    public double kiloToPound(double kilo){
        return kilo*2.205;
    }
}