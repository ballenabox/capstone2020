package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id, et_pass;
    private Button btn_login, btn_register;
    private CheckBox cb_save;
    SharedPreferences setting;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        et_id = (EditText) findViewById(R.id.et_id);
        et_pass = (EditText) findViewById(R.id.et_pass);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        cb_save = (CheckBox) findViewById(R.id.cb_save);
        setting = getSharedPreferences("setting", 0);
        editor = setting.edit();

        // 자동 로그인
        if(setting.getBoolean("enable", false)) {
             et_id.setText(setting.getString("id", ""));
             et_pass.setText(setting.getString("pw", ""));
            cb_save.setChecked(true);

            // 현재 작동하지 않음
            btn_login.performClick();
        }


        // 회원가입 버튼을 누를 시 실행
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // 로그인 버튼
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success) {   // 로그인 성공
                                String userID = jsonObject.getString("User_ID");
                                String userEmail = jsonObject.getString("User_Email");
                                String userPass = jsonObject.getString("Password");
                                /*
                                String menuId = jsonObject.getString("menu_id");
                                String foodTheme = jsonObject.getString("Food_Theme");
                                Integer menuCount = jsonObject.getInt("Count");
                                 */

                                Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userEmail", userEmail);
                                intent.putExtra("userPass", userPass);
                                /*
                                intent.putExtra("menuId",menuId);
                                intent.putExtra("foodTheme",foodTheme);
                                intent.putExtra("menuCount",menuCount);

                                 */
                                startActivity(intent);
                            } else {        // 로그인 실패
                                Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }
        });

        // 로그인 유지 CheckBox
        cb_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    String id = et_id.getText().toString();
                    String pw = et_pass.getText().toString();

                    editor.putString("id", id);
                    editor.putString("pw", pw);
                    editor.putBoolean("enable", true);
                    editor.commit();
                } else {
                    Toast.makeText(getApplicationContext(), "자동 로그인 해제", Toast.LENGTH_SHORT).show();
                    editor.remove("id");
                    editor.remove("pw");
                    editor.remove("enable");
                    editor.clear();
                    editor.commit();
                }
            }
        });

    }
}