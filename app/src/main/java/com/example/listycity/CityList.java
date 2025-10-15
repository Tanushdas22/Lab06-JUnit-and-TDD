package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that maintains a list of City objects.
 * Provides functionality to add, remove, check for existence, and count cities.
 * Cities are maintained in a sorted order when retrieved.
 */
public class CityList {

    private List<City> cities = new ArrayList<>();


    /**
     * Adds a city to the list if it does not already exist.
     * @param city the city to add to the list
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }


    /**
     * Returns a sorted list of all cities in the list.
     * Cities are sorted alphabetically by city name.
     * @return a sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a city exists in the list
     * @param city The city to check for existence
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This removes a city from the list if it exists
     * @param city The city to remove from the list
     * @throws IllegalArgumentException if the city is not found in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns the number of cities in the list
     * @return The count of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
