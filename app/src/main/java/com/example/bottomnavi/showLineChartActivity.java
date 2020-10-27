package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class showLineChartActivity extends AppCompatActivity  {

    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_line_chart);

        lineChart = findViewById(R.id.lineChart);
        LineDataSet lineDataSet1 = new LineDataSet(data1(),"중식,fast,일식,한식,양식");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        //pieChart description setting
        dataSets.add(lineDataSet1);
        LineData lineData = new LineData(lineDataSet1);
        Description description = new Description();
        description.setText("먹은 수");
        description.setTextSize(15);
        lineChart.setDescription(description);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();

    }

    private ArrayList<Entry>data1(){
        ArrayList<Entry>datavalue = new ArrayList<>();
        Intent intent = getIntent();
        int china = Integer.valueOf(getIntent().getStringExtra("china"));
        int fast = Integer.valueOf(getIntent().getStringExtra("fast"));
        int japan = Integer.valueOf(getIntent().getStringExtra("japan"));
        int kor = Integer.valueOf(getIntent().getStringExtra("korea"));
        int usa = Integer.valueOf(getIntent().getStringExtra("usa"));
        datavalue.add(new Entry(0,china));
        datavalue.add(new Entry(1,fast));
        datavalue.add(new Entry(2,japan));
        datavalue.add(new Entry(3,kor));
        datavalue.add(new Entry(4,usa));
        return datavalue;
    }

}