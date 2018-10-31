package com.example.administrator.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"BookStore",null,1);
        Button createDatabase = (Button)findViewById(R.id.create_database);
        Button addData = (Button)findViewById(R.id.add_data);
        Button updateData = (Button)findViewById(R.id.update_data);
        Button deleteData = (Button)findViewById(R.id.delete_data);
        Button queryData = (Button)findViewById(R.id.query_data);
        createDatabase.setOnClickListener(this);
        addData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
        queryData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        switch (v.getId()){
            case R.id.create_database:
                dbHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                //开始组装第一条数据
                values.put("name","达芬奇密码");
                values.put("author","Dan Brown");
                values.put("pages",456);
                values.put("price",32.98);
                database.insert("Book",null,values);//插入第一条数据
                //database.execSQL("insert into Book (name,author,pages,price) values(?,?,?,?)",new String[]{"达芬奇密码","Dan Brown","456","32.98"});
                values.clear();
                values.put("name","消失的符号");
                values.put("author","Dan Brown");
                values.put("pages",510);
                values.put("price",42.98);
                database.insert("Book",null,values);//插入第二条数据
                //database.execSQL("insert into Book (name,author,pages,price) values(?,?,?,?)",new String[]{"消失的符号","Dan Brown","510","42.98"});
                values.clear();
                break;
            case R.id.update_data:
                values.put("price",46.99);
                database.update("Book",values,"name = ?",new String[]{"达芬奇密码"});
                //database.execSQL("update Book set price = ? where name = ?",new String[]{"46.99","达芬奇密码"});
                values.clear();
                break;
            case R.id.delete_data:
                database.delete("Book","pages > ?",new String[]{"500"});
                //database.execSQL("delete from Book where pages > ?",new String[]{"500"});
                break;
            case R.id.query_data:
                Cursor cursor = database.query("Book",null,null,null,null,null,null);
                //cursor = database.rawQuery("select * from Book",null);
                if (cursor.moveToFirst()){
                    do {
                        //遍历Cursor对象，取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "书名是"+name);
                        Log.d("MainActivity", "作者是"+author);
                        Log.d("MainActivity", "页数是"+pages);
                        Log.d("MainActivity", "价格是"+price);
                    }while (cursor.moveToNext());
                }
                cursor.close();
                break;
            default:
                break;
        }

    }
}
