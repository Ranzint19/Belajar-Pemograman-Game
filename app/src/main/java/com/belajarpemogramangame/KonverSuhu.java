package com.belajarpemogramangame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class KonverSuhu extends AppCompatActivity {

    private EditText inputTemperature;
    private Spinner spinnerFrom, spinnerTo;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konver_suhu);
        getSupportActionBar().hide();

        inputTemperature = findViewById(R.id.inputTemperature);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        resultTextView = findViewById(R.id.resultTextView);
        Button convertButton = findViewById(R.id.convertButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperature_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String inputStr = inputTemperature.getText().toString();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputTemp = Double.parseDouble(inputStr);
        String fromUnit = spinnerFrom.getSelectedItem().toString();
        String toUnit = spinnerTo.getSelectedItem().toString();
        double resultTemp;

        switch (fromUnit) {
            case "Celsius":
                resultTemp = convertFromCelsius(inputTemp, toUnit);
                break;
            case "Fahrenheit":
                resultTemp = convertFromFahrenheit(inputTemp, toUnit);
                break;
            case "Kelvin":
                resultTemp = convertFromKelvin(inputTemp, toUnit);
                break;
            default:
                resultTemp = inputTemp;
                break;
        }

        resultTextView.setText(String.format("Result: %.2f %s", resultTemp, toUnit));
    }

    private double convertFromCelsius(double temp, String toUnit) {
        switch (toUnit) {
            case "Fahrenheit":
                return (temp * 9/5) + 32;
            case "Kelvin":
                return temp + 273.15;
            default:
                return temp;
        }
    }

    private double convertFromFahrenheit(double temp, String toUnit) {
        switch (toUnit) {
            case "Celsius":
                return (temp - 32) * 5/9;
            case "Kelvin":
                return (temp - 32) * 5/9 + 273.15;
            default:
                return temp;
        }
    }

    private double convertFromKelvin(double temp, String toUnit) {
        switch (toUnit) {
            case "Celsius":
                return temp - 273.15;
            case "Fahrenheit":
                return (temp - 273.15) * 9/5 + 32;
            default:
                return temp;
        }
    }
}
