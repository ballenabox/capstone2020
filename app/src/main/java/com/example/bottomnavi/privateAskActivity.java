package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class privateAskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.private_ask);
        Button btn_cancle = findViewById(R.id.button5);
        Button btn_sending = findViewById(R.id.button4);
        final EditText et_title1 = (EditText)findViewById(R.id.et_title1);
        final EditText et_body1 = (EditText)findViewById(R.id.et_body1);
        EditText et_email1;



/*
//자신의 이메일 자동으로 채워넣기 기능.
        Intent intent = getIntent();
        String stringEmail = intent.getStringExtra("userEmail");
        et_email1 = findViewById(R.id.et_email1);
        et_email1.setText(stringEmail);
        */

        btn_cancle.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                finish();
            }
        });
        btn_sending.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                String to = "wjdtj9656@gmail.com";
                String subject = et_title1.getText().toString();
                String message = et_body1.getText().toString();

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