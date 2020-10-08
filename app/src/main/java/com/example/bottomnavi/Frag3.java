package com.example.bottomnavi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Response;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Frag3 extends Fragment {

    private View view;
    PieChart pieChart;
    int[] colorArray = new int[]{Color.LTGRAY,Color.BLUE,Color.RED};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        //MainActivity에서 전달한 번들 저장
        Bundle bundle = getArguments();
        String userID = bundle.getString("userID");
        /*
        String userEmail = bundle.getString("userEmail");
        String userPass = bundle.getString("userPass");
        String menuId = bundle.getString("menuId");
        String foodTheme = bundle.getString("foodTheme");
        Integer menuCount = bundle.getInt("menuCount",0);
        */

        //차트 설정
        pieChart = (PieChart) view.findViewById(R.id.pieChart);
        PieDataSet pieDataSet = new PieDataSet(data1(),"좋음싫음설문");
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

        return view;
    }
    //차트 속성 배열
    private ArrayList<PieEntry>data1(){
        ArrayList<PieEntry>datavalue = new ArrayList<>();

        datavalue.add(new PieEntry(30,"무응답"));
        datavalue.add(new PieEntry(50,"좋음"));
        datavalue.add(new PieEntry(20,"싫음"));
        return datavalue;
    }
}
