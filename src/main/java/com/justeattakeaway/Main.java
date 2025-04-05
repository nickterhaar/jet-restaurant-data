package com.justeattakeaway;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justeattakeaway.models.Restaurant;
import com.justeattakeaway.parsers.RestaurantParser;
import com.justeattakeaway.services.RestaurantService;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String API_URL = "https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/";
    private static final String POSTALCODE_REGEX = "^[A-Z]{1,2}[0-9][0-9A-Z]?\\s?[0-9][A-Z]{2}$";
    private static final int RESULT_LIMIT = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String postalCode;

        while (true) {
            System.out.print("Enter a UK Postal Code (or type 'Quit' to exit): ");
            postalCode = scanner.nextLine().toUpperCase().trim();

            if (postalCode.equalsIgnoreCase("QUIT")) {
                System.out.println("Bye bye!");
                break;
            }

            if (isValidPostalCode(postalCode)) {
                System.out.println("\nResults for: " + postalCode + "\n");
                String formattedPostalcode = postalCode.trim().replaceAll("\\s+", "");

                try {
                    String jsonResponse = fetchRestaurantData(formattedPostalcode);
                    displayParsedRestaurants(jsonResponse);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("\nInvalid (UK) Postal Code. Please enter a valid (UK) Postal Code.\n");
            }
        }
    }

    private static String fetchRestaurantData(String postalCode) {
        HttpGet getRequest = new HttpGet(API_URL + postalCode);
        CloseableHttpClient client = HttpClients.createDefault();

        String response = null;
        try {
            response = client.execute(getRequest, new BasicHttpClientResponseHandler());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    private static void displayParsedRestaurants(String jsonResponse) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse);
        JsonNode restaurantsNode = rootNode.path("restaurants");

        if (restaurantsNode.isEmpty()) {
            System.out.println("No results!");
            System.out.println("----------------------------------------\n");
        } else {
            List<Restaurant> restaurants = RestaurantParser.parseRestaurants(restaurantsNode);

            if (restaurants.size() > RESULT_LIMIT) {
                restaurants = restaurants.subList(0, RESULT_LIMIT);
            }

            RestaurantService.displayRestaurants(restaurants);
        }

    }

    private static boolean isValidPostalCode(String postalCode) {
        Pattern pattern = Pattern.compile(POSTALCODE_REGEX);
        Matcher matcher = pattern.matcher(postalCode);
        return matcher.matches();
    }
}