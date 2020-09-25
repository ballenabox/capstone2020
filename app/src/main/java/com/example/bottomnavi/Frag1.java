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
    private Button btn_logout,btn_leave,btn_inquire;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        btn_logout = (Button) view.findViewById(R.id.btn_logout);
        btn_leave = (Button) view.findViewById(R.id.btn_leave);
        btn_inquire = (Button) view.findViewById(R.id.btn_inquire);

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

        btn_inquire.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent =new Intent(getActivity(),privateAskActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }
}
