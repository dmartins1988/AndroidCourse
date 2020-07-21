package com.example.viewmodelexample.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> _addThree = new MutableLiveData<>();
    private MutableLiveData<String> _addThreeDuplicate = new MutableLiveData<>();

    public void addThree(final String number) {
        final int integer = Integer.parseInt(number);
        final int add = integer + 3;
        _addThree.setValue(String.valueOf(add));
    }

    public void addThreeDuplicate(final String number) {
        final int integer = Integer.parseInt(number);
        final int add = integer + 3;
        _addThreeDuplicate.setValue(String.valueOf(add));
    }

    public LiveData<String> get_addThree() {
        return _addThree;
    }

    public LiveData<String> get_addThreeDuplicate() {
        return _addThreeDuplicate;
    }
}