package com.pawellal.weatherapp.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pawellal.weatherapp.R;
import com.pawellal.weatherapp.weather.viewmodel.SharedObject;
import com.pawellal.weatherapp.weather.viewmodel.SharedViewModel;

public class ForecastWeatherDataFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_weather_data, container, false);
        processBundle();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logSharedObject();
    }

    /**
     * Receive bundle send from SimpleWeatherDataFragment.
     * PROS: works I guess???
     * CONS: every value need to be read from map separately (with no check if it exists)
     * one must know the key (or use an enum for them)
     */
    private void processBundle() {
        Bundle bundle = getArguments();
        if (null != bundle) {
            int temperature = bundle.getInt("temperature");
            String description = bundle.getString("description");
            String message = String.format("Received bundle: temperature: %d, description: %s", temperature, description);
            Log.d(getClass().getName(), message);
        }
    }

    /**
     * Logs information about object shared from WeatherActivity (again!)
     * PROS: data is available everywhere inside activity
     * it can be send in an object without serialization
     * pretty fast
     * CONS: not a one-liner solution ;)
     */
    private void logSharedObject() {
        ViewModelProvider viewModelProvider = new ViewModelProvider(requireActivity());
        SharedViewModel sharedViewModel = viewModelProvider.get(SharedViewModel.class);
        SharedObject data = sharedViewModel.getData();
        String message = String.format("Shared view model data: temperature: %d, description: %s", data.getTemperature(), data.getDescription());
        Log.d(getClass().getName(), message);
    }
}