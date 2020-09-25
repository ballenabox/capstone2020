package com.example.bottomnavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        //MainActivity에서 전달한 번들 저장
        Bundle bundle = getArguments();
        String userID = bundle.getString("userID");
        String userEmail = bundle.getString("userEmail");
        String userPass = bundle.getString("userPass");
        return view;
    }
}
