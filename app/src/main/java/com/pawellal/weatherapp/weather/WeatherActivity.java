package com.pawellal.weatherapp.weather;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.pawellal.weatherapp.R;
import com.pawellal.weatherapp.weather.viewmodel.SharedObject;
import com.pawellal.weatherapp.weather.viewmodel.SharedViewModel;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        fillViewModel();
    }

    /**
     * Fills viewModel that can be later used in any fragment inside WeatherActivity.
     */
    private void fillViewModel() {
        SharedViewModel viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        SharedObject sharedObject = new SharedObject(14, "windy");
        viewModel.setData(sharedObject);
    }
}