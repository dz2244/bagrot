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
    int gLashon , gSafrot,gHistory ,gEzrahot ,gTanah;
    final int REQUEST_CODE = 369;
    double sum1;
    String sUserName ,sLashon, sSafrot,sHistory ,sEzrahot ,sTanah;

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

    public void clickedNext1(View view) {
        sUserName = etName.getText().toString();
        sLashon = etLashon.getText().toString();
        sSafrot = etSafrot.getText().toString();
        sHistory = etHistory.getText().toString();
        sEzrahot = etEzrahot.getText().toString();
        sTanah = etTanah.getText().toString();

        if((!sUserName.isEmpty())||(!sLashon.isEmpty())||(!sSafrot.isEmpty())||(!sHistory.isEmpty())||(!sEzrahot.isEmpty())||(!sTanah.isEmpty()))
        {
            gLashon = Integer.valueOf(sLashon);
            gSafrot = Integer.valueOf(sSafrot);
            gHistory = Integer.valueOf(sHistory);
            gEzrahot = Integer.valueOf(sEzrahot);
            gTanah = Integer.valueOf(sTanah);

            if (!(gLashon > 100) || !(gSafrot > 100) || !(gHistory > 100) || !(gEzrahot > 100) || !(gTanah > 100))
            {
                sum1 = (2*gEzrahot) + (2*gLashon) + (2*gHistory)+ (2*gSafrot) + (2*gTanah);
            }
            else
                Toast.makeText(this, "enter the real grade♥", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "you need to fill all of the grades(and the name)", Toast.LENGTH_SHORT).show();

        Intent gi = new Intent(this, bagrot2.class);
        gi.putExtra("lashon",gLashon);
        gi.putExtra("Safrot",gSafrot);
        gi.putExtra("History",gHistory);
        gi.putExtra("Ezrahot",gEzrahot);
        gi.putExtra("Tanah",gTanah);
        gi.putExtra("sum1",sum1);
        gi.putExtra("userName",sUserName);


        super.startActivityForResult(gi,REQUEST_CODE);

    }
    @Override
    protected void onActivityResult(int source, int result, Intent data_back){
        super.onActivityResult(source, result, data_back);
        if(data_back != null )
        {
            gLashon = data_back.getIntExtra("lashon",1);
            gSafrot = data_back.getIntExtra("Safrot",1);
            gHistory = data_back.getIntExtra("History",1);
            gEzrahot = data_back.getIntExtra("Ezrahot",1);
            gTanah = data_back.getIntExtra("Tanah",1);
            sUserName = data_back.getStringExtra("username");
        }
    }
}