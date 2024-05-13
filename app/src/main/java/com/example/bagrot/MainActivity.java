package com.example.bagrot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etLashon,etSafrot,etHistory,etEzrahot,etTanah,etName;
    int gLashon , gSafrot,gHistory ,gEzrahot ,gTanah;
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
        }
        else if ((gLashon>100)||(gSafrot>100)||(gHistory>100)||(gEzrahot>100)||(gTanah>100)||(gLashon<0)||(gSafrot<0)||(gHistory<0)||(gEzrahot<0)||(gTanah<0)) {
            Toast.makeText(this, "enter the real grade♥", Toast.LENGTH_SHORT).show();
        }
        else if ((sUserName.isEmpty())||(sLashon.isEmpty())||(sSafrot.isEmpty())||(sHistory.isEmpty())||(sEzrahot.isEmpty())||(sTanah.isEmpty())){
            Toast.makeText(this, "you need to fill all of the grades(and the name)", Toast.LENGTH_SHORT).show();
        }
        Intent gi = new Intent(this, bagrot2.class);
        startActivity(gi);
    }
}