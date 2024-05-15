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
    EditText etUnitsMath, etUnitsEng, etGradeMath, etGradeEng, etChoice1 , etChoice2 , etChoice3 ,etChoice1Grade ,etChoice2Grade ,etChoice3Grade ;
    Button btnNext , btnPrev;
    Intent si = new Intent();

    ToggleButton tbFirst , tbSecond;
    int gLashon , gSafrot , gHistory , gEzrahot , gTanah,lMath,lEnglish,gMath,gEnglish,gFirstMegama ,gSecondMegama ,gThirdMegama;

    double sum1;
    String sUserName, nameFirstMegama,nameSecondMegama,nameThirdMegama,slMath,slEnglish,sgMath,sgEnglish,sgFirstMegama ,sgSecondMegama ,sgThirdMegama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagrot2);
        initViews();
        etChoice3.setVisibility(View.INVISIBLE);
        etChoice3Grade.setVisibility(View.INVISIBLE);

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

        if((!slMath.isEmpty())&&(!slEnglish.isEmpty())&&(!sgMath.isEmpty())&&(!sgEnglish.isEmpty())&&(!sgFirstMegama.isEmpty())&&(!sgSecondMegama.isEmpty())&&(!sgThirdMegama.isEmpty())&&(!nameFirstMegama.isEmpty())&&(!nameSecondMegama.isEmpty())&&(!nameThirdMegama.isEmpty()))
        {
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

                setResult(Activity.RESULT_OK,si);
                finish();
            }
            else
                Toast.makeText(this, "enter the real grade♥", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "plz fill all fields", Toast.LENGTH_SHORT).show();
    }

    public void clickedTbSecond(View view) {
        if (!tbFirst.isChecked() && tbSecond.isChecked())
        {
            tbFirst.setChecked(true);
        }
        else if (tbFirst.isChecked() && tbSecond.isChecked())
        {
            etChoice3.setVisibility(View.INVISIBLE);
            etChoice3Grade.setVisibility(View.INVISIBLE);
        }
        else if (tbFirst.isChecked() && !tbSecond.isChecked())
        {
            etChoice3.setVisibility(View.VISIBLE);
            etChoice3Grade.setVisibility(View.VISIBLE);
        }
        else if ((!tbFirst.isChecked()) && (!tbSecond.isChecked()))
        {
            etChoice3.setVisibility(View.VISIBLE);
            etChoice3Grade.setVisibility(View.VISIBLE);
        }

    }
}