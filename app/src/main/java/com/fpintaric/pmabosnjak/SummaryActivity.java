package com.fpintaric.pmabosnjak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.nio.BufferUnderflowException;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class SummaryActivity extends AppCompatActivity {
private TextView tIme;
private TextView tPredmet;
private TextView tPrezime;
private TextView tProfesor;
private TextView tSatiLV;
private TextView tSatiPR;
private TextView tIzborni;
private TextView tDatum;
private String sIme;
private String sPredmet;
private String sPrezime;
private String sProfesor;
private String sSatiLV;
private String sSatiPR;
private String sIzborni;
private String sDatum;
private Button oBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPredmet = oExtras.getString("predmet");
        sPrezime = oExtras.getString("prezime");
        sDatum= oExtras.getString("datum");
        sProfesor=oExtras.getString("profesor");
        sSatiLV= oExtras.getString("satiLV");
        sSatiPR = oExtras.getString("satiPR");
        sIzborni = oExtras.getString("izborni");

        tIme = findViewById(R.id.tIme);
        tIme.setText(sIme);
        tPrezime=findViewById(R.id.tPrezime);
        tPrezime.setText(sPrezime);
        tProfesor=findViewById(R.id.tProfesor);
        tProfesor.setText(sProfesor);
        tDatum=findViewById(R.id.tDatum);
        tDatum.setText(sDatum);
        tSatiLV=findViewById(R.id.tSatiLV);
        tSatiLV.setText(sSatiLV);
        tSatiPR=findViewById(R.id.tSatiPR);
        tSatiPR.setText(sSatiPR);
        if(sIzborni.equals("true")) {
            tIzborni = findViewById(R.id.tIzborni);
            tIzborni.setText("Izborni predmet");
        }


        tPredmet=findViewById((R.id.tPredmet));
        tPredmet.setText(sPredmet);
        oBtn= findViewById(R.id.btnNazad);
        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student studentObjekat = new Student(sIme, sPrezime, sPredmet);
                StudenSingleton.getInstance().dodjaStudent(studentObjekat);
                Intent oOtvoriStudent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(oOtvoriStudent);

            }
        });




    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }
}