package com.example.bagrot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class bagrot2 extends AppCompatActivity {
    EditText etUnitsMath, etUnitsEng, etGradeMath, etGradeEng, etChoice1 , etChoice2 , etChoice3 , etChoice1Units , etChoice2Units , etChoice3Units ,etChoice1Grade ,etChoice2Grade ,etChoice3Grade ;
    Button btnNext , btnPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagrot2);
        etUnitsMath = findViewById(R.id.etUnitsMath);
        etUnitsEng = findViewById(R.id.etUnitsEng);

        etGradeMath = findViewById(R.id.etGradeMath);
        etGradeEng = findViewById(R.id.etGradeEng);

        etChoice1 = findViewById(R.id.etChoice1);
        etChoice2 = findViewById(R.id.etChoice2);
        etChoice3 = findViewById(R.id.etChoice3);

        etChoice1Units= findViewById(R.id.etChoice1Units);
        etChoice2Units = findViewById(R.id.etChoice1Units);
        etChoice3Units = findViewById(R.id.etChoice3Units);

        etChoice1Grade = findViewById(R.id.etChoice1Grade);
        etChoice2Grade = findViewById(R.id.etChoice2Grade);
        etChoice3Grade = findViewById(R.id.etChoice3Grade);

        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
    }
}