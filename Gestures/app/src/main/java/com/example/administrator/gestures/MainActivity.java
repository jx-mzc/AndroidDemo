package com.example.administrator.gestures;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GestureOverlayView gestureOverlayView;
    private GestureLibrary gestureLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applypermission();
        gestureLibrary = GestureLibraries.fromFile("/storage/emulated/0/gestures");
        if (gestureLibrary.load()){
            Toast.makeText(MainActivity.this,"手势库加载成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,"手势库加载失败",Toast.LENGTH_SHORT).show();
        }

        //获取手势编辑组件后，设置相关参数
        gestureOverlayView = (GestureOverlayView)findViewById(R.id.gesture);
        gestureOverlayView.setGestureColor(Color.GREEN); //设置手势绘制的颜色
        gestureOverlayView.setGestureStrokeWidth(5);  //设置手势绘制的宽度
        //为手势完成事件绑定事件监听器
        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
                //识别用户刚绘制的手势
                ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
                ArrayList<String> result = new ArrayList<String>();
                //遍历所有找到的Prediction对象
                Prediction maxPre= predictions.get(0);
                for (Prediction pred : predictions){
                    if(pred.score > maxPre.score) {
                        maxPre = pred;
                    }
                }
                result.add("匹配的手势为"+ maxPre.name);
                if (result.size() > 0){
                    ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<Object>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,result.toArray());
                    new AlertDialog.Builder(MainActivity.this).setAdapter(arrayAdapter,null).setPositiveButton("确定",null).show();
                }else {
                    Toast.makeText(MainActivity.this,"无法找到匹配的手势",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void applypermission(){
        if(Build.VERSION.SDK_INT>=23){
            //检查是否已经给了授权
            int checkpermission = ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE);
            if(checkpermission != PackageManager.PERMISSION_GRANTED){//没有授权
                Log.e("permission","动态申请");
                //参数分别是当前活动，权限字符串数组，requestcode
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        //grantResults数组与权限字符串数组对应，里面存放权限申请结果
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this,"已授权",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"拒绝授权",Toast.LENGTH_SHORT).show();
        }
    }
}
