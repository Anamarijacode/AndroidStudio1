package com.fpintaric.pmabosnjak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import com.google.android.material.switchmaterial.SwitchMaterial;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class StudentInfoActivity extends AppCompatActivity {
    private String sIme;
    private String sPredmet;
    private String sDatum;
    private String sPrezime;
    private String sProfesor;
    private String sSatiPR;
    private String sSatiLV;
    private String sIzborni;
    private Button sOtvoriSazetak;
    private TextInputEditText oProfesor;
    private TextInputEditText oSatiPR;
    private TextInputEditText oSatiLV;

    private SwitchMaterial oIzborni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        final Bundle oExtras = getIntent().getExtras();
        sIme= oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatum = oExtras.getString("datum");
        oProfesor=findViewById(R.id.tietProfesor);
        oSatiPR=findViewById(R.id.tietSatiPR);
        oSatiLV=findViewById(R.id.tietSatiLV);
        oIzborni=findViewById(R.id.sIzbornik);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, PREDMETI);
        AutoCompleteTextView oPredmet = findViewById(R.id.auPredmet);
        oPredmet.setAdapter(adapter);
        sOtvoriSazetak = findViewById(R.id.btnSazetak);
        sOtvoriSazetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sPredmet = oPredmet.getText().toString();
                sProfesor= oProfesor.getText().toString();
                sSatiPR= oSatiPR.getText().toString();
                sSatiLV= oSatiLV.getText().toString();
                sIzborni = oIzborni.isChecked() ? "true" : "false";

                if (sPredmet.matches("") || sProfesor.matches("") || sSatiPR.matches("") || sSatiLV.matches("") )
                {
                    if(sPredmet.matches("")){
                    Toast.makeText(getApplicationContext(),"Nema unesenoga predmeta",Toast.LENGTH_LONG).show();}
                    else if(sProfesor.matches("")){
                        Toast.makeText(getApplicationContext(),"Nema unesenoga profesora",Toast.LENGTH_LONG).show();}
                    else if(sSatiPR.matches("")){
                        Toast.makeText(getApplicationContext(),"Nema unsenih sati prakse",Toast.LENGTH_LONG).show();}
                    else{
                        Toast.makeText(getApplicationContext(),"Nema unsesnih sati vježbe",Toast.LENGTH_LONG).show();}

                }
                else{
                Intent oSazetak = new Intent(getApplicationContext(), SummaryActivity.class);
                oSazetak.putExtra("ime",sIme);
                oSazetak.putExtra("prezime", sPrezime);
                oSazetak.putExtra("datum", sDatum);
                oSazetak.putExtra("predmet", sPredmet);
                oSazetak.putExtra("profesor", sProfesor);
                oSazetak.putExtra("satiPR", sSatiPR);
                oSazetak.putExtra("satiLV", sSatiLV);
                oSazetak.putExtra("izborni",sIzborni );

                startActivity(oSazetak);
            }}
        });


    }

    private static final String[] PREDMETI = new String[]
            {
                    "Osnove programiranja", "Objektno orijentirano programiranje", "Osnove web programiranja", "Programiranje mobilnih aplikacija", "Programiranje u .NET okolini"
            };
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }
}