package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        backPressCloseHandler = new BackPressCloseHandler(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.menu:
                        setFrag(1);
                        break;
                    case R.id.chart:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });

        // LoginActivity에서 보낸 Intent 받기.
        Intent Intent = getIntent();
        String userID = getIntent().getStringExtra("userID");
        String userEmail = getIntent().getStringExtra("userEmail");
        String userPass = getIntent().getStringExtra("userPass");

        // 번들 객체생성, 값 저장.
        Bundle bundle = new Bundle();
        bundle.putString("userID",userID);
        bundle.putString("userEmail",userEmail);
        bundle.putString("userPass",userPass);


        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();

        // fragment로 번들 전달.
        frag1.setArguments(bundle);
        frag2.setArguments(bundle);
        frag3.setArguments(bundle);

        // 시작 화면을 frag1(My Page)로 설정
        setFrag(0);
    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
        }
    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed(); }

}