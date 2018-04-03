package com.example.admin.ch6_3_3;

import android.content.pm.ActivityInfo;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity{
    //implements 目的將設計與實作分開，implements 設計一個規範，例如產品有哪些功能、給哪個廠商
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton toggle = (ToggleButton)findViewById(R.id.toggleButton); //找到id為toggleButton的按鈕
        toggle.setOnCheckedChangeListener(listener); //綁定其監聽事件
        Button count = (Button)findViewById(R.id.btn_c);
        count.setOnClickListener(listener1);

    }

    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener(){
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            if(isChecked){ //當按鈕開關 開啟
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //畫面為橫向
            }else{ //當按鈕開關 關閉
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //畫面為直向
            }
        }
    };

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void onClick(View v){
            double height,weight,bmi; //宣告double型態的變數
            TextView edtheight = (TextView)findViewById(R.id.edt_h);
            TextView edtweight = (TextView)findViewById(R.id.edt_w);
            height = Double.parseDouble(edtheight.getText().toString());
            weight = Double.parseDouble(edtweight.getText().toString());

            //計算bmi
            height = height / 100;
            bmi = weight / (height*height);

            TextView output = (TextView)findViewById(R.id.edt_result);
            output.setText(Double.toString(bmi));
        }
    };


}
