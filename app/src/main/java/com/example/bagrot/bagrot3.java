package com.example.bagrot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bagrot3 extends AppCompatActivity {
    TextView grades, sumOfGrades,bestSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagrot3);
        grades = findViewById(R.id.grades);
        sumOfGrades = findViewById(R.id.sumOfGrades);
        bestSum = findViewById(R.id.bestSum);

    }

    public void clickedPrev3(View view) {
    }
}