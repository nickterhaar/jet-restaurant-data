package com.justeattakeaway.models;

import lombok.Data;

import java.util.List;

@Data
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

    @Override
    public String toString() {
        return
            "----------------------------------------\n" +
            "Name: " + name +
            "\nCuisines: " + (cuisines.isEmpty() ? "N/A" : String.join(", ", cuisines)) +
            "\nRating: " + rating +
            "\nAddress: " + address +
            "\n----------------------------------------\n";
    }
}
