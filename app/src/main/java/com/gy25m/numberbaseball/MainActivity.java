package com.gy25m.numberbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button btn;
    TextView tv,start;
    int com1,com2,com3;
    int st=0;
    int ball=0;
    StringBuffer sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Random rnd=new Random();
        com1= rnd.nextInt(9)+1;
        com2= rnd.nextInt(9)+1;
        com3= rnd.nextInt(9)+1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        tv=findViewById(R.id.tv);
        start=findViewById(R.id.start);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String s1 = et1.getText().toString();
                    String s2 = et2.getText().toString();
                    String s3 = et3.getText().toString();
                    int a1 = Integer.parseInt(s1);
                    int a2 = Integer.parseInt(s2);
                    int a3 = Integer.parseInt(s3);
                    if (com1 == a1) st++;
                    if (com2 == a1 || com3 == a1) ball++;
                    if (com2 == a2) st++;
                    if (com1 == a2 || com3 == a2) ball++;
                    if (com3 == a3) st++;
                    if (com1 == a3 || com2 == a3) ball++;
                    tv.setText(st + "스트라이크" + ball + "볼");

                    if(st==3) start.setText("정답입니다!^^");
                    st = 0;
                    ball = 0;


                }

            });

    }
}