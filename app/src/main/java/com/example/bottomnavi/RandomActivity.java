package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    private Button btn_showRandom;
    private TextView showResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        btn_showRandom = (Button) findViewById(R.id.btn_showRandom);
        showResult = (TextView) findViewById(R.id.showResult);
        btn_showRandom.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //랜덤에 넣을값
                String[] str =  {"중식", "FASTFOOD", "한식","일식","양식"};
                int r = (int)(Math.random()*5);

                showResult.setText (str[r] );
            }
        });
    }
}