package com.justeattakeaway.parsers;

import com.fasterxml.jackson.databind.JsonNode;
import com.justeattakeaway.models.Address;
import com.justeattakeaway.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantParser {
    public static List<Restaurant> parseRestaurants(JsonNode restaurants) {
        List<Restaurant> restaurantList = new ArrayList<>();

        for (JsonNode restaurant : restaurants) {
            String name = restaurant.path("name").asText("Unknown Name");

            List<String> cuisineList = new ArrayList<>();
            JsonNode cuisinesNode = restaurant.path("cuisines");
            if (cuisinesNode.isArray()) {
                for (JsonNode cuisine : cuisinesNode) {
                    cuisineList.add(cuisine.path("name").asText("Unknown Cuisine"));
                }
            }

            double rating = restaurant.path("rating").path("starRating").asDouble(0.0);

            JsonNode addressNode  = restaurant.path("address");
            Address address = new Address(
                addressNode.path("firstLine").asText("Unknown Address"),
                addressNode.path("postalCode").asText(""),
                addressNode.path("city").asText()
            );

            restaurantList.add(new Restaurant(name, cuisineList, rating, address));
        }
        return restaurantList;
    }
}
