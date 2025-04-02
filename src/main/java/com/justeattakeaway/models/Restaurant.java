package com.justeattakeaway.models;

import java.util.List;

public class Restaurant {
    private String name;
    private List<String> cuisines;
    private double rating;
    private Address address;

    public Restaurant(String name, List<String> cuisines, double rating, Address address) {
        this.name = name;
        this.cuisines = cuisines;
        this.rating = rating;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public double getRating () {
        return rating;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + name +
            "\nCuisines: " + (cuisines.isEmpty() ? "N/A" : String.join(", ", cuisines)) +
            "\nRating: " + rating +
            "\nAddress: " + address +
            "\n----------------------------------------";
    }
}
