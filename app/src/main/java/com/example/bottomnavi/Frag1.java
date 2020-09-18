package com.example.bottomnavi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {

    private View view;
    private TextView tv_id, tv_pass, tv_email;
    private Button btn_logout;
    static final String[] LIST_HOME = {"로그아웃","1 : 1 문의하기","회원탈퇴"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,LIST_HOME);
        btn_logout = (Button) view.findViewById(R.id.btn_logout);
        ListView home_listview1= (ListView) view.findViewById(R.id.home_listview1) ;
        home_listview1.setAdapter(adapter);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    SharedPreferences setting = getActivity().getSharedPreferences("setting", 0);
                    SharedPreferences.Editor editor = setting.edit();
                    editor.clear();
                    editor.commit();
                    Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }
        });

        home_listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                String strText = (String) parent.getItemAtPosition(position);
            }

        });

        return view;
    }
}
