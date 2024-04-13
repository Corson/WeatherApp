package com.pawellal.weatherapp.weather.viewmodel;

public class SharedObject {

    private final int temperature;
    private final String description;

    public SharedObject(int temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}
