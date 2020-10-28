package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.Chart;

import org.json.JSONException;
import org.json.JSONObject;

public class ChartActivity extends AppCompatActivity {

    private Button btn_piechart,btn_barchart,btn_linechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        btn_piechart = findViewById(R.id.btn_piechart);
        btn_barchart = findViewById(R.id.btn_barchart);
        btn_linechart = findViewById(R.id.btn_linechart);

        // 파이 차트 출력
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
                                Intent intent =new Intent(ChartActivity.this,showPieChartActivity.class);
                                intent.putExtra("china",china);
                                intent.putExtra("fast",fast);
                                intent.putExtra("japan",japan);
                                intent.putExtra("korea",korea);
                                intent.putExtra("usa",usa);
                                startActivity(intent);
                            } else {        // 반환 실패

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                GetCountRequest getCountRequest = new GetCountRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChartActivity.this);
                queue.add(getCountRequest);
            }
        });

        // 막대 차트 출력
        btn_barchart.setOnClickListener(new View.OnClickListener(){
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
                                Intent intent =new Intent(ChartActivity.this,showBarChartActivity.class);
                                intent.putExtra("china",china);
                                intent.putExtra("fast",fast);
                                intent.putExtra("japan",japan);
                                intent.putExtra("korea",korea);
                                intent.putExtra("usa",usa);
                                startActivity(intent);
                            } else {        // 반환 실패

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                GetCountRequest getCountRequest = new GetCountRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChartActivity.this);
                queue.add(getCountRequest);
            }
        });

        // 라인 차트 출력
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
                                Intent intent =new Intent(ChartActivity.this,showLineChartActivity.class);
                                intent.putExtra("china",china);
                                intent.putExtra("fast",fast);
                                intent.putExtra("japan",japan);
                                intent.putExtra("korea",korea);
                                intent.putExtra("usa",usa);
                                startActivity(intent);
                            } else {        // 반환 실패

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                GetCountRequest getCountRequest = new GetCountRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChartActivity.this);
                queue.add(getCountRequest);
            }
        });
    }
}