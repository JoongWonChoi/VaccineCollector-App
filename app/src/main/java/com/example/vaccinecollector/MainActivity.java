package com.example.vaccinecollector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText input; //EditText클래스 객체 생성
    Button btn; //Button 객체 생성
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //savedInstanceState 파라미터를 받아 activity 생성
        setContentView(R.layout.activity_main); //Resource/layout 내에 생성한 activity_main.xml 파일 매핑해서 layout 설정
        input = (EditText)findViewById(R.id.inputNumber); //Resource내에 지정된 'activity_main'의 'inputnumber' 의 id를 찾아서(findViewById) EditText로 형변환 후 EditText의 객체 input에 대입
        btn = (Button)findViewById(R.id.btn); //마찬가지로 btn의 아이디를 찾은 후(findViewById) Button의 객체 btn에 대입
        //Lister : 안드로이드에서 발생하는 event 를 들어주는 객체
        btn.setOnClickListener(new View.OnClickListener(){ //지정된 btn 객체에 클릭 event Listener 지정해주기
            @Override
            public void onClick(View view) {//view 가 클릭되면 호출. View의 객체 view를 생성하고 이에 대한 event가 발생하면 기능하는 함수?
                number = Integer.parseInt(input.getText().toString());
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                intent.putExtra("input", number);
                startActivity(intent);
                finish();
            }
        });
    }
}