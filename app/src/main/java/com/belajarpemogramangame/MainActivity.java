package com.belajarpemogramangame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Deklarasi Komponen
    Intent intent;
    Button btnTentang,btnStart;
    TextView time,date;
    private int jam,menit, tahun,bulan,tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //Inisialisasi Komponen
        btnTentang = findViewById(R.id.tentang);
        btnStart = findViewById(R.id.mulai);
        time = findViewById(R.id.Time);
        date = findViewById(R.id.Date);

        //event click btnIntens
        btnTentang.setOnClickListener(view -> {
            //explisit intent
            intent = new Intent(MainActivity.this, IntentActivity.class);
            intent.putExtra("message", "Tentang Developer");
            startActivity(intent);
        });


        //event click btnconsLayout
        btnStart.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, ConstrainActivity.class);
            intent.putExtra("message", "Silakan Isi Data Terlebih dahulu");
            startActivity(intent);
        });

        //Set Jam dan waktu
        time.setOnClickListener(view -> {
            TimePickerDialog dialog;
            dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    jam = i;
                    menit = i1;

                    if(jam<=12){
                        time.setText(String.format(Locale.getDefault(),"%d:%d ", jam,menit));
                    }else {
                        time.setText(String.format(Locale.getDefault(),"%d:%d ", jam,menit));
                    }

                }
            }, jam, menit, true);
            dialog.show();
        });

        date.setOnClickListener(view -> {
            DatePickerDialog dialog;
            dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int mount, int dayofMonth) {
                    tahun = year;
                    bulan = mount;
                    tanggal = dayofMonth;

                    date.setText(tanggal +"-"+ bulan + "-" + tahun);
                }
            },tahun,bulan,tanggal);
            dialog.show();
        });


    }




}

