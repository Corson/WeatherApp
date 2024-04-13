package com.pawellal.weatherapp.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pawellal.weatherapp.R;
import com.pawellal.weatherapp.weather.viewmodel.SharedObject;
import com.pawellal.weatherapp.weather.viewmodel.SharedViewModel;

public class SimpleWeatherDataFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_weather_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareButtons(view);
        logSharedObject();
    }

    private void prepareButtons(View view) {
        prepareForecastButton(view);
    }

    /**
     * Logs information about object shared from WeatherActivity.
     * PROS: data is available everywhere inside activity
     * it can be send in an object without serialization
     * pretty fast
     * CONS: data is available everywhere inside activity (and one may not want it)
     * not a one-liner solution ;)
     */
    private void logSharedObject() {
        ViewModelProvider viewModelProvider = new ViewModelProvider(requireActivity());
        SharedViewModel sharedViewModel = viewModelProvider.get(SharedViewModel.class);
        SharedObject data = sharedViewModel.getData();
        String message = String.format("Shared view model data: temperature: %d, description: %s", data.getTemperature(), data.getDescription());
        Log.d(getClass().getName(), message);
    }

    /**
     * Prepare forecast button and send predefined bundle to forecast fragment on click.
     * @param view current view.
     */
    private void prepareForecastButton(View view) {
        Bundle bundle = prepareBundle();
        Button forecastButton = view.findViewById(R.id.forecastButton);
        forecastButton.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_simpleWeatherDataFragment_to_forecastWeatherDataFragment, bundle);
        });
    }

    /**
     * Prepare bundle used to send data.
     * PROS: map-like structure, relatively easy to use.
     * CONS: objects send this way need to be serialized.
     * @return prepared bundle.
     */
    private Bundle prepareBundle() {
       Bundle bundle = new Bundle();
       bundle.putInt("temperature", 21);
       bundle.putString("description", "cloudy");
       return bundle;
    }
}