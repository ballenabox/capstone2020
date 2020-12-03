package com.example.bottomnavi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

        // Button 정보
        btn_chart = view.findViewById(R.id.btn_chart);
        btn_recommend = view.findViewById(R.id.btn_recommend);
        btn_randomMenu = view.findViewById(R.id.btn_randomMenu);

        btn_chart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ChartActivity.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });

        btn_recommend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            String res = jsonObject.getString("recommend");

                            // 성공 메시지 출력
                            if(success) {

                                AlertDialog.Builder recAlert = new AlertDialog.Builder(getActivity())
                                        .setTitle("추천 메뉴")
                                        .setMessage("오늘은 " + res + "이 좋겠네요!")
                                        .setPositiveButton("고마워요!", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });

                                recAlert.show();

                            }
                            else {
                                AlertDialog.Builder recAlert = new AlertDialog.Builder(getActivity())
                                        .setTitle("오류 발생")
                                        .setMessage("실패했어요")
                                        .setPositiveButton("다음에 봐요", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });

                                recAlert.show();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 Volley를 이용해서 요청을 보냄
                RecommendRequest recRequest = new RecommendRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                queue.add(recRequest);

            }
        });

        btn_randomMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),RandomActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
