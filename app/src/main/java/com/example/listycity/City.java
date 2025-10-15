package com.example.listycity;

/**
 * Represents a city with its name and province.
 * This class implements Comparable to allow cities to be sorted alphabetically by city name.
 */
public class City implements Comparable<Object>{
    private String city;
    private String province;
    
    /**
     * Constructs a new City object with the specified city name and province.
     * @param city the name of the city
     * @param province the name of the province where the city is located
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    
    /**
     * Gets the name of the city.
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }
    
    /**
     * Gets the name of the province where the city is located.
     * @return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city with another city for order based on city name.
     * @param o the object to be compared
     * @return a negative integer, zero, or a positive integer as this city name
     *         is less than, equal to, or greater than the specified city name
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two City objects are considered equal if they have the same city name and province.
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return this.city.equals(city.city) && this.province.equals(city.province);
    }

    /**
     * Returns a hash code value for the object.
     * The hash code is computed by combining the hash codes of the city name and province.
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return city.hashCode() + province.hashCode();
    }
}
