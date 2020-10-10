package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.EventLog;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class showPieChartActivity extends AppCompatActivity {

    PieChart pieChart;
    int[] colorArray = new int[]{Color.LTGRAY,Color.BLUE,Color.RED,Color.CYAN,Color.YELLOW};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pie_chart);

        pieChart =findViewById(R.id.pie_Chart);
        PieDataSet pieDataSet = new PieDataSet(data1(),"먹은음식");
        pieDataSet.setColors(colorArray);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setDrawEntryLabels(true);
        pieChart.setUsePercentValues(true);
        pieData.setValueTextSize(25);
        pieChart.setCenterText("종류");
        pieChart.setCenterTextSize(20);
        pieChart.setHoleRadius(30);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    private ArrayList<PieEntry>data1(){
        ArrayList<PieEntry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int china = Integer.valueOf(getIntent().getStringExtra("china"));
        int fast = Integer.valueOf(getIntent().getStringExtra("fast"));
        int japan = Integer.valueOf(getIntent().getStringExtra("japan"));
        int kor = Integer.valueOf(getIntent().getStringExtra("korea"));
        int usa = Integer.valueOf(getIntent().getStringExtra("usa"));

        datavalue.add(new PieEntry(china,"중식"));
        datavalue.add(new PieEntry(fast,"패슷"));
        datavalue.add(new PieEntry(japan,"일식"));
        datavalue.add(new PieEntry(kor,"한식"));
        datavalue.add(new PieEntry(usa,"양식"));
        return datavalue;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}