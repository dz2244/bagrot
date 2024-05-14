package com.example.bagrot;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;

public class bagrot2 extends AppCompatActivity {
    EditText etUnitsMath, etUnitsEng, etGradeMath, etGradeEng, etChoice1 , etChoice2 , etChoice3 ,etChoice1Grade ,etChoice2Grade ,etChoice3Grade ;
    Button btnNext , btnPrev;
    Intent si = new Intent();

    ToggleButton tbFirst , tbSecond;
    int gLashon , gSafrot , gHistory , gEzrahot , gTanah;
    double sum1;
    String sUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagrot2);
        initViews();
        si = getIntent();

    }
    private void initViews() {
        etUnitsMath = findViewById(R.id.etUnitsMath);
        etUnitsEng = findViewById(R.id.etUnitsEng);

        etGradeMath = findViewById(R.id.etGradeMath);
        etGradeEng = findViewById(R.id.etGradeEng);

        etChoice1 = findViewById(R.id.etChoice1);
        etChoice2 = findViewById(R.id.etChoice2);
        etChoice3 = findViewById(R.id.etChoice3);

        tbSecond = findViewById(R.id.tbSecond);
        tbFirst = findViewById(R.id.tbFirst);

        etChoice1Grade = findViewById(R.id.etChoice1Grade);
        etChoice2Grade = findViewById(R.id.etChoice2Grade);
        etChoice3Grade = findViewById(R.id.etChoice3Grade);

        btnNext = findViewById(R.id.btnNext2);
        btnPrev = findViewById(R.id.btnPrev2);
    }

    public void clickedNext2(View view) {
        Intent ai = new Intent(this, bagrot3.class);
        startActivity(ai);

    }

    public void clickedPrev2(View view) {
        si.putExtra("lashon",gLashon);
        si.putExtra("Safrot",gSafrot);
        si.putExtra("History",gHistory);
        si.putExtra("Ezrahot",gEzrahot);
        si.putExtra("Tanah",gTanah);
        si.putExtra("sum1",sum1);
        si.putExtra("userName",sUserName);
        setResult(Activity.RESULT_OK,si);
        finish();
    }
}