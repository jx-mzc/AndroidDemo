package com.example.administrator.choseimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewImages extends AppCompatActivity implements AdapterView.OnItemClickListener{


    private int[] imgId = new int[]{R.drawable.iv_icon_1,R.drawable.iv_icon_2,R.drawable.iv_icon_3,
            R.drawable.iv_icon_4,R.drawable.iv_icon_5,R.drawable.iv_icon_6,
            R.drawable.iv_icon_7,R.drawable.iv_icon_1,R.drawable.iv_icon_2,
            R.drawable.iv_icon_3,R.drawable.iv_icon_4,R.drawable.iv_icon_5,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_images);
        final GridView gridView=(GridView)findViewById(R.id.gv_img);

        List<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
        for (int i=0;i<imgId.length;i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("imgId",imgId[i]);
            listitem.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitem,R.layout.item,new String[]{"imgId"},
                new int[]{R.id.item_img});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent();
        intent.putExtra("imageId",String.valueOf(imgId[i]));
        setResult(RESULT_OK,intent);
        finish();
    }
}
