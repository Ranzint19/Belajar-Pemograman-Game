package com.belajarpemogramangame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class KonfersiUang extends AppCompatActivity {

    //Inisialisasi
    private EditText inputAmount;
    private TextView resultTextView;
    private static final double EXCHANGE_RATE = 16230;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfersi_uang);

        inputAmount = findViewById(R.id.inputAmount);
        resultTextView = findViewById(R.id.resultTextView);
        Button convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }
    private void convertCurrency() {
        String inputStr = inputAmount.getText().toString();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return;
        }

        double idrAmount = Double.parseDouble(inputStr);
        double usdAmount = idrAmount / EXCHANGE_RATE;

        resultTextView.setText(String.format("Result: $%.2f USD", usdAmount));
    }
}
