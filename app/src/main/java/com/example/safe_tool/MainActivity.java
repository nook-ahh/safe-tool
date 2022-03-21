package com.example.safe_tool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.safe_tool.MenuItems.BaseInfoFragment;
import com.example.safe_tool.MenuItems.BodyDetailFragment;
import com.example.safe_tool.MenuItems.HeadFragment;
import com.example.safe_tool.MenuItems.LogFragment;
import com.example.safe_tool.reference.DashboardView;
import com.example.safe_tool.reference.HighlightCR;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;


public class MainActivity extends AppCompatActivity{
    public String s;
    public int driving=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(driving==1){
                    Toast.makeText(MainActivity.this, "请专心行车", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "菜单栏点击", Toast.LENGTH_SHORT).show();
                    showfragment(new menu());
                }
            }
            private void showfragment(Fragment fragment) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_content,fragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.setCustomAnimations(
                        R.anim.from_left,
                        R.anim.out_right

                );
                transaction.commit();
                findViewById(R.id.start_btn).setEnabled(false);
            }
        });
        /*--------------------------------------仪表盘----------------------------------------*/
        final DashboardView dashboardView1 = (DashboardView) findViewById(R.id.ds);
        dashboardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dashboardView1.setRealTimeValue(150.f, true, 100);
            }
        });

        List<HighlightCR> highlight1 = new ArrayList<>();
        highlight1.add(new HighlightCR(210, 60, Color.parseColor("#00b483")));
        highlight1.add(new HighlightCR(270, 60, Color.parseColor("#FFA000")));
        dashboardView1.setStripeHighlightColorAndRange(highlight1);

    }


    //启停click
    public void start_onclick(View view) {
        if(driving==1){
            driving=0;
            Toast.makeText(MainActivity.this, "stop点击", Toast.LENGTH_SHORT).show();
            Button btn=findViewById(R.id.start_btn);
            btn.setText(R.string.start);
        }else{
            driving=1;
            Toast.makeText(MainActivity.this, "start点击", Toast.LENGTH_SHORT).show();
            Button btn=findViewById(R.id.start_btn);
            btn.setText(R.string.stop);
        }

        Log.e("nook", "start_btn clicked" );
    }
    public void back_click(View view) {
        FragmentManager manager = getSupportFragmentManager();
        //通过FragmentManager管理器获取被标记的fragment
        Fragment fragment1 = manager.findFragmentById(R.id.fragment_content);
        if (fragment1 != null) {
            //isMarket = true;//这行忽略
            //开始事务 通过remove清除指定的fragment，并提交
            manager.beginTransaction().remove(fragment1).commit();
        }
        findViewById(R.id.start_btn).setEnabled(true);
    }

    public void menu_click(View view) {
        //back_click(view);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        Log.e("nook", view.toString().split("/")[view.toString().split("/").length-1]);
        switch (view.toString().split("/")[view.toString().split("/").length-1]){
            case "head_btn}":
                transaction.replace(R.id.fragment_content,new HeadFragment());
                break;
            case "log_btn}":
                transaction.replace(R.id.fragment_content,new LogFragment());
                break;
            case "mbtn1}":
                transaction.replace(R.id.fragment_content,new BaseInfoFragment());
                break;
            case "body_detail_btn}":
                transaction.replace(R.id.fragment_content,new BodyDetailFragment());
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.setCustomAnimations(
                R.anim.from_left,
                R.anim.out_right

        );
        transaction.commit();
        findViewById(R.id.start_btn).setEnabled(false);
    }

}
