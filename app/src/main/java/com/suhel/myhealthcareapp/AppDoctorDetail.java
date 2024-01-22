package com.suhel.myhealthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class AppDoctorDetail extends AppCompatActivity {

    private String [][] doctor_details1 =
            {
                    {"Doctor name: Suhel Nadaf","Hospital address: Kolhapur","Exp: 5 years","Mobile no: 9986290440","500"},
                    {"Doctor name: Tejas Mohite","Hospital address:Kolhapur","Exp: 3 years","Mobile no: 9786596652","300"},
                    {"Doctor name: Ajinkya Bhoi","Hospital address: Satara","Exp: 3 years","Mobile no: 9136266167","400"},
                    {"Doctor name: Aamrut Aambi","Hospital address: Sangli","Exp: 4 years","Mobile no: 9155290158","300"},
                    {"Doctor name: Omkar Suryavanshi","Hospital address: Miraj","Exp: 5 years","Mobile no: 9948150440","500"}
            };
    private String [][] doctor_details2=
            {
                    {"Doctor name: Nitin Patil","Hospital address: Kolhapur","Exp: 5 years","Mobile no: 9986290440","500"},
                    {"Doctor name: Nilesh Kamble","Hospital address:Kolhapur","Exp: 3 years","Mobile no: 9786596652","300"},
                    {"Doctor name: Sanket Rukade","Hospital address: Satara","Exp: 3 years","Mobile no: 9136266167","400"},
                    {"Doctor name: Sourabh Sapkal","Hospital address: Sangli","Exp: 4 years","Mobile no: 9155290158","300"},
                    {"Doctor name: Sammed Mallade","Hospital address: Miraj","Exp: 5 years","Mobile no: 9948150440","500"}
            };
    private String [][] doctor_details3 =
            {
                    {"Doctor name: Vijay Kamble","Hospital address: Kolhapur","Exp: 5 years","Mobile no: 9986290440","500"},
                    {"Doctor name: Alim Mulla","Hospital address:Kolhapur","Exp: 3 years","Mobile no: 9786596652","300"},
                    {"Doctor name: Prathmesh Jamane","Hospital address: Satara","Exp: 3 years","Mobile no: 9136266167","400"},
                    {"Doctor name: Prem Patil","Hospital address: Sangli","Exp: 4 years","Mobile no: 9155290158","300"},
                    {"Doctor name: Vinayak Kumbhar","Hospital address: Miraj","Exp: 5 years","Mobile no: 9948150440","500"}
            };
    private String [][] doctor_details4 =
            {
                    {"Doctor name: Sagar Sutar","Hospital address: Kolhapur","Exp: 5 years","Mobile no: 9986290440","500"},
                    {"Doctor name: Chetan Koli","Hospital address:Kolhapur","Exp: 3 years","Mobile no: 9786596652","300"},
                    {"Doctor name: Suhas Kulkarni","Hospital address: Satara","Exp: 3 years","Mobile no: 9136266167","400"},
                    {"Doctor name: Athrav Bhosale","Hospital address: Sangli","Exp: 4 years","Mobile no: 9155290158","300"},
                    {"Doctor name: Pratick Wadkar","Hospital address: Miraj","Exp: 5 years","Mobile no: 9948150440","500"}
            };
    private String [][] doctor_details5 =
            {
                    {"Doctor name: Juber Nadaf","Hospital address: Kolhapur","Exp: 5 years","Mobile no: 9986290440","500"},
                    {"Doctor name: Vishal Koli","Hospital address:Kolhapur","Exp: 3 years","Mobile no: 9786596652","300"},
                    {"Doctor name: Saad Shaikh","Hospital address: Satara","Exp: 3 years","Mobile no: 9136266167","400"},
                    {"Doctor name: Vahid Jamadar","Hospital address: Sangli","Exp: 4 years","Mobile no: 9155290158","300"},
                    {"Doctor name: Aaman Maner","Hospital address: Miraj","Exp: 5 years","Mobile no: 9948150440","500"}
            };

    TextView tv;
    Button btn;
    String [][] doctor_details= {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_doctor_detail);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it= getIntent();
        String title= it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
        if (title.compareTo("Ditician")==0)
            doctor_details=doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppDoctorDetail.this,AppFindDoctor.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<doctor_details.length; i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons fees: "+doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String []{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(AppDoctorDetail.this,AppBookAppointment.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}