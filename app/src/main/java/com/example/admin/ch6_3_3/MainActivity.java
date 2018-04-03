package com.example.admin.ch6_3_3;

import android.content.pm.ActivityInfo;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    //implements 目的將設計與實作分開，implements 設計一個規範，例如產品有哪些功能、給哪個廠商
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggle = (ToggleButton)findViewById(R.id.toggleButton); //找到id為toggleButton的按鈕
        toggle.setOnCheckedChangeListener(this); //綁定其監聽事件
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(isChecked){ //當按鈕開關 開啟
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //畫面為橫向
        }else{ //當按鈕開關 關閉
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //畫面為直向
        }
    }
}
