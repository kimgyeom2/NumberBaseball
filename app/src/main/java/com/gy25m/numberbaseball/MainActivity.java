package com.gy25m.numberbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
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

        ArrayList<Integer> nums=new ArrayList<>();
        for(int n=0;n<=9;n++) nums.add(n);
        Collections.shuffle(nums);
// 스크롤뷰 추가
// 스트링 버퍼 추가
        //글자수 제한 토스트 추가
        //포커스이동 리스너 추가

//        Random rnd=new Random();
//        com1= rnd.nextInt(9)+1;
//        com2= rnd.nextInt(9)+1;
//        com3= rnd.nextInt(9)+1;
        com1=nums.get(0);
        com2=nums.get(1);
        com3=nums.get(2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        tv=findViewById(R.id.tv);
        start=findViewById(R.id.start);
        StringBuffer sb=new StringBuffer();

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et1.clearFocus();
                et2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et2.clearFocus();
                et3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (et1.getText().toString().length()==1 && et2.getText().toString().length()==1 &&et3.getText().toString().length()==1 ) {
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
                        sb.append(st).append("스트라이크").append(ball).append("볼\n");
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        tv.setText(sb.toString());

                        if (st == 3) start.setText("정답입니다!^^");
                        st = 0;
                        ball = 0;
                    }else{
                        Toast.makeText(MainActivity.this, "모든 칸을 입력하세요", Toast.LENGTH_SHORT).show();
                    }


                }

            });

    }
}