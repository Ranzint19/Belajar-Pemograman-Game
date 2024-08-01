package com.belajarpemogramangame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ApkLayer extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private BottomNavigationView btn_nav_view;
    private HomeFragment home_frag = new HomeFragment();
    private InfoFragment info_frag = new InfoFragment();
    Intent intent;
    Button btnKalku,btnBmi,btnSuhu, btnUang;
    TextView nama;
    String st;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apk_layer);
        getSupportActionBar().hide();



        //Inisialisasi Komponen
        btnBmi = findViewById(R.id.bmi);
        btnKalku = findViewById(R.id.kalkulator);
        btnSuhu = findViewById(R.id.suhu);
        btnUang = findViewById(R.id.uang);
        nama = findViewById(R.id.name);
        btn_nav_view = findViewById(R.id.navBar);
        btn_nav_view.setOnItemSelectedListener(this);
        //btn_nav_view.setSelectedItemId(R.id.home);


        //datap Nama
        st = getIntent().getExtras().getString("nama");
        nama.setText("HAI! "+ st);

        //Event Button
        btnKalku.setOnClickListener(view -> {
            intent = new Intent(ApkLayer.this, RelativeLayoutActivity.class);
            startActivity(intent);
        });
        btnBmi.setOnClickListener(view -> {
            intent = new Intent(ApkLayer.this,LinierLayoutActivity.class);
            startActivity(intent);
        });
        btnSuhu.setOnClickListener(view -> {
            intent = new Intent(ApkLayer.this, KonverSuhu.class);
            startActivity(intent);
        });
        btnUang.setOnClickListener(view -> {
            intent = new Intent(ApkLayer.this, KonfersiUang.class);
            startActivity(intent);
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLy,home_frag).commit();
                return true;
            case R.id.info:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLy,info_frag).commit();
                return true;
        }

        return false;
    }
}