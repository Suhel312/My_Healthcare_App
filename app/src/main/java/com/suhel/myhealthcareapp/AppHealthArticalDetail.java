package com.suhel.myhealthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AppHealthArticalDetail extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_health_artical_detail);

        tv1=findViewById(R.id.textViewHADTitle);
        img=findViewById(R.id.imageViewHAD);
        btnback=findViewById(R.id.buttonHADBack);

        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();
        if (bundle!= null){
            int resId=bundle.getInt("text2");
            img.setImageResource(resId);
        }

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AppHealthArticalDetail.this,AppHealthArtical.class));
            }
        });
    }
}