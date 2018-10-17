package com.example.administrator.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getGroupId() == R.id.setting){
            if (item.isChecked()){
                item.setChecked(false);
            }else {
                item.setChecked(true);
            }
        }
        if (item.getItemId()!=R.id.item2){
            Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
