package com.example.bagrot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class bagrot3 extends AppCompatActivity {

    TextView grades, sumOfGrades, bestSum;
    Intent si;
    String slMath, slEnglish, sgMath, sgEnglish, sgFirstMegama, sgSecondMegama, sgThirdMegama, nameFirstMegama, nameSecondMegama, nameThirdMegama, sUserName;
    int gLashon, gSafrot, gHistory, gEzrahot, gTanah;
    double sum1;
    boolean bTb1Checked, bTb2checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagrot3);
        initViews();
        si = getIntent();

        slMath = si.getStringExtra("lMath");
        slEnglish = si.getStringExtra("lEnglish");
        sgMath = si.getStringExtra("gMath");
        sgEnglish = si.getStringExtra("gEnglish");
        sgFirstMegama = si.getStringExtra("gFirstMegama");
        sgSecondMegama = si.getStringExtra("gSecondMegama");
        sgThirdMegama = si.getStringExtra("gThirdMegama");
        nameFirstMegama = si.getStringExtra("nameFirstMegama");
        nameSecondMegama = si.getStringExtra("nameSecondMegama");
        nameThirdMegama = si.getStringExtra("nameThirdMegama");
        sUserName = si.getStringExtra("userName");
        gLashon = si.getIntExtra("lashon", 0);
        gSafrot = si.getIntExtra("Safrot", 0);
        gHistory = si.getIntExtra("History", 0);
        gEzrahot = si.getIntExtra("Ezrahot", 0);
        gTanah = si.getIntExtra("Tanah", 0);
        sum1 = si.getDoubleExtra("sum1", 0);
        bTb1Checked = si.getBooleanExtra("bTb1Checked", false);
        bTb2checked = si.getBooleanExtra("bTb2checked", false);

        // Log the received values
        Log.d("bagrot3", "Received data: " +
                "lashon=" + gLashon +
                ", Safrot=" + gSafrot +
                ", History=" + gHistory +
                ", Ezrahot=" + gEzrahot +
                ", Tanah=" + gTanah +
                ", sum1=" + sum1 +
                ", userName=" + sUserName +
                ", lMath=" + slMath +
                ", lEnglish=" + slEnglish +
                ", gMath=" + sgMath +
                ", gEnglish=" + sgEnglish +
                ", gFirstMegama=" + sgFirstMegama +
                ", gSecondMegama=" + sgSecondMegama +
                ", gThirdMegama=" + sgThirdMegama +
                ", nameFirstMegama=" + nameFirstMegama +
                ", nameSecondMegama=" + nameSecondMegama +
                ", nameThirdMegama=" + nameThirdMegama +
                ", bTb1Checked=" + bTb1Checked +
                ", bTb2checked=" + bTb2checked);

        grades.setText("Math: " + slMath + "\nEnglish: " + slEnglish + "\nFirst Major: " + sgFirstMegama +
                "\nSecond Major: " + sgSecondMegama + "\nThird Major: " + sgThirdMegama);
        sumOfGrades.setText(String.valueOf(sum1));
        bestSum.setText("Best Sum Calculation Here"); // Placeholder, update with actual calculation if needed
    }

    private void initViews() {
        grades = findViewById(R.id.grades);
        sumOfGrades = findViewById(R.id.sumOfGrades);
        bestSum = findViewById(R.id.bestSum);
    }

    public void clickedPrev3(View view) {
        Intent backIntent = new Intent(this, bagrot2.class);
        backIntent.putExtra("lMath", slMath);
        backIntent.putExtra("lEnglish", slEnglish);
        backIntent.putExtra("gMath", sgMath);
        backIntent.putExtra("gEnglish", sgEnglish);
        backIntent.putExtra("gFirstMegama", sgFirstMegama);
        backIntent.putExtra("gSecondMegama", sgSecondMegama);
        backIntent.putExtra("gThirdMegama", sgThirdMegama);
        backIntent.putExtra("nameFirstMegama", nameFirstMegama);
        backIntent.putExtra("nameSecondMegama", nameSecondMegama);
        backIntent.putExtra("nameThirdMegama", nameThirdMegama);
        backIntent.putExtra("bTb1Checked", bTb1Checked);
        backIntent.putExtra("bTb2checked", bTb2checked);

        setResult(Activity.RESULT_OK, backIntent);
        finish();
    }
}
