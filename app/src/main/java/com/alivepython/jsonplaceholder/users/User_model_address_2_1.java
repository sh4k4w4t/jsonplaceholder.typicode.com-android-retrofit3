package com.alivepython.jsonplaceholder.users;

public class User_model_address_2_1 {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private User_model_geo_1 geo;

    public User_model_address_2_1() {
    }

    public User_model_address_2_1(String street, String suite, String city, String zipcode, User_model_geo_1 geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public User_model_geo_1 getGeo() {
        return geo;
    }
}
