package com.example.showinclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.showinclass.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    DataBindingViewModel dataBindingViewModel;
    ActivityDataBindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_binding);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_data_binding);
        dataBindingViewModel= ViewModelProviders.of(this).get(DataBindingViewModel.class);
        binding.setData(dataBindingViewModel);
        binding.setLifecycleOwner(this);

    }
}