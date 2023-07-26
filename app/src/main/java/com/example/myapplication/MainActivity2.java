package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button button4;
    EditText pho;
    public static String lo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pho=(EditText) findViewById(R.id.pho);
        button4=(Button)findViewById(R.id.button4);





    }

    public void ki(View view) {
        lo=pho.getText().toString();
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
    }
}



