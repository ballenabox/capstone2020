package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class showBarChartActivity extends AppCompatActivity {

    BarChart barChart;
    int[] colorArray = new int[]{Color.LTGRAY,Color.BLUE,Color.RED,Color.CYAN,Color.YELLOW};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bar_chart);

        barChart = findViewById(R.id.barchart);

        BarDataSet barDataSet = new BarDataSet(data1(),"중식");
        BarDataSet barDataSet1 = new BarDataSet(data2(),"fast");
        BarDataSet barDataSet2 = new BarDataSet(data3(),"일식");
        BarDataSet barDataSet3 = new BarDataSet(data4(),"한식");
        BarDataSet barDataSet4 = new BarDataSet(data5(),"양식");
        barDataSet.setColors(Color.LTGRAY);
        barDataSet1.setColors(Color.BLUE);
        barDataSet2.setColors(Color.RED);
        barDataSet3.setColors(Color.CYAN);
        barDataSet4.setColors(Color.YELLOW);

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);
        barData.addDataSet(barDataSet1);
        barData.addDataSet(barDataSet2);
        barData.addDataSet(barDataSet3);
        barData.addDataSet(barDataSet4);

        //pieChart description setting
        Description description = new Description();
        description.setText("먹은 비율");
        description.setTextSize(15);
        barChart.setDescription(description);

        barChart.setData(barData);
        barChart.invalidate();


    }
    private ArrayList<BarEntry>data1(){
        ArrayList<BarEntry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int china = Integer.valueOf(getIntent().getStringExtra("china"));
        datavalue.add(new BarEntry(0,china));
        return datavalue;
    }
    private ArrayList<BarEntry>data2(){
        ArrayList<BarEntry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int fast = Integer.valueOf(getIntent().getStringExtra("fast"));
        datavalue.add(new BarEntry(1,fast));
        return datavalue;
    }
    private ArrayList<BarEntry>data3(){
        ArrayList<BarEntry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int japan = Integer.valueOf(getIntent().getStringExtra("japan"));
        datavalue.add(new BarEntry(2,japan));
        return datavalue;
    }
    private ArrayList<BarEntry>data4(){
        ArrayList<BarEntry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int korea = Integer.valueOf(getIntent().getStringExtra("korea"));
        datavalue.add(new BarEntry(3,korea));
        return datavalue;
    }
    private ArrayList<BarEntry>data5(){
        ArrayList<BarEntry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int usa = Integer.valueOf(getIntent().getStringExtra("usa"));
        datavalue.add(new BarEntry(4,usa));
        return datavalue;
    }
}