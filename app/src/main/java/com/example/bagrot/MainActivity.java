package com.example.bagrot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void clickedNext1(View view) {
        Intent gi = new Intent(this, bagrot2.class);
        startActivity(gi);
    }
}