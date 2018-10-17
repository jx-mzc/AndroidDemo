package com.example.administrator.backgroundcolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] tvID = new int[]{R.id.str1,R.id.str2,R.id.str3,R.id.str4,R.id.str5,R.id.str6,R.id.str7};
        int[] tvColor = new int[]{R.color.color1,R.color.color2,R.color.color3,R.color.color4,
                                    R.color.color5,R.color.color6,R.color.color7};
        for (int i=0;i<7;i++){
            TextView tv = (TextView)findViewById(tvID[i]);
            tv.setGravity(Gravity.CENTER);  //设置文字居中显示
            tv.setBackgroundColor(getResources().getColor(tvColor[i]));//为TextView组件设置背景颜色
            tv.setHeight((int)getResources().getDimension(R.dimen.basic)*(i+2)/2);
        }
    }
}
