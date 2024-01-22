package com.suhel.myhealthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppFindDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppFindDoctor.this,AppHome.class));
            }
        });

        CardView familyphysician=findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(AppFindDoctor.this,AppDoctorDetail.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

        CardView ditician=findViewById(R.id.cardFDDietician);
        ditician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(AppFindDoctor.this,AppDoctorDetail.class);
                it.putExtra("title","Ditician");
                startActivity(it);

            }
        });

        CardView dentist=findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(AppFindDoctor.this,AppDoctorDetail.class);
                it.putExtra("title","Dentist");
                startActivity(it);

            }
        });

        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(AppFindDoctor.this,AppDoctorDetail.class);
                it.putExtra("title","Surgeon");
                startActivity(it);

            }
        });

        CardView cardiologist=findViewById(R.id.cardFDCardiologists);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(AppFindDoctor.this,AppDoctorDetail.class);
                it.putExtra("title","Cardiologists");
                startActivity(it);

            }
        });

    }
}