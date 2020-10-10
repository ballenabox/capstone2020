package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class showBarChartActivity extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bar_chart);

        barChart = findViewById(R.id.barchart);

        BarDataSet barDataSet = new BarDataSet(data1(),"중식,fast,일식,한식,양식");

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);

        barChart.setData(barData);
        barChart.invalidate();


    }
    private ArrayList<BarEntry>data1(){
        ArrayList<BarEntry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int china = Integer.valueOf(getIntent().getStringExtra("china"));
        int fast = Integer.valueOf(getIntent().getStringExtra("fast"));
        int japan = Integer.valueOf(getIntent().getStringExtra("japan"));
        int korea = Integer.valueOf(getIntent().getStringExtra("korea"));
        int usa = Integer.valueOf(getIntent().getStringExtra("usa"));
        datavalue.add(new BarEntry(0,china));
        datavalue.add(new BarEntry(1,fast));
        datavalue.add(new BarEntry(2,japan));
        datavalue.add(new BarEntry(3,korea));
        datavalue.add(new BarEntry(4,usa));
        return datavalue;
    }
}