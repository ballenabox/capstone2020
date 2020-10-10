package com.example.bottomnavi;

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

import org.json.JSONException;
import org.json.JSONObject;

public class Frag2 extends Fragment {

    private View view;
    private Button btn_chi, btn_kor, btn_jap, btn_usa, btn_fast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        //MainActivity에서 전달한 번들 저장
        Bundle bundle = getArguments();
        final String userID = bundle.getString("userID");

        // Button 정보
        btn_chi = (Button) view.findViewById(R.id.btn_chi);
        btn_kor = (Button) view.findViewById(R.id.btn_recommend);
        btn_jap = (Button) view.findViewById(R.id.btn_jap);
        btn_usa = (Button) view.findViewById(R.id.btn_usa);
        btn_fast = (Button) view.findViewById(R.id.btn_fast);

        // 중식 버튼(btn_chi) 클릭 시
        btn_chi.setOnClickListener(new View.OnClickListener() {

            String Food_Theme = "china";

            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            // 성공 메시지 출력
                            if(success) {
                                Toast.makeText(getActivity(), "Add China", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getActivity(), "Add Fail", Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 Volley를 이용해서 요청을 보냄
                MenuRequest menuRequest = new MenuRequest(userID, Food_Theme, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                queue.add(menuRequest);

            }
        });

        // 한식 버튼(btn_kor) 클릭 시
        btn_kor.setOnClickListener(new View.OnClickListener() {

            String Food_Theme = "korea";

            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            // 성공 메시지 출력. (확인용이고 나중에 삭제 예정)
                            if(success) {
                                Toast.makeText(getActivity(), "Add Korea", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getActivity(), "Add Fail", Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 Volley를 이용해서 요청을 보냄
                MenuRequest menuRequest = new MenuRequest(userID, Food_Theme, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                queue.add(menuRequest);

            }
        });

        // 일식 버튼(btn_jap) 클릭 시
        btn_jap.setOnClickListener(new View.OnClickListener() {

            String Food_Theme = "japan";

            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            // 성공 메시지 출력. (확인용이고 나중에 삭제 예정)
                            if(success) {
                                Toast.makeText(getActivity(), "Add Japan", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getActivity(), "Add Fail", Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 Volley를 이용해서 요청을 보냄
                MenuRequest menuRequest = new MenuRequest(userID, Food_Theme, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                queue.add(menuRequest);

            }
        });

        // 양식 버튼(btn_usa) 클릭 시
        btn_usa.setOnClickListener(new View.OnClickListener() {

            String Food_Theme = "usa";

            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            // 성공 메시지 출력. (확인용이고 나중에 삭제 예정)
                            if(success) {
                                Toast.makeText(getActivity(), "Add USA", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getActivity(), "Add Fail", Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 Volley를 이용해서 요청을 보냄
                MenuRequest menuRequest = new MenuRequest(userID, Food_Theme, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                queue.add(menuRequest);

            }
        });

        // 분식 버튼(btn_fast) 클릭 시
        btn_fast.setOnClickListener(new View.OnClickListener() {

            String Food_Theme = "fast";

            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            // 성공 메시지 출력. (확인용이고 나중에 삭제 예정)
                            if(success) {
                                Toast.makeText(getActivity(), "Add Fast", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getActivity(), "Add Fail", Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 Volley를 이용해서 요청을 보냄
                MenuRequest menuRequest = new MenuRequest(userID, Food_Theme, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                queue.add(menuRequest);

            }
        });


        return view;
    }
}
