package com.pawellal.weatherapp.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pawellal.weatherapp.R;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareButtons(view);
    }

    private void prepareButtons(View view) {
        prepareWeatherButton(view);
        prepareAstronomyButtonButton(view);
    }

    private void prepareWeatherButton(View view) {
        Button weatherButton = view.findViewById(R.id.weatherButton);
        weatherButton.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_home_to_weatherActivity);
        });
    }

    private void prepareAstronomyButtonButton(View view) {
        Button astronomyButton = view.findViewById(R.id.astronomyButton);
        astronomyButton.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_home_to_astronomy_nav_graph);
        });
    }
}