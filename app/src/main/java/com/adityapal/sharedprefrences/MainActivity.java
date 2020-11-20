package com.adityapal.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText usename,password;
    Button btnlogin;
    public static SharedPreferences sharedPreferences;

    private static final String shared_preff_name="mypreff";
    private  static final String key_usernames="name";
    private static  final String key_pass="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences(shared_preff_name,MODE_PRIVATE);
String user=sharedPreferences.getString("key_usernames",null);
        if (user!=null) {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
        }
            usename=(EditText) findViewById(R.id.username);
            password=(EditText) findViewById(R.id.password);
            Button btnlogin=(Button)findViewById(R.id.btnlogin);
            // use to write the data MODE_PRIVATE










        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(key_usernames,usename.getText().toString());
                editor.putString(key_pass,password.getText().toString());
                editor.apply();
                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }}
