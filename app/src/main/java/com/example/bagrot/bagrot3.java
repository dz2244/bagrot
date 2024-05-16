package com.example.bagrot;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
/*
    lMath = Integer.valueOf(slMath);
    lEnglish = Integer.valueOf(slEnglish);
    gMath = Integer.valueOf(sgMath);
    gEnglish = Integer.valueOf(sgEnglish);
    gFirstMegama = Integer.valueOf(sgFirstMegama);
    gSecondMegama = Integer.valueOf(sgSecondMegama);
    gThirdMegama = Integer.valueOf(sgThirdMegama);

            if ((lMath < 6) && (lMath > 2) || (lEnglish < 6) && (lEnglish > 2)  ||  !(gMath > 100) || !(gEnglish > 100) || !(gFirstMegama > 100) || !(gSecondMegama > 100) || !(gThirdMegama > 100))
    {
        gFirstMegama += 20;
        if(lMath == 4) gMath += 15;
        else if (lMath == 5) gMath += 30;

        if(lEnglish == 4) gEnglish += 15;
        else if (lEnglish == 5) gEnglish += 30;

        if(tbFirst.isChecked()) gSecondMegama += 20 ;
        if(tbSecond.isChecked()) gThirdMegama += 20 ;
        */
    public void clickedPrev3(View view) {
        Intent pi = new Intent(this, bagrot2.class);
        startActivity(pi);
    }
}
