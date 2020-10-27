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
    Random rnd; //랜덤클래스로 부터 객체 생성
    private Button btn_showRandom;
    private TextView showResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        rnd = new Random(); //랜덤클래스로부터 랜덤 값 받아오는 변수 작성.
        btn_showRandom = (Button) findViewById(R.id.btn_showRandom);
        showResult = (TextView) findViewById(R.id.showResult);
        btn_showRandom.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String[] str =  {"중식", "FASTFOOD", "한식","일식","양식"};
                int r = (int)(Math.random()*5);

                showResult.setText (str[r] );
            }
        });
    }
}