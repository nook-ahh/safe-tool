package com.example.safe_tool.MenuItems;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.safe_tool.R;


public class BaseInfoFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_base_info, container, false);
        Button submit=v.findViewById(R.id.base_info_submit);
        final EditText linkman_name_et=v.findViewById(R.id.linkman_name);
        final EditText linkman_no_et=v.findViewById(R.id.linkman_no);
        final EditText driver_name_et=v.findViewById(R.id.driver_name);
        //请在此处插入原个人信息代码
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String linkman_name=linkman_name_et.getText().toString();
                String linkman_no=linkman_no_et.getText().toString();
                String driver_name=driver_name_et.getText().toString();
                //请在此处插入保存个人信息代码
            }
        });
        return v;
    }
}
