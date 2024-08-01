package com.belajarpemogramangame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ConstrainActivity extends AppCompatActivity {

    ConstraintLayout Tes;
    Intent intent;
    Button pindah;
    EditText nama;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constrain);
        getSupportActionBar().hide();

        //inisialisasi Komponen
        Tes = findViewById(R.id.tes);
        nama = findViewById(R.id.name);
        pindah = findViewById(R.id.btnPindah);

        //Event Btn Pindah
        pindah.setOnClickListener(view -> {

            String Cname = nama.getText().toString();
            if(Cname.isEmpty()){
                Toast.makeText(this, "Tolong Mengisi Nama Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                return;
            }else {
                snackbar();
            }
        });

        //terima Kiriman Data
        String message = getIntent().getStringExtra("message");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void snackbar(){

        Snackbar snackbar = Snackbar.make(Tes,"Berhasil Input Data !!", Snackbar.LENGTH_INDEFINITE)
                .setAction("Open", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(ConstrainActivity.this, ApkLayer.class);
                        text = nama.getText().toString();
                        intent.putExtra("nama",text);
                        startActivity(intent);
                    }
                })
                .setActionTextColor(Color.CYAN);
        snackbar.show();
    }

}