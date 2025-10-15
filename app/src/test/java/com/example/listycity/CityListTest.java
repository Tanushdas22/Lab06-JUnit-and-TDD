package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");

    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City existingCity = mockCity();
        City nonExistingCity = new City("Vancouver", "British Columbia");
        
        // Test with existing city
        assertTrue(cityList.hasCity(existingCity));
        
        // Test with non-existing city
        assertFalse(cityList.hasCity(nonExistingCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City existingCity = mockCity();
        City nonExistingCity = new City("Vancouver", "British Columbia");
        
        // Test deleting existing city
        int originalSize = cityList.countCities();
        cityList.delete(existingCity);
        assertEquals(originalSize - 1, cityList.countCities());
        assertFalse(cityList.hasCity(existingCity));
        
        // Test deleting non-existing city throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(nonExistingCity);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        
        // Test empty list
        assertEquals(0, cityList.countCities());
        
        // Add one city
        City city1 = new City("Toronto", "Ontario");
        cityList.add(city1);
        assertEquals(1, cityList.countCities());
        
        // Add another city
        City city2 = new City("Montreal", "Quebec");
        cityList.add(city2);
        assertEquals(2, cityList.countCities());
    }

    @Test
    void testCityEquals() {
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Edmonton", "Alberta");
        City city3 = new City("Calgary", "Alberta");
        City city4 = new City("Edmonton", "British Columbia");
        
        // Test equal cities
        assertTrue(city1.equals(city2));
        
        // Test different city names
        assertFalse(city1.equals(city3));
        
        // Test different provinces
        assertFalse(city1.equals(city4));
        
        // Test null
        assertFalse(city1.equals(null));
        
        // Test same object
        assertTrue(city1.equals(city1));
    }

    @Test
    void testCityHashCode() {
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Edmonton", "Alberta");
        City city3 = new City("Calgary", "Alberta");
        
        // Equal objects should have equal hash codes
        assertEquals(city1.hashCode(), city2.hashCode());
        
        // Different objects should have different hash codes (likely)
        assertNotEquals(city1.hashCode(), city3.hashCode());
    }

}