package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class showBarChartActivity extends AppCompatActivity {
    private int Cchi;
    private int Cfast;
    private int Cjap;
    private int Ckor;
    private int Cusa;
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

        datavalue.add(new BarEntry(0,Cchi));
        datavalue.add(new BarEntry(1,Cfast));
        datavalue.add(new BarEntry(2,Cjap));
        datavalue.add(new BarEntry(3,Ckor));
        datavalue.add(new BarEntry(4,Cusa));
        return datavalue;
    }
}