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
    String slMath, slEnglish, sgMath, sgEnglish, sgFirstMegama, sgSecondMegama, sgThirdMegama, nameFirstMegama, nameSecondMegama, nameThirdMegama;
    boolean bTb1Checked, bTb2checked;
    int gLashon, gSafrot, gHistory, gEzrahot, gTanah, lMath, gMath, lEnglish, gEnglish, gFirstMegama, gSecondMegama, gThirdMegama ,gMathWithBonus,gEnglishWithBonus,gFirstMegamaWithBonus,gSecondMegamaWithBonus,gThirdMegamaWithBonus;
    double sum1;
    String sUserName;

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
        bTb1Checked = si.getBooleanExtra("bTb1Checked", false);
        bTb2checked = si.getBooleanExtra("bTb2checked", false);
        gLashon = si.getIntExtra("lashon", 0);
        gSafrot = si.getIntExtra("Safrot", 0);
        gHistory = si.getIntExtra("History", 0);
        gEzrahot = si.getIntExtra("Ezrahot", 0);
        gTanah = si.getIntExtra("Tanah", 0);
        sum1 = si.getDoubleExtra("sum1", 0);
        sUserName = si.getStringExtra("userName");

        displayGrades();
    }

    private void initViews() {
        grades = findViewById(R.id.grades);
        sumOfGrades = findViewById(R.id.sumOfGrades);
        bestSum = findViewById(R.id.bestSum);
    }

    private int calculateGradeWithBonus(int grade, int level, boolean isMathOrEnglish) {
        if (isMathOrEnglish) {
            if (level == 4) {
                return grade + 15;
            } else if (level == 5) {
                return grade + 30;
            }
        } else {
            if (level == 5) {
                return grade + 20;
            }
        }
        return grade;
    }

    private void displayGrades() {
        StringBuilder gradesBuilder = new StringBuilder();

        lMath = Integer.valueOf(slMath);
        gMath = Integer.valueOf(sgMath);
        lEnglish = Integer.valueOf(slEnglish);
        gEnglish = Integer.valueOf(sgEnglish);
        gFirstMegama = Integer.valueOf(sgFirstMegama);
        gSecondMegama = Integer.valueOf(sgSecondMegama);
        gThirdMegama = Integer.valueOf(sgThirdMegama);

        gMathWithBonus = calculateGradeWithBonus(gMath, lMath, true);
        gEnglishWithBonus = calculateGradeWithBonus(gEnglish, lEnglish, true);
        gFirstMegamaWithBonus = gFirstMegama + 20;
        gSecondMegamaWithBonus = bTb1Checked ? gSecondMegama + 20 : gSecondMegama;
        gThirdMegamaWithBonus = bTb2checked ? gThirdMegama + 20 : gThirdMegama;

        gradesBuilder.append("lashon:").append("\t").append("Level ").append("2").append("\tGrade: ").append(gLashon).append("\tbonus: ").append(gLashon).append("\n");
        gradesBuilder.append("safrot:").append("\t").append("Level ").append("2").append("\tGrade: ").append(gSafrot).append("\tbonus: ").append(gSafrot).append("\n");
        gradesBuilder.append("history:").append("\t").append("Level ").append("2").append("\tGrade: ").append(gHistory).append("\tbonus: ").append(gHistory).append("\n");
        gradesBuilder.append("ezrahot:").append("\t").append("Level ").append("2").append("\tGrade: ").append(gEzrahot).append("\tbonus: ").append(gEzrahot).append("\n");
        gradesBuilder.append("tanah:").append("\t").append("Level ").append("2").append("\tGrade: ").append(gTanah).append("\tbonus: ").append(gTanah).append("\n");

        gradesBuilder.append("math:").append("\t").append("Level ").append(lMath).append("\tGrade: ").append(gMath).append("\tbonus: ").append(gMathWithBonus).append("\n");
        gradesBuilder.append("english:").append("\t").append("Level ").append(lEnglish).append("\tGrade: ").append(gEnglish).append("\tbonus: ").append(gEnglishWithBonus).append("\n");

        gradesBuilder.append(nameFirstMegama).append(":\t").append("Level ").append("5").append("\tGrade: ").append(gFirstMegama).append("\tbonus: ").append(gFirstMegamaWithBonus).append("\n");
        gradesBuilder.append(nameSecondMegama).append(":\t").append("Level ").append("5").append("\tGrade: ").append(gSecondMegama).append("\tbonus: ").append(gSecondMegamaWithBonus).append("\n");
        gradesBuilder.append(nameThirdMegama).append(":\t").append("Level ").append("5").append("\tGrade: ").append(gThirdMegama).append("\tbonus: ").append(gThirdMegamaWithBonus).append("\n");

        grades.setText(gradesBuilder.toString());
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
