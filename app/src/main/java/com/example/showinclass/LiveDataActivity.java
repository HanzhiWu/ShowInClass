package com.example.showinclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LiveDataActivity extends AppCompatActivity {
    ViewModelLiveData viewModelLiveData;
    TextView textView;
    ImageView like,dislike;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        textView=findViewById(R.id.text);
        like=findViewById(R.id.button_add_1);
        dislike=findViewById(R.id.button_add_2);
        next=findViewById(R.id.button_next);
        viewModelLiveData=ViewModelProviders.of(this).get(ViewModelLiveData.class);
        /************************/


        viewModelLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });



        /************************/
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelLiveData.addLike(1);
            }
        });
        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewModelLiveData.getLikedNumber().getValue()>0){
                    viewModelLiveData.addLike(-1);
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LiveDataActivity.this,DataBindingActivity.class);
                startActivity(intent);
            }
        });
    }
}