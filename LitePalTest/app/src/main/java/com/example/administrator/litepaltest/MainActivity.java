package com.example.administrator.litepaltest;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Book book = new Book();
        switch (v.getId()){
            case R.id.create_database:
                LitePal.getDatabase();
                break;
            case  R.id.add_data:
                book.setName("达芬奇密码");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(36.99);
                book.setPress("Unknow");
                book.save();
                book = new Book();
                book.setName("消失的符号");
                book.setAuthor("Dan Brown");
                book.setPages(510);
                book.setPrice(42.98);
                book.setPress("Unknow");
                book.save();
                book = new Book();
                break;
            case R.id.update_data:
                book.setPrice(32.99);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?","达芬奇密码","Dan Brown");
                book = new Book();
                break;
            case R.id.delete_data:
                LitePal.deleteAll(Book.class,"price < ?","40");
                break;
            case R.id.query_data:
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book1:books){
                    Log.d("MainActivity","书名是："+book1.getName());
                    Log.d("MainActivity","作者是："+book1.getAuthor());
                    Log.d("MainActivity","页数是："+book1.getPages());
                    Log.d("MainActivity","价格是："+book1.getPrice());
                    Log.d("MainActivity","出版社是："+book1.getPress());
                }
                break;
        }
    }
}
