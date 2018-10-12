package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String op1 = "",op2 = "";
    private EditText etInOut=null,etShowInfo=null;
    private int pointsign = 0;
    private Button bt0=null,
            bt1=null,
            bt2=null,
            bt3=null,
            bt4=null,
            bt5=null,
            bt6=null,
            bt7=null,
            bt8=null,
            bt9=null,
            btC=null,
            btequal=null,
            btplus=null,
            btdec=null,
            btmultiple=null,
            btdiv=null,
            btdel=null,
            btminus=null,
            btpoint=null;
    private double x = 0.0,y = 0.0,result = 0.0;
    private int sign = 0;
    private String operator = "";
    private void click(){
        etShowInfo = (EditText) findViewById(R.id.edit2);
        etInOut = (EditText) findViewById(R.id.edit1);
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        bt5 = (Button) findViewById(R.id.button5);
        bt6 = (Button) findViewById(R.id.button6);
        bt7 = (Button) findViewById(R.id.button7);
        bt8 = (Button) findViewById(R.id.button8);
        bt9 = (Button) findViewById(R.id.button9);
        bt0 = (Button) findViewById(R.id.button0);
        btplus = (Button) findViewById(R.id.buttonplus);
        btdec = (Button) findViewById(R.id.buttondec);
        btmultiple = (Button) findViewById(R.id.buttonmultiple);
        btdiv = (Button) findViewById(R.id.buttondiv);
        btequal = (Button) findViewById(R.id.buttonequal);
        btC = (Button) findViewById(R.id.buttonC);
        btdel=(Button)findViewById(R.id.buttondel);
        btpoint=(Button)findViewById(R.id.buttonpoint);
        btminus=(Button)findViewById(R.id.buttonminus);

        String i = Double.toString(x);
        etInOut.setText(i);

        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("1");
            }
        });
        bt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("2");
            }
        });
        bt3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("3");
            }
        });
        bt4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("4");
            }
        });
        bt5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("5");
            }
        });
        bt6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("6");
            }
        });
        bt7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("7");
            }
        });
        bt8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("8");
            }
        });
        bt9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("9");
            }
        });
        bt0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("0");
            }
        });
        btminus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext("-1");
            }
        });
        btC.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clean();
            }
        });
        btplus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperator("+");
            }
        });
        btdec.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperator("-");
            }
        });
        btmultiple.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperator("×");
            }
        });
        btdiv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperator("÷");
            }
        });
        btpoint.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pointsign == 0 && sign !=0)
                    settext(".");
            }
        });

        btequal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                equal();
            }
        });
        btdel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    private void setoperator(String op) {
        if (pointsign == 1){
            pointsign = 0;
        }
        if (sign == 1||sign == 0) {
            operator = op;
            etShowInfo.setText(etInOut.getText() + op);
            etInOut.setText("");
            sign = 2;
        }
    }


    private void equal() {
        if (operator.equals("+") && sign == 2) {
            result = x + y;
            etShowInfo.setText(x + operator + y);
            etInOut.setText("" + result);
            operator = "";
            x = result;
        }
        if (operator.equals("-") && sign == 2) {
            result = x - y;
            etShowInfo.setText(x + operator + y);
            etInOut.setText("" + result);
            operator = "";
            x = result;
        }
        if (operator.equals("×") && sign == 2) {
            result = x * y;
            etShowInfo.setText(x + operator + y);
            etInOut.setText("" + result);
            operator = "";
            x = result;
        }
        if (operator.equals("÷") && sign == 2) {
            if(y !=0){
                result = x / y;
            }
            else{
                etInOut.setText("非法计算");
                return;
            }
            etShowInfo.setText(x + operator + y);
            etInOut.setText("" + result);
            operator = "";
            x = result;
        }
        sign = 0;
        op1 = "";
        op2 = "";
    }


    private void settext(String input) {
        double i;
        if (input.equals("-1")){
            if(sign == 0 || sign == 1){
                if(op1.equals("")) return;
                i = Double.parseDouble(op1);
                if (op1.startsWith("-1"))
                    op1 = op1.substring(1);
                else
                    op1 = "-" + op1;
                etInOut.setText(op1);
                x = -i;
            }
            if(sign == 2){
                if(op2.equals("")) return;
                i = Double.parseDouble(op2);
                if (op2.startsWith("-1"))
                    op2 = op2.substring(1);
                else
                    op2 = "-" + op2;
                etInOut.setText(op2);
                y = -i;
            }
        }
       else if (sign == 0 || sign == 1) {
            op1 = op1 + input;
            i = Double.parseDouble(op1);
            if(i<3.4028235E38) {
                etInOut.setText(op1);
                x =  i;
                sign = 1;
                if (input.equals("."))
                    pointsign = 1;
            }else{
                Toast.makeText(MainActivity.this,"输入数据超出最大可计算值，请重新输入！",
                        Toast.LENGTH_LONG).show();
                op1 = "";
                etInOut.setText("0.0");
                x=0.0;
            }
        }
        else if (sign == 2){
                op2 = op2 +input;
                i = Double.parseDouble(op2);
                if(i<3.4028235E38) {
                    etInOut.setText(op2);
                    y =  i;
                    if (input.equals("."))
                        pointsign = 1;
                }else{
                    Toast.makeText(MainActivity.this,"输入数据超出最大可计算值，请重新输入！",
                            Toast.LENGTH_LONG).show();
                    op2 = "";
                    etInOut.setText("0.0");
                    y=0.0;
                }
        }
    }

    public void clean() {
        etInOut.setText("0.0");
        etShowInfo.setText("");
        x = 0.0;
        y = 0.0;
        op1 = "";
        op2 = "";
        result = 0.0;
        sign = 0;
        pointsign = 0;
    }

    private  void delete(){
        double i;
        if (sign == 1){
            if (op1.length() - 1 >0){
                char pointcheck=op1.charAt(op1.length() - 1);
                if (pointcheck == '.') pointsign=0;
                op1 = op1.substring(0,op1.length() - 1);
                etInOut.setText(op1);
                i = Double.parseDouble(op1);
                x = i;
            }else{
                op1 = "0";
                etInOut.setText(op1);
                i = Double.parseDouble(op1);
                x = i;
                op1 = "";
                sign = 0;
            }
        }
        if (sign == 2){
                if (op2.length() - 1 >0){
                    char pointcheck=op2.charAt(op2.length() - 1);
                    if (pointcheck == '.') pointsign=0;
                    op2 = op2.substring(0,op2.length() - 1);
                    etInOut.setText(op2);
                    i = Double.parseDouble(op2);
                    y = i;
                }else{
                    op2 = "0";
                    etInOut.setText(op2);
                    i = Double.parseDouble(op2);
                    y = i;
                    op2 = "";
                    sign = 0;
                }
            }
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click();
    }
}
