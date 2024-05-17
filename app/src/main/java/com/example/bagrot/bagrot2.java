package com.example.bagrot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class bagrot2 extends AppCompatActivity {
    EditText etUnitsMath, etUnitsEng, etGradeMath, etGradeEng, etChoice1, etChoice2, etChoice3, etChoice1Grade, etChoice2Grade, etChoice3Grade;
    Button btnNext, btnPrev;
    Intent si;
    boolean bTb1Checked, bTb2checked;

    ToggleButton tbFirst, tbSecond;
    int gLashon, gSafrot, gHistory, gEzrahot, gTanah, gMath, gEnglish, gFirstMegama, gSecondMegama, gThirdMegama;
    double sum1;
    String sUserName, nameFirstMegama, nameSecondMegama, nameThirdMegama, slMath, slEnglish, sgMath, sgEnglish, sgFirstMegama, sgSecondMegama, sgThirdMegama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagrot2);
        initViews();
        si = getIntent();

        etChoice3.setVisibility(View.INVISIBLE);
        etChoice3Grade.setVisibility(View.INVISIBLE);

        bTb1Checked = si.getBooleanExtra("bTb1Checked", false);
        bTb2checked = si.getBooleanExtra("bTb2checked", false);

        if (bTb2checked) {
            etChoice3.setVisibility(View.VISIBLE);
            etChoice3Grade.setVisibility(View.VISIBLE);
        }

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
        gLashon = si.getIntExtra("lashon", 0);
        gSafrot = si.getIntExtra("Safrot", 0);
        gHistory = si.getIntExtra("History", 0);
        gEzrahot = si.getIntExtra("Ezrahot", 0);
        gTanah = si.getIntExtra("Tanah", 0);
        sum1 = si.getDoubleExtra("sum1", 0);
        sUserName = si.getStringExtra("userName");

        etUnitsMath.setText(slMath);
        etUnitsEng.setText(slEnglish);
        etGradeMath.setText(sgMath);
        etGradeEng.setText(sgEnglish);
        etChoice1Grade.setText(sgFirstMegama);
        etChoice2Grade.setText(sgSecondMegama);
        etChoice3Grade.setText(sgThirdMegama);
        etChoice1.setText(nameFirstMegama);
        etChoice2.setText(nameSecondMegama);
        etChoice3.setText(nameThirdMegama);

        if (bTb1Checked)
            tbFirst.setChecked(true);
        if (bTb2checked)
            tbSecond.setChecked(true);
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
        if (validateInputs()) {
            Intent ai = new Intent(this, bagrot3.class);
            ai.putExtra("lashon", gLashon);
            ai.putExtra("Safrot", gSafrot);
            ai.putExtra("History", gHistory);
            ai.putExtra("Ezrahot", gEzrahot);
            ai.putExtra("Tanah", gTanah);
            ai.putExtra("sum1", sum1);
            ai.putExtra("userName", sUserName);
            ai.putExtra("lMath", slMath);
            ai.putExtra("lEnglish", slEnglish);
            ai.putExtra("gMath", sgMath);
            ai.putExtra("gEnglish", sgEnglish);
            ai.putExtra("gFirstMegama", sgFirstMegama);
            if (bTb1Checked)
                ai.putExtra("gSecondMegama", sgSecondMegama);
            if (bTb2checked)
                ai.putExtra("gThirdMegama", sgThirdMegama);
            ai.putExtra("nameFirstMegama", nameFirstMegama);
            ai.putExtra("nameSecondMegama", nameSecondMegama);
            ai.putExtra("nameThirdMegama", nameThirdMegama);
            ai.putExtra("bTb1Checked", bTb1Checked);
            ai.putExtra("bTb2checked", bTb2checked);

            // Log the data being sent
            Log.d("bagrot2", "Sending data: " +
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

            startActivity(ai);
        }
    }

    public void clickedPrev2(View view) {
        slMath = etUnitsMath.getText().toString();
        slEnglish = etUnitsEng.getText().toString();
        sgMath = etGradeMath.getText().toString();
        sgEnglish = etGradeEng.getText().toString();
        sgFirstMegama = etChoice1Grade.getText().toString();
        sgSecondMegama = etChoice2Grade.getText().toString();
        sgThirdMegama = etChoice3Grade.getText().toString();
        nameFirstMegama = etChoice1.getText().toString();
        nameSecondMegama = etChoice2.getText().toString();
        nameThirdMegama = etChoice3.getText().toString();

        si.putExtra("lMath", slMath);
        si.putExtra("lEnglish", slEnglish);
        si.putExtra("gMath", sgMath);
        si.putExtra("gEnglish", sgEnglish);
        si.putExtra("gFirstMegama", sgFirstMegama);
        if (tbFirst.isChecked())
            si.putExtra("gSecondMegama", sgSecondMegama);
        if (tbSecond.isChecked())
            si.putExtra("gThirdMegama", sgThirdMegama);
        si.putExtra("nameFirstMegama", nameFirstMegama);
        si.putExtra("nameSecondMegama", nameSecondMegama);
        si.putExtra("nameThirdMegama", nameThirdMegama);
        si.putExtra("bTb1Checked", bTb1Checked);
        si.putExtra("bTb2checked", bTb2checked);

        setResult(Activity.RESULT_OK, si);
        finish();
    }

    public void clickedTbSecond(View view) {
        if (tbSecond.isChecked()) {
            bTb2checked = true;
            bTb1Checked = true;
        } else {
            bTb2checked = false;
        }
        if (!tbSecond.isChecked()) {
            etChoice3.setVisibility(View.INVISIBLE);
            etChoice3Grade.setVisibility(View.INVISIBLE);
        } else if (tbSecond.isChecked()) {
            etChoice3.setVisibility(View.VISIBLE);
            etChoice3Grade.setVisibility(View.VISIBLE);
        }
        if (!tbFirst.isChecked() && tbSecond.isChecked()) {
            tbFirst.setChecked(true);
        }
    }

    public void clickedTbFirst(View view) {
        if (tbFirst.isChecked()) {
            bTb1Checked = true;
        } else {
            bTb1Checked = false;
        }
    }

    private boolean validateInputs() {
        // Implement your validation logic here
        // For now, let's assume everything is valid
        return true;
    }
}
