package com.example.bagrot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etLashon,etSafrot,etHistory,etEzrahot,etTanah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLashon = findViewById(R.id.etLashon);
        etSafrot = findViewById(R.id.etSafrot);
        etHistory = findViewById(R.id.etHistory);
        etEzrahot = findViewById(R.id.etEzrahot);
        etTanah = findViewById(R.id.etTanah);

    }
}