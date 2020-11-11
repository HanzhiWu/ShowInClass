package com.example.showinclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NoViewModelActivity extends AppCompatActivity {
    int number=0;
    TextView textView;
    Button button1,button2,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_view_model);
        textView=findViewById(R.id.text);
        button1=findViewById(R.id.button_add_1);
        button2=findViewById(R.id.button_add_2);
        next=findViewById(R.id.button_next);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                textView.setText(String.valueOf(number));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number+=2;
                textView.setText(String.valueOf(number));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NoViewModelActivity.this,LiveDataActivity.class);
                startActivity(intent);
            }
        });
    }
}