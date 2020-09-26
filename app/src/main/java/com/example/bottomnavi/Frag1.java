package com.example.bottomnavi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Frag1 extends Fragment {

    private View view;
    private Button btn_logout,btn_leave,btn_inquire;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        btn_logout = (Button) view.findViewById(R.id.btn_logout);
        btn_leave = (Button) view.findViewById(R.id.btn_leave);
        btn_inquire = (Button) view.findViewById(R.id.btn_inquire);
        context = container.getContext();

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
        //MainActivity에서 전달한 번들 저장
        Bundle bundle = getArguments();
        final String userID = bundle.getString("userID");
        String userEmail = bundle.getString("userEmail");
        final String userPass = bundle.getString("userPass");

        btn_inquire.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent =new Intent(getActivity(),privateAskActivity.class);
                startActivity(intent);

            }
        });
        //회원탈퇴 버튼 구현.
        btn_leave.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
               builder.setTitle("정말로 삭제 하시겠습니까?");
               builder.setMessage("복구가 불가능 합니다.");
               //경고창에서 예를 눌렀을 경우.
               builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                           Response.Listener<String> responseListener = new Response.Listener<String>() {
                               @Override
                               public void onResponse(String response) {
                                   try {
                                       JSONObject jsonObject = new JSONObject(response);
                                       boolean success = jsonObject.getBoolean("success");

                                       if(success) {   // 성공
                                           Toast.makeText(context, "회원탈퇴 했습니다..", Toast.LENGTH_SHORT).show();
                                           Intent intent =new Intent(getActivity(),LoginActivity.class);
                                           startActivity(intent);
                                       } else {        // 실패
                                           Toast.makeText(context, "회월탈퇴를 실패했습니다.", Toast.LENGTH_SHORT).show();
                                       }

                                   } catch (JSONException e) {
                                       e.printStackTrace();
                                   }
                               }
                           };
                           secedeUserRequest secedeRequest = new secedeUserRequest(userID, userPass, responseListener);
                           RequestQueue queue = Volley.newRequestQueue(getActivity());
                           queue.add(secedeRequest);


                       }

               });
               //경고창에서 아니오를 눌렀을경우
               builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(context, "회원탈퇴를 취소 했습니다.", Toast.LENGTH_SHORT).show();

                   }
               });
               builder.create().show();
           }
        });






        return view;


    }
}
