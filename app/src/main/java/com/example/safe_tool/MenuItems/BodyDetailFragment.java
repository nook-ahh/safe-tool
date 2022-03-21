package com.example.safe_tool.MenuItems;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.safe_tool.MainActivity;
import com.example.safe_tool.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class BodyDetailFragment extends Fragment {
    Double[] s=new Double[8];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_body_detail, container, false);
        //spinner监听器
        Spinner[] spinners=new Spinner[8];
        spinners[0]=v.findViewById(R.id.low_tem_selecter);
        spinners[1]=v.findViewById(R.id.heigh_tem_selecter);
        spinners[2]=v.findViewById(R.id.low_blood_selecter1);
        spinners[3]=v.findViewById(R.id.low_blood_selecter2);
        spinners[4]=v.findViewById(R.id.heigh_blood_selecter1);
        spinners[5]=v.findViewById(R.id.heigh_blood_selecter2);
        spinners[6]=v.findViewById(R.id.low_heart_selecter);
        spinners[7]=v.findViewById(R.id.heigh_heart_selecter);
        //请在此处为spinner赋之前设置好的值
        spinners[0].setSelection(2);
        for(int i=0;i<=7;i++){
            spinners[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.e("nook", "onItemSelected: "+Double.parseDouble(parent.getItemAtPosition(position).toString()));
                    switch (parent.getId()){
                        //low_heigh_tem,收缩压，舒张压，心跳
                        case R.id.low_tem_selecter:
                            s[0]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        case R.id.heigh_tem_selecter:
                            s[1]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        case R.id.low_blood_selecter1:
                            s[2]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        case R.id.low_blood_selecter2:
                            s[3]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        case R.id.heigh_blood_selecter1:
                            s[4]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        case R.id.heigh_blood_selecter2:
                            s[5]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        case R.id.low_heart_selecter:
                            s[6]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        case R.id.heigh_heart_selecter:
                            s[7]=Double.parseDouble(parent.getItemAtPosition(position).toString());
                            break;
                        default:
                            break;
                    }

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    //未选中时候的操作
                }
            });
        }

        Button submit_btn=v.findViewById(R.id.body_detail_submit);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //请更换此处代码为保存身体数据设置
                Log.e("nook", "submit: "+ Arrays.toString(s));
            }
        });
        Button reset_btn=v.findViewById(R.id.reset_btn);
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog aldg;
                AlertDialog.Builder adBd=new AlertDialog.Builder(getActivity());
                adBd.setMessage("确定要重置吗？");
                adBd.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //请更换此处代码为身体数据设置为标准值
                        Toast.makeText(getActivity(), "重置", Toast.LENGTH_SHORT).show();
                    }
                });
                adBd.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                aldg=adBd.create();
                aldg.show();
            }
        });
        return v;
    }


}
