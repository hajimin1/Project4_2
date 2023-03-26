package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch chk;
    RadioGroup rGroup1;
    RadioButton q, r, s;
    Button Start, Finish;
    ImageView imgAnd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView)findViewById(R.id.Text1);
        chk = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView)findViewById(R.id.Text2);
        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        q = (RadioButton)findViewById(R.id.Q);
        r = (RadioButton)findViewById(R.id.R);
        s = (RadioButton)findViewById(R.id.S);
        Start = (Button)findViewById(R.id.start);
        Finish = (Button)findViewById(R.id.finish);
        imgAnd = (ImageView)findViewById(R.id.ImgAnd);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chk.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    Start.setVisibility(View.VISIBLE);
                    Finish.setVisibility(View.VISIBLE);
                    imgAnd.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    Start.setVisibility(View.INVISIBLE);
                    Finish.setVisibility(View.INVISIBLE);
                    imgAnd.setVisibility(View.INVISIBLE);
                }
            }
        });

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
           public void onCheckedChanged(RadioGroup radioGroup, int i){
               switch (rGroup1.getCheckedRadioButtonId()){
                   case R.id.Q:
                       imgAnd.setImageResource(R.drawable.andq);break;
                   case R.id.R:
                       imgAnd.setImageResource(R.drawable.andr);break;
                   case R.id.S:
                       imgAnd.setImageResource(R.drawable.ands);break;
                   }
           }
        });

        Finish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });

        Start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                chk.setChecked(false);
                q.setChecked(false);
                r.setChecked(false);
                s.setChecked(false);
                imgAnd.setImageResource(0);
            }
        });

    }
}