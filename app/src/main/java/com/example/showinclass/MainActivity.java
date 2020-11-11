package com.example.showinclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public MyViewModel myViewModel;
    TextView textView;
    Button button1,button2,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        textView=findViewById(R.id.text);
        button1=findViewById(R.id.button_add_1);
        button2=findViewById(R.id.button_add_2);
        next=findViewById(R.id.button_next);
        textView.setText(String.valueOf(myViewModel.number));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number++;
                textView.setText(String.valueOf(myViewModel.number));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number+=2;
                textView.setText(String.valueOf(myViewModel.number));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NoViewModelActivity.class);
                startActivity(intent);
            }
        });
    }
}