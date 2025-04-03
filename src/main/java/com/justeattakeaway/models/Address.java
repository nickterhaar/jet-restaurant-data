package com.justeattakeaway.models;

import lombok.Data;

@Data
public class Address {
    private String firstLine;
    private String postalCode;
    private String city;

    public Address(String firstLine, String postalCode, String city) {
        this.firstLine = firstLine;
        this.postalCode = postalCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return (firstLine.isEmpty() ? "" : firstLine) + (city.isEmpty() ? "" : ", " + city) + (postalCode.isEmpty() ? "" : " " + postalCode);
    }
}
