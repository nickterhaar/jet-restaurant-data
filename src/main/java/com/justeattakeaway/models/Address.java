package com.justeattakeaway.models;

public class Address {
    private String firstLine;
    private String postalCode;
    private String city;

    public Address(String firstLine, String postalCode, String city) {
        this.firstLine = firstLine;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return (firstLine.isEmpty() ? "" : ", " + firstLine) + (postalCode.isEmpty() ? "" : ", " + postalCode) + (city.isEmpty() ? "" : ", " + city);
    }
}
