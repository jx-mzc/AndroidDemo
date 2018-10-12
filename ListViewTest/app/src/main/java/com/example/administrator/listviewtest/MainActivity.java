package com.example.administrator.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Set> setList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSets();//初始化设置数据
        SetAdapter adapter = new SetAdapter(MainActivity.this,R.layout.set_item,setList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initSets() {

        int[] images = {R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,
                R.drawable.img06,R.drawable.img07,R.drawable.img08};
        String[] set_name = getResources().getStringArray(R.array.set_name);
        for (int i=0;i<set_name.length;i++){
            Set sets = new Set(set_name[i],images[i]);
            setList.add(sets);
        }

//            Set set1 = new Set("保密设置",R.drawable.img01);
//            setList.add(set1);
//            Set set2 = new Set("安全",R.drawable.img02);
//            setList.add(set2);
//            Set set3 = new Set("系统设置",R.drawable.img03);
//            setList.add(set3);
//            Set set4 = new Set("上网",R.drawable.img04);
//            setList.add(set4);
//            Set set5 = new Set("我的文档",R.drawable.img05);
//            setList.add(set5);
//            Set set6 = new Set("GPS导航",R.drawable.img06);
//            setList.add(set6);
//            Set set7 = new Set("我的音乐",R.drawable.img07);
//            setList.add(set7);
//            Set set8 = new Set("E-mail",R.drawable.img08);
//            setList.add(set8);
        }
}
