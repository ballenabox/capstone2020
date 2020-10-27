package com.example.bottomnavi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Frag3 extends Fragment {

    private View view;
    private Button btn_chart,btn_recommend,btn_randomMenu;
    /*
    private Button btn_piechart;
    private Button btn_barchart;
    private Button btn_linechart;
    public OnTimePickerSetListener onTimePickerSetListener;
     */
    PieChart pieChart;
    int[] colorArray = new int[]{Color.LTGRAY,Color.BLUE,Color.RED};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        //MainActivity에서 전달한 번들 저장
        Bundle bundle = getArguments();
        final String userID = bundle.getString("userID");
        /*
        String userEmail = bundle.getString("userEmail");
        String userPass = bundle.getString("userPass");
        String menuId = bundle.getString("menuId");
        String foodTheme = bundle.getString("foodTheme");
        Integer menuCount = bundle.getInt("menuCount",0);
        */
        // Button 정보
        btn_chart = view.findViewById(R.id.btn_chart);
        btn_recommend = view.findViewById(R.id.btn_recommend);
        btn_randomMenu = view.findViewById(R.id.btn_randomMenu);
        /*
        btn_piechart = (Button) view.findViewById(R.id.btn_piechart);
        btn_barchart = (Button) view.findViewById(R.id.btn_barchart);
        btn_linechart = (Button) view.findViewById(R.id.btn_linechart);
         */
        btn_chart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ChartActivity.class);
                startActivity(intent);
            }
        });
        btn_recommend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ChartActivity.class);
                startActivity(intent);
            }
        });
        btn_randomMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),RandomActivity.class);
                startActivity(intent);
            }
        });


        /*
        //파이차트 보기 클릭 시
        btn_piechart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String userID = "abc123";
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            String china = jsonObject.getString("china");
                            String fast = jsonObject.getString("fast");
                            String japan = jsonObject.getString("japan");
                            String korea = jsonObject.getString("korea");
                            String usa = jsonObject.getString("usa");

                            if(success) {   // 반환 성공
                                //데이터를 넘겨주고 화면전환 부분.


                               // onTimePickerSetListener.onTimePickerSet(china,fast,japan,korea,usa);
                                Intent intent =new Intent(getActivity(),showPieChartActivity.class);
                                startActivity(intent);
                            } else {        // 반환 실패

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                GetCountRequest getCountRequest = new GetCountRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(getCountRequest);
            }
        });

         */
//막대차트 보기 클릭 시
        /*
        btn_barchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userID = "abc123";

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            String china = jsonObject.getString("china");
                            String fast = jsonObject.getString("fast");
                            String japan = jsonObject.getString("japan");
                            String korea = jsonObject.getString("korea");
                            String usa = jsonObject.getString("usa");

                            if(success) {   // 반환 성공

                                onTimePickerSetListener.onTimePickerSet(china,fast,japan,korea,usa);
                                Intent intent =new Intent(getActivity(),showPieChartActivity.class);
                                startActivity(intent);

                            } else {        // 반환 실패
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                GetCountRequest getCountRequest = new GetCountRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(getCountRequest);


            }
        });
//라인차트 보기 클릭 시
        btn_linechart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String userID = "abc123";
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            String china = jsonObject.getString("china");
                            String fast = jsonObject.getString("fast");
                            String japan = jsonObject.getString("japan");
                            String korea = jsonObject.getString("korea");
                            String usa = jsonObject.getString("usa");

                            if(success) {   // 반환 성공
                                //데이터를 넘겨주고 화면전환 부분.
                     //           onTimePickerSetListener.onTimePickerSet(china,fast,japan,korea,usa);
                                Intent intent =new Intent(getActivity(),showLineChartActivity.class);
                                startActivity(intent);
                            } else {        // 반환 실패

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                GetCountRequest getCountRequest = new GetCountRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(getCountRequest);
            }
        });


         */
        //차트 설정
        /*
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

         */
        return view;
    }
/*
    public interface OnTimePickerSetListener{
        void onTimePickerSet(String chi, String fast, String jap, String kor, String usa);
    }

 */
    //차트 속성 배열
    /*
    private ArrayList<PieEntry>data1(){
        ArrayList<PieEntry>datavalue = new ArrayList<>();

        datavalue.add(new PieEntry(30,"무응답"));
        datavalue.add(new PieEntry(50,"좋음"));
        datavalue.add(new PieEntry(20,"싫음"));
        return datavalue;
    }

     */
    //onAttach는 얻어온 context를 사용하여 형변환 후, onTimePickerSetListener 변수에 넣고 사용.
    /*
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnTimePickerSetListener){
            onTimePickerSetListener = (OnTimePickerSetListener) context;
        } else {
//                throw new RuntimeException(context.toString()+"must implements");
        }
    }

     */
    /*
    //값 해체
    @Override
    public void onDetach(){
        super.onDetach();
        onTimePickerSetListener = null;
    }

     */
}
