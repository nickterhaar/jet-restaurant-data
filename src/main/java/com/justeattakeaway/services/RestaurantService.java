package com.justeattakeaway.services;

import com.justeattakeaway.models.Restaurant;

import java.util.List;

public class RestaurantService {
    public static void displayRestaurants(List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}
