package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class privateAskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.private_ask);
        Button btn_cancel = findViewById(R.id.btn_cancel);
        Button btn_sending = findViewById(R.id.btn_sending);
        final EditText et_title1 = findViewById(R.id.et_title1);
        final EditText et_body1 = findViewById(R.id.et_body1);
        EditText et_email1;



/*
        // 자신의 이메일 자동으로 채워넣기 기능.
        Intent intent = getIntent();
        String stringEmail = intent.getStringExtra("userEmail");
        et_email1 = findViewById(R.id.et_email1);
        et_email1.setText(stringEmail);
        */

        // 취소 버튼
        btn_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                finish();
            }
        });

        // 보내기 버튼을 클릭하였을때.
        btn_sending.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                // 관리자 이메일
                String to = "wjdtj9656@gmail.com";
                // 제목
                String subject = et_title1.getText().toString();
                // 내용
                String message = et_body1.getText().toString();

                // 제목을 미입력시.
                if(TextUtils.isEmpty(subject)){
                    Toast.makeText(getApplicationContext(), "제목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 내용을 미입력시.
                if(TextUtils.isEmpty(message)){
                    Toast.makeText(getApplicationContext(), "문의 내용을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(getIntent().createChooser(email, "이메일 client 선택 :"));
            }
        });
    }
}