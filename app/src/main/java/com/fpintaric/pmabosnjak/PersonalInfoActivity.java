 package com.fpintaric.pmabosnjak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PersonalInfoActivity extends AppCompatActivity {
private TextInputEditText oInputIme;
private TextInputEditText oInputPrezime;
private Button oBtnOtvoriStudent;
private String sIme;
private String sPrezime;
private String sDatum;
private TextInputEditText oDatum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();

        materialDateBuilder.setTitleText("SELECT A DATE");

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        oInputIme = findViewById(R.id.tietIme);
        oInputPrezime= findViewById(R.id.tietPrezime1);

        oBtnOtvoriStudent = findViewById(R.id.btnOtvoriStudent);
        oDatum = findViewById(R.id.etDatum1);
        oBtnOtvoriStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sIme = oInputIme.getText().toString();
                sPrezime=oInputPrezime.getText().toString();
                sDatum=oDatum.getText().toString();
                if (sIme.matches("") || sPrezime.matches("") || sDatum.matches("")) {
                    if(sIme.matches(""))
                    {
                        Toast.makeText(getApplicationContext(),"Unesite ime",Toast.LENGTH_LONG).show();
                    }
                    else if(sPrezime.matches(""))
                    {
                        Toast.makeText(getApplicationContext(),"Unesite prezime",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Odaberite datum rođenja",Toast.LENGTH_LONG).show();
                    }
                }
                else{

            Intent oOtvoriStudent = new Intent(getApplicationContext(), StudentInfoActivity.class);
            oOtvoriStudent.putExtra("ime", sIme);
            oOtvoriStudent.putExtra("prezime", sPrezime);
            oOtvoriStudent.putExtra("datum", sDatum);
            startActivity(oOtvoriStudent);
            }}
        });
        oDatum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            }
        });
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                String date = sdf.format(new Date(selection));
                oDatum.setText(date);

            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }
}