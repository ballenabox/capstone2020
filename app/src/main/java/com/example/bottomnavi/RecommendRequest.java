package com.example.bottomnavi;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RecommendRequest extends StringRequest {

    // 서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://118.67.129.31:80/projectPHP/Recommendation.php";
    private Map<String, String> map;

    public RecommendRequest(String User_ID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("User_ID", User_ID);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
