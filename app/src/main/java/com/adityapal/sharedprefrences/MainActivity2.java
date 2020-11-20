package com.adityapal.sharedprefrences;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {
TextView t1,t2;
Button btn2;
SharedPreferences sh;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
t1=(TextView)findViewById(R.id.t1);
btn2=(Button)findViewById(R.id.btn2);
//        MODE_APPEND to read data from xml
        sh=getSharedPreferences("mypreff",MODE_APPEND);
        String setting = sh.getString("name","" );
   t1.setText(setting);
        if (sh==null){
            Intent i=new Intent(MainActivity2.this,MainActivity.class);
            startActivity(i);
        }
   btn2.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           sh.edit().clear().commit();
           Intent i=new Intent(MainActivity2.this,MainActivity.class);
           startActivity(i);
       }
   });
    }
}