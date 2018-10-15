package com.example.administrator.choseimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button choseImg;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choseImg = (Button)findViewById(R.id.chose_btn);
        choseImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.chose_btn:
                Intent intent = new Intent(MainActivity.this,GridViewImages.class);
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    image = (ImageView)findViewById(R.id.image);
                    image.setImageResource(Integer.parseInt(data.getStringExtra("imageId")));
                }
                break;
            default:
                break;
        }
    }
}
