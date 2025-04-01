package com.justeattakeaway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String API_URL = "https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a UK postcode: ");
        String postcode = scanner.nextLine();
        System.out.println("Results for: " + postcode + "\n");
        String formattedPostcode = postcode.trim().replaceAll("\\s+", "");


        try {
            String jsonResponse = fetchRestaurantData(formattedPostcode);
            displayRestaurants(jsonResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String fetchRestaurantData(String postcode) {
        HttpGet getRequest = new HttpGet(API_URL + postcode);
        CloseableHttpClient client = HttpClients.createDefault();

        String response = null;
        try {
            response = client.execute(getRequest, new BasicHttpClientResponseHandler());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    private static void displayRestaurants(String jsonResponse) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode rootNode = mapper.readTree(jsonResponse);
//        JsonNode restaurants = rootNode.path("restaurants");
//
//        if (restaurants.isArray()) {
//            int count = 0;
//            for (JsonNode restaurant : restaurants) {
//                if (count >= 10) break;
//                String name = restaurant.path("name").asText();
//                String cuisines = restaurant.path("cuisines").isArray()
//                    ? restaurant.path("cuisines").findValuesAsText("name").toString()
//                    : "N/A";
//                double rating = restaurant.path("rating").path("starRating").asDouble();
//                String address = restaurant.path("address").path("firstLine").asText() + ", "
//                    + restaurant.path("address").path("postalCode").asText() + ", "
//                    + restaurant.path("address").path("city").asText();
//
//                System.out.println("Name: " + name);
//                System.out.println("Cuisines: " + cuisines);
//                System.out.println("Rating: " + rating);
//                System.out.println("Address: " + address);
//                System.out.println("----------------------------------------");
//                count++;
//            }
//        } else {
//            System.out.println("No restaurants found for the given postcode.");
//        }
    }
}