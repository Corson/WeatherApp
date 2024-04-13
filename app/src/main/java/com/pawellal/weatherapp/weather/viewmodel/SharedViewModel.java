package com.pawellal.weatherapp.weather.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<SharedObject> data = new MutableLiveData<>();

    public void setData(SharedObject value) {
        data.setValue(value);
    }

    public SharedObject getData() {
        return data.getValue();
    }

}
