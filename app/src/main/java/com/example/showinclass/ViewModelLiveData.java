package com.example.showinclass;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelLiveData extends ViewModel {
    private MutableLiveData<Integer> LikedNumber;

    public MutableLiveData<Integer> getLikedNumber() {
        if(LikedNumber==null){
            LikedNumber=new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }
    public void addLike(int n){
        LikedNumber.setValue(LikedNumber.getValue()+n);
    }
}
