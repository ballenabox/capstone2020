package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class showPieChartActivity extends AppCompatActivity implements Frag3.OnTimePickerSetListener{
    private int Cchi;
    private int Cfast;
    private int Cjap;
    private int Ckor;
    private int Cusa;
    PieChart pieChart;
    int[] colorArray = new int[]{Color.LTGRAY,Color.BLUE,Color.RED};
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

    @Override
    public void onTimePickerSet(String chi, String fast, String jap, String kor, String usa) {
        Cchi = Integer.valueOf(chi);
        Cfast = Integer.valueOf(fast);
        Cjap = Integer.valueOf(jap);
        Ckor = Integer.valueOf(kor);
        Cusa = Integer.valueOf(usa);
    }
    private ArrayList<PieEntry>data1(){
        ArrayList<PieEntry>datavalue = new ArrayList<>();

        datavalue.add(new PieEntry(Cchi,"중식"));
        datavalue.add(new PieEntry(Cfast,"패슷"));
        datavalue.add(new PieEntry(Cjap,"일식"));
        datavalue.add(new PieEntry(Ckor,"한식"));
        datavalue.add(new PieEntry(Cusa,"양식"));
        return datavalue;
    }
}