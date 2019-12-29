package com.example.pd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button scan,display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan=findViewById(R.id.button1);
        display=findViewById(R.id.button2);
    }
    public void scan(View view){
        String s="SCANNING";
        BackgroudTask b=new BackgroudTask();
        b.execute("Start");
        scan.setText(s);
        scan.setEnabled(false);
        display.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scan.setText("SCAN");
                scan.setEnabled(true);
                display.setEnabled(true);
            }
        },10000);
    }
    public void display(View view){
        Intent i=new Intent(this,Display.class);
        startActivity(i);
    }
}
