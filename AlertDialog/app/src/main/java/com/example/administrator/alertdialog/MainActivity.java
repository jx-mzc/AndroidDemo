package com.example.administrator.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);
        bt4 = (Button)findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:
                AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(MainActivity.this);
                alertDialog1.setIcon(R.drawable.ic_launcher_background)
                .setTitle("系统提示：")
                .setMessage("带取消、中立和确定按钮的对话框！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"您单击了确定按钮",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"您单击了取消按钮",Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"您单击了中立按钮",Toast.LENGTH_LONG).show();
                    }
                }).create();
                alertDialog1.show();
                break;
            case R.id.bt2:
                final String[] items1 = new String[]{"跑步","羽毛球","乒乓球","网球","体操"};
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(MainActivity.this);
                alertDialog2.setIcon(R.drawable.ic_launcher_background)
                            .setTitle("请选择你喜欢的项目：")
                            .setItems(items1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this,"您选择了"+items1[i],Toast.LENGTH_LONG).show();
                                }
                            }).create();
                alertDialog2.show();
                break;
            case R.id.bt3:
                final String[] items2 = new String[]{"标准","无声","会议","户外","离线"};
                AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(MainActivity.this);
                alertDialog3.setIcon(R.drawable.ic_launcher_background)
                            .setTitle("请选择要使用的情景模式：")
                            .setSingleChoiceItems(items2, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this,"您选择了"+items2[i],Toast.LENGTH_LONG).show();
                                }
                            })
                            .setPositiveButton("确定",null)
                            .create();
                alertDialog3.show();
                break;
            case R.id.bt4:
                final boolean[] checkedItems = new boolean[]{false,true,false,true,false};
                final String[] items3 =new String[]{"植物大战僵尸","愤怒的小鸟","泡泡龙","开心农场","超级玛丽"};
                AlertDialog.Builder alertDialog4 = new AlertDialog.Builder(MainActivity.this);
                alertDialog4.setIcon(R.drawable.ic_launcher_background)
                            .setTitle("请选择您喜爱的游戏：")
                            .setMultiChoiceItems(items3, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                        checkedItems[i] = b;
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String result = "";
                                    for (int k=0;k<checkedItems.length;k++){
                                        if (checkedItems[k]){
                                            result+=items3[k]+"、";
                                        }
                                    }
                                    if (!"".equals(result)){
                                        result = result.substring(0,result.length()-1);
                                        Toast.makeText(MainActivity.this,"您选择了["+result+"]",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }).create();
                alertDialog4.show();
                break;
            default:
                break;
        }
    }
}
