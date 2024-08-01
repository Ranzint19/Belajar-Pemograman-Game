package com.belajarpemogramangame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {

    //Deklarasi Komponen
    Intent intent;
    ImageView Wa,Youtube;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //terima Kiriman Data
        String message = getIntent().getStringExtra("message");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        //instansiasi komponen
        Wa = findViewById(R.id.wa);
        Youtube = findViewById(R.id.youtube);

        //event Clink Button Link
        Youtube.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@gilberttakarasel5255/videos"));
            startActivity(intent);
        });

        //event Click Button Dial Number
        Wa.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:082290805264"));
            startActivity(intent);

        });


    }
}