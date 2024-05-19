package com.example.bagrot;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
    int gLashon, gSafrot, gHistory, gEzrahot, gTanah, lMath, lEnglish, gMath, gEnglish, gFirstMegama, gSecondMegama, gThirdMegama;
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

        bTb1Checked = si.getBooleanExtra("bTb1Checked",true);
        bTb2checked = si.getBooleanExtra("bTb2Checked",true);

        if (bTb2checked)
        {
            etChoice3.setVisibility(View.VISIBLE);
            etChoice3Grade.setVisibility(View.VISIBLE);
            tbSecond.setChecked(true);
            tbFirst.setChecked(true);
        }
        else if (bTb1Checked) {
            tbFirst.setChecked(true);
        }

        etUnitsMath.setText(si.getStringExtra("lMath"));
        etUnitsEng.setText(si.getStringExtra("lEnglish"));
        etGradeMath.setText(si.getStringExtra("gMath"));
        etGradeEng.setText(si.getStringExtra("gEnglish"));

        etChoice1Grade.setText(si.getStringExtra("gFirstMegama"));
        etChoice2Grade.setText(si.getStringExtra("gSecondMegama"));
        etChoice3Grade.setText(si.getStringExtra("gThirdMegama"));

        etChoice1.setText(si.getStringExtra("nameFirstMegama"));
        etChoice2.setText(si.getStringExtra("nameSecondMegama"));
        etChoice3.setText(si.getStringExtra("nameThirdMegama"));

        bTb1Checked = si.getBooleanExtra("bTb1Checked",true);
        bTb2checked = si.getBooleanExtra("bTb2Checked",true);

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
            saveData();
            Intent ai = new Intent(this, bagrot3.class);
            ai.putExtras(si);
            startActivity(ai);
        }
    }
    public void clickedPrev2(View view) {
        saveData();
        setResult(Activity.RESULT_OK, si);
        finish();
    }
    public void clickedTbFirst(View view) {
        if(tbSecond.isChecked())
        {
            tbFirst.setChecked(true);
            Toast.makeText(this, "u cannot have 11 points", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickedTbSecond(View view) {
        if(!tbSecond.isChecked())
        {
            etChoice3.setVisibility(View.INVISIBLE);
            etChoice3Grade.setVisibility(View.INVISIBLE);
        }
        else {
            etChoice3.setVisibility(View.VISIBLE);
            etChoice3Grade.setVisibility(View.VISIBLE);
        }
    }
    private boolean validateInputs() {
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

        if (slMath.isEmpty() || slEnglish.isEmpty() || sgMath.isEmpty() || sgEnglish.isEmpty() || sgFirstMegama.isEmpty() || sgSecondMegama.isEmpty() || sgThirdMegama.isEmpty() || nameFirstMegama.isEmpty() || nameSecondMegama.isEmpty() || nameThirdMegama.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        gMath = Integer.parseInt(sgMath);
        gEnglish = Integer.parseInt(sgEnglish);
        gFirstMegama = Integer.parseInt(sgFirstMegama);
        gSecondMegama = bTb1Checked ? Integer.parseInt(sgSecondMegama) : -1;
        gThirdMegama = bTb2checked ? Integer.parseInt(sgThirdMegama) : -1;

        if (gMath < 0 || gMath > 100 || gEnglish < 0 || gEnglish > 100 ||
                gFirstMegama < 0 || gFirstMegama > 100 ||
                (gSecondMegama != -1 && (gSecondMegama < 0 || gSecondMegama > 100)) || (gThirdMegama != -1 && (gThirdMegama < 0 || gThirdMegama > 100))) {
            Toast.makeText(this, "Please enter realistic grades (0-100)", Toast.LENGTH_SHORT).show();
            return false;
        }

        lMath = Integer.parseInt(sgMath);
        lEnglish = Integer.parseInt(sgEnglish);

        if (lMath < 3 || lMath > 5 || lEnglish < 3 || lEnglish > 5) {
            Toast.makeText(this, "Please enter levels between 3 and 5", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!nameFirstMegama.matches("[a-zA-Z\\s]+") || !nameSecondMegama.matches("[a-zA-Z\\s]+") || !nameThirdMegama.matches("[a-zA-Z\\s]+")) {
            Toast.makeText(this, "Please enter only letters and spaces for choices", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void saveData() {
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
        if(tbSecond.isChecked())
        {
            bTb1Checked = true;
            bTb2checked = true;
        }
        else if(tbFirst.isChecked())
        {
            bTb1Checked = true;
            bTb2checked = false;
        }

        si.putExtra("lMath", slMath);
        si.putExtra("lEnglish", slEnglish);
        si.putExtra("gMath", sgMath);
        si.putExtra("gEnglish", sgEnglish);
        si.putExtra("gFirstMegama", sgFirstMegama);

        si.putExtra("gSecondMegama", sgSecondMegama);
        if (tbSecond.isChecked())
            si.putExtra("gThirdMegama", sgThirdMegama);

        si.putExtra("nameFirstMegama", nameFirstMegama);
        si.putExtra("nameSecondMegama", nameSecondMegama);
        si.putExtra("nameThirdMegama", nameThirdMegama);

        si.putExtra("bTb1Checked", bTb1Checked);
        si.putExtra("bTb2checked", bTb2checked);
    }
}