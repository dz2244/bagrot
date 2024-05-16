package com.example.bagrot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etLashon,etSafrot,etHistory,etEzrahot,etTanah,etName;
    int gLashon , gSafrot,gHistory ,gEzrahot ,gTanah ;
    final int REQUEST_CODE = 369;
    double sum1;
    String sUserName ,sLashon, sSafrot,sHistory ,sEzrahot ,sTanah , slMath = "",slEnglish = "",sgMath = "",sgEnglish = "", nameFirstMegama = "",nameSecondMegama = "",nameThirdMegama = "" ,sgFirstMegama = "",sgSecondMegama = "",sgThirdMegama= "";
    boolean bTb1Checked,bTb2checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        etName = findViewById(R.id.etName);
        etLashon = findViewById(R.id.etLashon);
        etSafrot = findViewById(R.id.etSafrot);
        etHistory = findViewById(R.id.etHistory);
        etEzrahot = findViewById(R.id.etEzrahot);
        etTanah = findViewById(R.id.etTanah);
    }

    public void clickedNext1(View view)
    {
        sUserName = etName.getText().toString();
        sLashon = etLashon.getText().toString();
        sSafrot = etSafrot.getText().toString();
        sHistory = etHistory.getText().toString();
        sEzrahot = etEzrahot.getText().toString();
        sTanah = etTanah.getText().toString();

        if((!sUserName.isEmpty())&&(!sLashon.isEmpty())&&(!sSafrot.isEmpty())&&(!sHistory.isEmpty())&&(!sEzrahot.isEmpty())&&(!sTanah.isEmpty()))
        {
            gLashon = Integer.valueOf(sLashon);
            gSafrot = Integer.valueOf(sSafrot);
            gHistory = Integer.valueOf(sHistory);
            gEzrahot = Integer.valueOf(sEzrahot);
            gTanah = Integer.valueOf(sTanah);

            if ((gLashon < 100) && (gSafrot < 100) && (gHistory < 100) && (gEzrahot < 100) && (gTanah < 100))
            {

                sum1 = (2*gEzrahot) + (2*gLashon) + (2*gHistory)+ (2*gSafrot) + (2*gTanah);

                Intent gi = new Intent(this, bagrot2.class);
                gi.putExtra("lashon",gLashon);
                gi.putExtra("Safrot",gSafrot);
                gi.putExtra("History",gHistory);
                gi.putExtra("Ezrahot",gEzrahot);
                gi.putExtra("Tanah",gTanah);
                gi.putExtra("sum1",sum1);
                gi.putExtra("userName",sUserName);
                gi.putExtra("lMath", slMath);
                gi.putExtra("lEnglish", slEnglish);
                gi.putExtra("gMath", sgMath);
                gi.putExtra("gEnglish", sgEnglish);
                gi.putExtra("gFirstMegama", sgFirstMegama);

                if (bTb1Checked)
                    gi.putExtra("gSecondMegama", sgSecondMegama);
                if (bTb2checked)
                    gi.putExtra("gThirdMegama", sgThirdMegama);
                gi.putExtra("nameFirstMegama",nameFirstMegama);
                gi.putExtra("nameSecondMegama",nameSecondMegama);
                gi.putExtra("nameThirdMegama",nameThirdMegama);
                gi.putExtra("bTb1Checked",bTb1Checked);
                gi.putExtra("bTb2checked",bTb2checked);
                super.startActivityForResult(gi,REQUEST_CODE);
            }
            else
                Toast.makeText(this, "enter the real grade♥", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "you need to fill all of the grades(and the name)", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int source, int result, Intent data_back){
        super.onActivityResult(source, result, data_back);
        if(data_back != null )
        {
            slMath = data_back.getStringExtra("lMath");
            slEnglish = data_back.getStringExtra("lEnglish");
            sgMath = data_back.getStringExtra("gMath");
            sgEnglish = data_back.getStringExtra("gEnglish");
            sgFirstMegama = data_back.getStringExtra("gFirstMegama");
            sgSecondMegama = data_back.getStringExtra("gSecondMegama");
            sgThirdMegama = data_back.getStringExtra("gThirdMegama");
            nameFirstMegama = data_back.getStringExtra("nameFirstMegama");
            nameSecondMegama = data_back.getStringExtra("nameSecondMegama");
            nameThirdMegama = data_back.getStringExtra("nameThirdMegama");
            bTb1Checked = data_back.getBooleanExtra("bTb1Checked",false);
            bTb2checked = data_back.getBooleanExtra("bTb2checked",false);
        }
    }
}