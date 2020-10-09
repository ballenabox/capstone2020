package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class showLineChartActivity extends AppCompatActivity implements Frag3.OnTimePickerSetListener {
    private int Cchi;
    private int Cfast;
    private int Cjap;
    private int Ckor;
    private int Cusa;
    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_line_chart);

        lineChart = findViewById(R.id.lineChart);
        LineDataSet lineDataSet1 = new LineDataSet(data1(),"중식,fast,일식,한식,양식");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();

    }
    @Override
    public void onTimePickerSet(String chi, String fast, String jap, String kor, String usa) {
        Cchi = Integer.valueOf(chi);
        Cfast = Integer.valueOf(fast);
        Cjap = Integer.valueOf(jap);
        Ckor = Integer.valueOf(kor);
        Cusa = Integer.valueOf(usa);
    }

    private ArrayList<Entry>data1(){
        ArrayList<Entry>datavalue = new ArrayList<>();

        datavalue.add(new Entry(0,Cchi));
        datavalue.add(new Entry(1,Cfast));
        datavalue.add(new Entry(2,Cjap));
        datavalue.add(new Entry(3,Ckor));
        datavalue.add(new Entry(4,Cusa));
        return datavalue;
    }

}