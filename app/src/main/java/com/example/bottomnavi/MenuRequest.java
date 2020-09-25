package com.example.bottomnavi;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MenuRequest extends StringRequest {

    // 서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://211.192.245.92:81/test2/Add.php";
    private Map<String, String> map;

    public MenuRequest(String User_ID, String Food_Theme, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("User_ID", User_ID);
        map.put("Food_Theme", Food_Theme);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}