package com.example.administrator.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView)findViewById(R.id.lv);
        Button apply = (Button)findViewById(R.id.apply);
        String[] name = new String[]{"赵","钱","孙","李","周"};
        List<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
        for (int i=0;i<name.length;i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("name",name[i]);
            listitem.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitem,R.layout.item,new String[]{"name"},new int[]{R.id.name});
        listView.setAdapter(simpleAdapter);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mes = "";
                for (int i=0;i<listView.getChildCount();i++){
                    LinearLayout layout=(LinearLayout)listView.getChildAt(i);
                    HashMap<String,Object> map=(HashMap<String,Object>)listView.getItemAtPosition(i);
                    mes=mes+map.get("name").toString()+"：";
                    RatingBar ratingBar=(RatingBar)layout.findViewById(R.id.rb);
                    float dj=ratingBar.getRating();
                    mes = mes+Float.toString(dj)+"\n";
                }
                Toast.makeText(MainActivity.this,mes,Toast.LENGTH_LONG).show();
            }
        });
    }

}
