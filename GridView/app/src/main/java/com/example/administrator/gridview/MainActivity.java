package com.example.administrator.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gridView=(GridView)findViewById(R.id.gv);
        int[] imgId = new int[]{R.drawable.iv_icon_1,R.drawable.iv_icon_2,R.drawable.iv_icon_3,
                                R.drawable.iv_icon_4,R.drawable.iv_icon_5,R.drawable.iv_icon_6,
                                R.drawable.iv_icon_7,R.drawable.iv_icon_1,R.drawable.iv_icon_2,
                                R.drawable.iv_icon_3,R.drawable.iv_icon_4,R.drawable.iv_icon_5,};
        String[] text = new String[]{"一","二","三","四","五","六","七","八","九","十","十一","十二"};
        List<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
        for (int i=0;i<text.length;i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("imgId",imgId[i]);
            map.put("text",text[i]);
            listitem.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitem,R.layout.item,new String[]{"imgId","text"},
                                                        new int[]{R.id.img_icon,R.id.txt_icon});
        gridView.setAdapter(simpleAdapter);
    }
}
